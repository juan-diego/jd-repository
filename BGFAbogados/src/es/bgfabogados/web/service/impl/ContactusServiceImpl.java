package es.bgfabogados.web.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import es.bgfabogados.web.bean.IDelivery;
import es.bgfabogados.web.bean.IEmail;
import es.bgfabogados.web.bean.IEmailContent;
import es.bgfabogados.web.bean.IEmailTemplate;
import es.bgfabogados.web.bean.impl.DeliveryImpl;
import es.bgfabogados.web.bean.impl.EmailTemplateImpl;
import es.bgfabogados.web.delegate.IEmailDelegate;
import es.bgfabogados.web.form.IForm;
import es.bgfabogados.web.form.impl.ContactusFormImpl;

/**
 * Provides services for flow: Contact us.
 * 
 * @author juan-diego
 */
@Service("contactusService")
public class ContactusServiceImpl {

	/**
	 * <p>
	 * Configuration to be injected to the service.
	 * </p>
	 * <p>
	 * This inner class enable inject all the configuration with one single
	 * bean.
	 * </p>
	 * 
	 * @author juan-diego
	 */
	public static class Configuration {
		/**
		 * File that contains the plain text template for the emial body.
		 */
		private Resource textTemplate;

		/**
		 * File that contains the plain html template for the emial body.
		 */
		private Resource htmlTemplate;

		/**
		 * Address to which email will be sent.
		 */
		private InternetAddress toAddress;

		/**
		 * Debug commands that can modify service behaviour for testing
		 * purposes.
		 */
		private String debugCommands;

		/**
		 * Address from which email will be sent.
		 */
		private InternetAddress fromAddress;

		/**
		 * @return the textTemplate
		 */
		public Resource getTextTemplate() {
			return textTemplate;
		}

		/**
		 * @param textTemplate
		 *            the textTemplate to set
		 */
		public void setTextTemplate(Resource textTemplate) {
			this.textTemplate = textTemplate;
		}

		/**
		 * @return the htmlTemplatE
		 */
		public Resource getHtmlTemplatE() {
			return htmlTemplate;
		}

		/**
		 * @param htmlTemplatE
		 *            the htmlTemplatE to set
		 */
		public void setHtmlTemplate(Resource htmlTemplate) {
			this.htmlTemplate = htmlTemplate;
		}

		/**
		 * @return the toAddress
		 */
		public InternetAddress getToAddress() {
			return toAddress;
		}

		/**
		 * @param toAddress
		 *            the toAddress to set
		 */
		public void setToAddress(InternetAddress toAddress) {
			this.toAddress = toAddress;
		}

		/**
		 * @return the fromAddress
		 */
		public InternetAddress getFromAddress() {
			return fromAddress;
		}

		/**
		 * @param fromAddress
		 *            the fromAddress to set
		 */
		public void setFromAddress(InternetAddress fromAddress) {
			this.fromAddress = fromAddress;
		}

		/**
		 * @return the debugCommands
		 */
		public String getDebugCommands() {
			return debugCommands;
		}

		/**
		 * @param debugCommands
		 *            the debugCommands to set
		 */
		public void setDebugCommands(String debugCommands) {
			this.debugCommands = debugCommands;
		}

		/**
		 * @return the htmlTemplate
		 */
		public Resource getHtmlTemplate() {
			return htmlTemplate;
		}

		/**
		 * Check if the configuration is valid.
		 * 
		 * @return {@code  true} if it is valid.
		 */
		public static boolean isValid(Configuration configuration) {
			return configuration.htmlTemplate != null
					&& configuration.textTemplate != null
					&& configuration.toAddress != null
					&& configuration.fromAddress != null;
		}
	}

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(ContactusServiceImpl.class.getName());

	/**
	 * Token to be replaced with sender name and/or address.
	 */
	private static final String TOKEN_SENDER_NAME = "\\$\\{sender\\.name\\}";

	/**
	 * Token to be replaced with sender email address.
	 */
	private static final String TOKEN_SENDER_EMAIL = "\\$\\{sender\\.email\\}";

	/**
	 * Token to be replaced with message subject.
	 */
	private static final String TOKEN_SUBJECT = "\\$\\{subject\\}";

	/**
	 * Token to be replaced with message body.
	 */
	private static final String TOKEN_BODY = "\\$\\{body\\}";

	/**
	 * Template used for composing the emails.
	 */
	private IEmailTemplate emailTemplate = new EmailTemplateImpl();

	/**
	 * Delegate used for sending eMails.
	 */
	@Autowired(required = true)
	private IEmailDelegate emailDelegate;

	/**
	 * Service configuration.
	 */
	@Autowired(required = true)
	private ContactusServiceImpl.Configuration configuration;

	/**
	 * @param emailDelegate
	 *            the emailDelegate to set
	 */
	public void setEmailDelegate(IEmailDelegate emailDelegate) {
		this.emailDelegate = emailDelegate;
	}

	/**
	 * @param configuration
	 *            the configuration to set
	 */
	public void setConfiguration(
			ContactusServiceImpl.Configuration configuration) {
		if (!Configuration.isValid(configuration)) {
			throw new IllegalArgumentException(
					"The configuration is not valid. At least one property is null.");
		} else {
			this.configuration = configuration;
		}
	}

	/**
	 * @return A new uninitialized instance of {@link ContactusFormImpl}.
	 */
	public IForm newForm() {
		return new ContactusFormImpl();
	}

	/**
	 * Composes and sends an eMail using the information collected in the form.
	 * 
	 * @param form
	 *            Data to be sent. It cannot be null.
	 * @return Sent result. Delivery status will be Success if the eMail was
	 *         successfully sent to the destination. Any other status will mean
	 *         that the eMail could not be sent.
	 */
	public IDelivery sendEmail(ContactusFormImpl form) {

		// Validate configuration
		if (!Configuration.isValid(configuration)) {
			throw new IllegalStateException(
					"Configuration has not been properly set. It or any of its properties is null.");
		}

		// Validate arguments
		if (form == null) {
			throw new IllegalArgumentException("Argument form cannot be null.");
		} else if (form.getName() == null) {
			throw new IllegalArgumentException(
					"Argument form.name cannot be null.");
		} else if (form.getEmail() == null) {
			throw new IllegalArgumentException(
					"Argument form.email cannot be null.");
		} else if (form.getSubject() == null) {
			throw new IllegalArgumentException(
					"Argument form.subject cannot be null.");
		} else if (form.getComments() == null) {
			throw new IllegalArgumentException(
					"Argument form.comments cannot be null.");
		}

		// Debug - Command that enable us to test the error page.
		if (configuration.getDebugCommands() != null
				&& configuration.getDebugCommands().equals(form.getName())) {
			IDelivery delivery = new DeliveryImpl();
			delivery.setStatus(IDelivery.Status.Failed);
			return delivery;
		}

		// Compose email
		IEmail email = emailDelegate.newEmail();
		email.setSender(configuration.fromAddress.getAddress());
		email.setRecipient(configuration.toAddress.getAddress());
		email.setSubject(form.getSubject());
		email.setContent(getEmailContent(form));

		// Send
		IDelivery delivery = null;
		try {
			delivery = emailDelegate.send(email);
		} catch (Exception ex) {
			LOGGER.log(Level.WARNING, "Contact us eMail could not be sent.", ex);

			delivery = new DeliveryImpl();
			delivery.setStatus(IDelivery.Status.Failed);
		}
		return delivery;
	}

	/**
	 * Builds the content by inserting form data in loaded templates.
	 * 
	 * @param form
	 *            Data received from view layer.
	 * @return A new instance of {@link IEmailContent} or null if the form is
	 *         null or if templates are not available.
	 */
	private IEmailContent getEmailContent(ContactusFormImpl form) {
		if (form == null || emailTemplate == null) {
			return null;
		}
		Map<String, String> replacements = getReplacements(form);
		IEmailContent content = emailDelegate.newContent();
		content.setContent(emailTemplate.resolveHtml(replacements));
		return content;
	}

	/**
	 * Get a new map of replacemets to be applied on an eMail template.
	 * 
	 * @param email
	 *            eMail data.
	 * @return A list of replacements that can be passed to an eMail template.
	 */
	private Map<String, String> getReplacements(ContactusFormImpl form) {
		if (form == null) {
			return null;
		}
		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put(TOKEN_SENDER_NAME, form.getName());
		replacements.put(TOKEN_SENDER_EMAIL, form.getEmail());
		replacements.put(TOKEN_SUBJECT, form.getSubject());
		replacements.put(TOKEN_BODY, form.getComments());
		return replacements;
	}

	/**
	 * Load email templates from resources set in configuration.
	 * 
	 * @throws IOException
	 *             If templates could not be loaded.
	 */
	@PostConstruct
	private void loadTemplates() throws IOException {
		emailTemplate.loadTextTemplate(configuration.getTextTemplate()
				.getFilename());
		emailTemplate.loadHtmlTemplate(configuration.getHtmlTemplatE()
				.getFilename());
	}
}

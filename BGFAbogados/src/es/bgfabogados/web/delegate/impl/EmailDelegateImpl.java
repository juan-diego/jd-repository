package es.bgfabogados.web.delegate.impl;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import es.bgfabogados.web.bean.IDelivery;
import es.bgfabogados.web.bean.IEmail;
import es.bgfabogados.web.bean.IEmailContent;
import es.bgfabogados.web.bean.IEmailTemplate;
import es.bgfabogados.web.bean.impl.DeliveryImpl;
import es.bgfabogados.web.bean.impl.EmailContentImpl;
import es.bgfabogados.web.bean.impl.EmailImpl;
import es.bgfabogados.web.bean.impl.EmailTemplateImpl;
import es.bgfabogados.web.delegate.IEmailDelegate;

/**
 * Delegate for eMails management.
 * 
 * @author juan-diego
 */
@Controller
public class EmailDelegateImpl implements IEmailDelegate {
	
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
	 * Account used for eMail delivery.
	 */
	private Address deliveryAccount;

	/**
	 * @param deliveryAccount the deliveryAccount to set
	 */
	@Autowired(required=true)
	@Qualifier("deliveryAccount")
	public void setDeliveryAccount(Address deliveryAccount) {
		this.deliveryAccount = deliveryAccount;
	}

	/**
	 * @param emailHtmlTemplate the emailHtmlTemplate to set. Can not be null.
	 * @throws IOException If template content can not be loaded.
	 */
	@Autowired(required=true)
	@Qualifier("emailHtmlTemplate")
	public void setEmailHtmlTemplate(Resource template) throws IOException {
		if (template == null) {
			throw new IllegalArgumentException("Argument 'template' can not be null.");
		}
		this.emailTemplate.loadHtmlTemplate(template.getFilename());
	}

	/**
	 * @param emailTextTemplate the emailTextTemplate to set. Can not be null.
	 * @throws IOException If template content can not be loaded.
	 */
	@Autowired(required=true)
	@Qualifier("emailTextTemplate")
	public void setEmailTextTemplate(Resource template) throws IOException {
		if (template == null) {
			throw new IllegalArgumentException("Argument 'template' can not be null.");
		}
		this.emailTemplate.loadTextTemplate(template.getFilename());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEmail newEmail() {
		return new EmailImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEmailContent newContent() {
		return new EmailContentImpl();
	}

	/**
	 * {@inheritDoc}
	 * @throws MessagingException IF the eMail could not be sent.
	 */
	@Override
	public IDelivery send(IEmail email) throws MessagingException {
		Map<String, String> replacements = getReplacements(email);
		
		String html = emailTemplate.resolveHtml(replacements);
		String text = emailTemplate.resolveText(replacements);
		
		// TO-DO : Escape HTML characters in HTML template.
		// TO-DO : Validate email.
		
		// Initialize message
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage msg = new MimeMessage(session);
		
		// Add sender
		msg.setFrom(deliveryAccount);
		
		// Add recipients
		InternetAddress internetAddress = null;
		for(String emailAddress : email.getRecipients()) {
			if (emailAddress != null) {
				try {
					internetAddress = new InternetAddress(emailAddress);
				} catch (AddressException ex) {
					String error = MessageFormat.format("Recipient address '{0}' is not valid.", emailAddress);
					throw new IllegalArgumentException(error, ex);
				}
				msg.addRecipient(javax.mail.Message.RecipientType.TO, internetAddress);
			}	
		}
		
		// Validate recipients
		int numOfRecipients = msg.getRecipients(javax.mail.Message.RecipientType.TO).length;
		if (numOfRecipients == 0) {
			throw new IllegalArgumentException("Error compiling eMail's recipients list. Any valid eMail address was found.");
		}

        // Create the Multipart.  Add BodyParts to it.
        final Multipart mp = new MimeMultipart();
		
		// Unformatted text version
		if (text!=null && text.length() > 0) {
	        final MimeBodyPart textPart = new MimeBodyPart();
	        textPart.setText(text);
	        mp.addBodyPart(textPart);
		}
        // HTML version
		if (html!=null && html.length() > 0) {
	        final MimeBodyPart htmlPart = new MimeBodyPart();
	        htmlPart.setContent(html, "text/html");
	        mp.addBodyPart(htmlPart);
		}
       
       
        // Set Multipart as the message's content
        msg.setContent(mp, "UTF8");
		
		// Send message		
		IDelivery delivery = new DeliveryImpl();
		delivery.setStatus(IDelivery.Status.Success);
		return delivery;
	}
	
	/**
	 * Get a new map of replacemets to be applied on an eMail template.
	 * 
	 * @param email eMail data.
	 * @return A list of replacements that can be passed to an eMail template.
	 */
	private Map<String, String> getReplacements(IEmail email) {
		if (email == null) {
			return null;
		}
		Map<String, String> replacements = new HashMap<String, String>();
		if (email.getSender() != null) {
			replacements.put(TOKEN_SENDER_NAME, email.getSender().getName());
			replacements.put(TOKEN_SENDER_EMAIL, email.getSender().getEmail());
		}
		replacements.put(TOKEN_SUBJECT, email.getSubject());
		IEmailContent content = email.getContent();
		if (content != null) {
			replacements.put(TOKEN_BODY, email.getContent().getText());
		}
		return replacements;
	}
}

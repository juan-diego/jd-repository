package es.bgfabogados.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.bgfabogados.web.bean.IContact;
import es.bgfabogados.web.bean.IDelivery;
import es.bgfabogados.web.bean.IEmail;
import es.bgfabogados.web.bean.IEmailContent;
import es.bgfabogados.web.bean.impl.ContactImpl;
import es.bgfabogados.web.bean.impl.DeliveryImpl;
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
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(ContactusServiceImpl.class.getName());
	
	/**
	 * Address where email will be addressed.
	 */
	private IContact emailDestination;

	/**
	 * Delegate used for sending eMails.
	 */
	private IEmailDelegate emailDelegate;
	
	/**
	 * @param emailDestination the emailDestination to set
	 */
	@Autowired(required=true)
	@Qualifier("contactusDestination")
	public void setEmailDestination(IContact emailDestination) {
		this.emailDestination = emailDestination;
	}
	
	/**
	 * @return A new uninitialized instance of {@link ContactusFormImpl}.
	 */
	public IForm newForm() {
		return new ContactusFormImpl();
	}

	/**
	 * @return the emailDelegate
	 */
	public IEmailDelegate getEmailDelegate() {
		return emailDelegate;
	}

	/**
	 * @param emailDelegate the emailDelegate to set
	 */
	@Autowired(required=true)
	public void setEmailDelegate(IEmailDelegate emailDelegate) {
		this.emailDelegate = emailDelegate;
	}
	
	/**
	 * Composes and sends an eMail using the information collected in the form.
	 * 
	 * @param form Data to be sent. It cannot be null.
	 * @return Sent result. Delivery status will be Success if the eMail was successfully sent to the destination.
	 * Any other status will mean that the eMail could not be sent.
	 */
	public IDelivery sendEmail(ContactusFormImpl form) {
		// Validate arguments
		if (form == null) {
			throw new IllegalArgumentException("Argument form cannot be null.");
		}
		
		IEmailContent content = emailDelegate.newContent();
		content.setContent(form.getComments());
		
		IContact contact = new ContactImpl();
		contact.setName(form.getName());
		contact.setEmail(form.getEmail());
		
		List<String> recipients = new ArrayList<String>();
		recipients.add(emailDestination.getEmail());
		
		IEmail email = emailDelegate.newEmail();
		email.setSender(contact);
		email.setContent(content);
		email.setRecipients(recipients);
		
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
}

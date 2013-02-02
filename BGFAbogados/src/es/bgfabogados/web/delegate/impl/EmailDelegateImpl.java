package es.bgfabogados.web.delegate.impl;

import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;

import es.bgfabogados.web.bean.IDelivery;
import es.bgfabogados.web.bean.IEmail;
import es.bgfabogados.web.bean.IEmailContent;
import es.bgfabogados.web.bean.impl.DeliveryImpl;
import es.bgfabogados.web.bean.impl.EmailContentImpl;
import es.bgfabogados.web.bean.impl.EmailImpl;
import es.bgfabogados.web.delegate.IEmailDelegate;

/**
 * Delegate for eMails management.
 * 
 * @author juan-diego
 */
@Controller
public class EmailDelegateImpl implements IEmailDelegate {

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
	 * @throws IllegalArgumentException If email is not properly initialized.
	 */
	@Override
	public IDelivery send(IEmail email) throws MessagingException {
		
		// Validate email
		// It will throw an IllegalArgumentException if it is not valid
		validateEmail(email);
		
		// Initialize message
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage msg = new MimeMessage(session);
		
		// Add sender
		InternetAddress fromAddress = null;
		try {
			fromAddress = new InternetAddress(email.getSender().getEmail());
		} catch (AddressException ex) {
			String error = MessageFormat.format("From address '{0}' is not valid.", email.getSender().getEmail());
			throw new IllegalArgumentException(error, ex);
		}
		msg.setFrom(fromAddress);
		
		// Add recipients
		InternetAddress internetAddress = null;
		for(String emailAddress : email.getRecipients()) {
			if (emailAddress != null) {
				try {
					internetAddress = new InternetAddress(emailAddress);
				} catch (AddressException ex) {
					String error = MessageFormat.format("To address '{0}' is not valid.", emailAddress);
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

		msg.setSubject(email.getSubject(), "UTF8");
        msg.setText(email.getContent().getText(), "UTF8", "html");
        Transport.send(msg);
		
		// Send message		
		IDelivery delivery = new DeliveryImpl();
		delivery.setStatus(IDelivery.Status.Success);
		return delivery;
	}
	
	/**
	 * Validate received email by checking that it has been properly initialized.
	 */
	private void validateEmail(IEmail email) {
		if (email == null) {
			throw new IllegalArgumentException("Argument email can not be null");
		} else if (email.getSender() == null) {
			throw new IllegalArgumentException("Argument email.sender can not be null");
		} else if (email.getSender().getEmail() == null) {
			throw new IllegalArgumentException("Argument email.sender.email can not be null");
		} else if (email.getRecipients() == null) {
			throw new IllegalArgumentException("Argument email.recipients can not be null");
		} else if (email.getRecipients() == null) {
			throw new IllegalArgumentException("Argument email.recipients can not be null");
		} else if (email.getSubject() == null) {
			throw new IllegalArgumentException("Argument email.subject can not be null");
		} else if (email.getContent() == null) {
			throw new IllegalArgumentException("Argument email.content can not be null");
		} else if (email.getContent().getText() == null) {
			throw new IllegalArgumentException("Argument email.content.text can not be null");
		}
	}
	
}

/**
 * 
 */
package es.bgfabogados.web.delegate;

import javax.mail.MessagingException;

import es.bgfabogados.web.bean.IDelivery;
import es.bgfabogados.web.bean.IEmail;
import es.bgfabogados.web.bean.IEmailContent;


/**
 * Delegate for eMails management.
 * 
 * @author juan-diego
 */
public interface IEmailDelegate {
	
	/**
	 * @return A new eMail instance.
	 */
	IEmail newEmail();
	
	/**
	 * @return A new content instance.
	 */
	IEmailContent newContent();

	/**
	 * Sends the eMail.
	 * 
	 * @param eMail to be sent. It can not be null.
	 * @return Send result. Delivery status will be Success if the eMail was successfully sent to the destination.
	 * Any other status will mean that the eMail could not be sent.
	 * @throws MessagingException IF the eMail could not be sent.
	 */
	IDelivery send(IEmail eMail) throws MessagingException;
}
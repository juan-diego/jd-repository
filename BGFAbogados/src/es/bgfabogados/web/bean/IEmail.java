package es.bgfabogados.web.bean;

import java.util.List;

/**
 * Represents an electronic mail.
 * 
 * @author juan-diego
 */
public interface IEmail {
	
	/**
	 * @param eMail Sender contact to be set.
	 */
	void setSender(IContact contact);
	
	/**
	 * @param address Sender email address.
	 */
	void setSender(String address);
	
	/**
	 * @return The sender contact.
	 */
	IContact getSender();
	
	/**
	 * @return Destination addresses.
	 */
	List<String> getRecipients();
	
	/**
	 * Sets a new recipients list which includes the eMail address passed as parameter.
	 * 
	 * @param eMailAddr Destination address to set.
	 */
	void setRecipient(String eMailAddr);
	
	/**
	 * @param eMailAddr Destination addresses to set.
	 */
	void setRecipients(List<String> eMailAddr);
	
	/**
	 * @return The subject.
	 */
	String getSubject();
	
	/**
	 * @param subject The subject to set.
	 */
	void setSubject(String subject);
	
	/**
	 * @return The content
	 */
	IEmailContent getContent();
	
	/**
	 * @param The content to set.
	 */
	void setContent(IEmailContent content);
}

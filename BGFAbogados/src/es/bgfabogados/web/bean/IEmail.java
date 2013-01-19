package es.bgfabogados.web.bean;

import java.util.List;

/**
 * Represents an electronic mail.
 * 
 * @author juan-diego
 */
public interface IEmail {
	
	/**
	 * @param eMail Sender address to be set.
	 */
	void setSender(String eMailAddr);
	
	/**
	 * @return The sender eMail address.
	 */
	String getSender();
	
	/**
	 * @return Destination addresses.
	 */
	List<String> getRecipients();
	
	/**
	 * Sets a new recipients list which includes the eMail address passed as parameter.
	 * 
	 * If the received eMail address is null then recipients list will be set to null.
	 * 
	 * @param eMail Destination address to set.
	 */
	void setRecipient(String eMailAddr);
	
	/**
	 * @param eMails Destination addresses to set.
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

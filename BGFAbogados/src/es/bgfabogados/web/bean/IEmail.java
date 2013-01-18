/**
 * 
 */
package es.bgfabogados.web.bean;

import java.util.List;

/**
 * Represents an electronic mail.
 * 
 * @author Juan Diego Suarez
 */
public interface IEmail {

	/**
	 * @return Sender eMail address.
	 */
	String getDestination();
	
	/**
	 * @param eMailAddress The eMail address to set.
	 */
	void setDestination(String eMail);
	
	/**
	 * @return Destination eMail addresses.
	 */
	List<String> getRecipients();
	
	/**
	 * @param eMail The destination eMail address to set.
	 */
	void setRecipient(String eMail);
	
	/**
	 * @param eMails The list of destination eMail addresses to set.
	 */
	void setRecipients(List<String> eMails);
	
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

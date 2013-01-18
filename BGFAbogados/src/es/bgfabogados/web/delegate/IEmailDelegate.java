/**
 * 
 */
package es.bgfabogados.web.delegate;

import es.bgfabogados.web.bean.IEmail;

/**
 * Delegate for eMails management.
 * 
 * @author Juan Diego Suarez.
 */
public interface IEmailDelegate {

	/**
	 * Sends the eMail.  
	 * 
	 * @return {@code true} if the mail was successfully sent or {@code false} in any other case.
	 */
	boolean send(IEmail eMail);
}

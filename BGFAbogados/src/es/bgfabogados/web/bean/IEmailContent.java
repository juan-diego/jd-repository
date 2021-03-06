package es.bgfabogados.web.bean;

/**
 * Represent the content of an eMail.
 * 
 * @author juan-diego
 */
public interface IEmailContent {
	
	/**
	 * @param content Content to set.
	 */
	public void setContent(Object content);
	
	/**
	 * @return The content. 
	 */
	public Object getContent();
	
	/**
	 * @return Returns a string representation of the content.
	 */
	public String getText();
}

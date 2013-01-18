/**
 * 
 */
package es.bgfabogados.web.bean;

/**
 * Represent the content of an eMail.
 * 
 * @author Juan Diego Suarez
 */
public interface IEmailContent {
	
	/**
	 * @param text Text to be set as eMail's content.
	 */
	public void setText(String text);
	
	/**
	 * @param html HTML code to be set as eMail's content.
	 */
	public void setHtml(String html);
	
	/**
	 * @param content to set.
	 */
	public void setContent(Object content);
	
	/**
	 * @return The content formated as plain text. 
	 */
	public String getText();
	
	/**
	 * @return The content formated as HTML. 
	 */
	public String getHtml();
	
	/**
	 * @return The content.
	 */
	public Object getContent();
}

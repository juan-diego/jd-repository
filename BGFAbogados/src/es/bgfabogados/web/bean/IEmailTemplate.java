package es.bgfabogados.web.bean;

import java.io.IOException;
import java.util.Map;

/**
 * Reperesent an email template that can be customized by mean of Regex pattern replacements.
 * 
 * Each template provide different content  
 * 
 * @author jsuarezgonza
 */
public interface IEmailTemplate {

	/**
	 * Load the HTML template from a resource.
	 * 
	 * @param resourcePath Resource path.
	 * @throws IOException If the resource does not exist or if it can not be loaded.
	 */
	void loadHtmlTemplate(String resourcePath) throws IOException;
	
	/**
	 * Load the text template from a resource.
	 * 
	 * @param resourcePath Resource path.
	 * @throws IOException If the resource does not exist or if it can not be loaded.
	 */
	void loadTextTemplate(String resourcePath) throws IOException;
	
	/**
	 * Applies the replacements on the text template and returns the result text.
	 * 
	 * Replacement map must be defined as follow:
	 * <ul>
	 * 	<li>Key - It should be regex expression describing the text to be replaced.</li>
	 *  <li>Key - It should the new text that will replace template's parts that match the key.</li>
	 * </ul>
	 * 
	 * @param replacements Map of replacements.
	 * @return A text that is result of apply all map's replacements on the text template.
	 */
	String resolveText(final Map<String, String> replacements);
	
	/**
	 * Applies the replacements on the text template and returns the result text.
	 * 
	 * Replacement map must be defined as follow:
	 * <ul>
	 * 	<li>Key - It should be regex expression describing the text to be replaced.</li>
	 *  <li>Key - It should the new text that will replace template's parts that match the key.</li>
	 * </ul>
	 * 
	 * @param replacements Map of replacements.
	 * @return A text that is result of apply all map's replacements on the text template.
	 */
	String resolveHtml(final Map<String, String> replacements);
	
	/**
	 * @return The HTML template.
	 */
	String getHtml();
	
	/**
	 * @return The text template
	 */
	String getText();
}

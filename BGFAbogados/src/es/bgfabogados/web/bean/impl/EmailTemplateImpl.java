package es.bgfabogados.web.bean.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import es.bgfabogados.web.bean.IEmailTemplate;

public class EmailTemplateImpl implements IEmailTemplate {

	/**
	 * The HTML template.
	 */
	public String html;
	
	/**
	 * The text template.
	 */
	public String text;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void loadHtmlTemplate(String resourcePath) throws IOException {
		html = loadTemplate(resourcePath);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void loadTextTemplate(String resourcePath) throws IOException {
		text = loadTemplate(resourcePath);
	}

	/**
	 * {@inheritDoc}
	 */
	public String resolveHtml(final Map<String, String> replacements) {
		return resolveTemplate(html, replacements);
	}

	/**
	 * {@inheritDoc}
	 */
	public String resolveText(final Map<String, String> replacements) {
		return resolveTemplate(text, replacements);
	}
	
	/**
	 * Applies the replacements on the received template and returns the result text.
	 * 
	 * Replacement map must be defined as follow:
	 * <ul>
	 * 	<li>Key - It should be regex expression describing the text to be replaced.</li>
	 *  <li>Key - It should the new text that will replace template's parts that match the key.</li>
	 * </ul>
	 * 
	 * @param template Text on which replacement will be applied.
	 * @param replacements Map of replacements.
	 * @return A text that is result of apply all map's replacements on the text template.
	 * If template is null then it will return null.
	 */
	private static String resolveTemplate(final String template, final Map<String, String> replacements) {
		if (template == null || template.length() == 0 || replacements == null || replacements.isEmpty()) {
			return template;
		}
		String content = template;
		for(String regexKey : replacements.keySet()) {
			content = content.replaceAll(regexKey, replacements.get(regexKey));
		}
		return content;
	}


	/**
	 * Load the content of the received resource.
	 * 
	 * @param resourcePath Resource path.
	 * @return The content of the resource.
	 * @throws IOException If the resource does not exist or if its content could not be loaded.
	 */
	private static String loadTemplate(final String resourcePath) throws IOException {
		ByteArrayOutputStream buf = new ByteArrayOutputStream();

		ClassPathResource cpr = new ClassPathResource(resourcePath);
		InputStream in = cpr.getInputStream();

		try {
			BufferedInputStream bis = new BufferedInputStream(in);
			int result = bis.read();
			while (result != -1) {
				byte b = (byte) result;
				buf.write(b);
				result = bis.read();
			}
		} finally {
			in.close();
		}
		return buf.toString();
	}

	/**
	 * @return html
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * @param html html to set.
	 */
	public void setHtml(String html) {
		this.html = html;
	}

	/**
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text text to set.
	 */
	public void setText(String text) {
		this.text = text;
	}
}

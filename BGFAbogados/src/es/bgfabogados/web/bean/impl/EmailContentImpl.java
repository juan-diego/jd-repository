package es.bgfabogados.web.bean.impl;

import es.bgfabogados.web.bean.IEmailContent;

/**
 * Represent the text content of an eMail.
 * 
 * @author juan-diego
 */
public class EmailContentImpl implements IEmailContent {

	/**
	 * The content.
	 */
	private Object content;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setContent(Object content) {
		this.content = content;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getContent() {
		return this.content;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText() {
		if (this.content == null) {
			return null;
		} else {
			return this.content.toString();
		}
	}
}

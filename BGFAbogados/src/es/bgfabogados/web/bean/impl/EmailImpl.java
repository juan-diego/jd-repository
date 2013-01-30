package es.bgfabogados.web.bean.impl;

import java.util.ArrayList;
import java.util.List;

import es.bgfabogados.web.bean.IContact;
import es.bgfabogados.web.bean.IEmail;
import es.bgfabogados.web.bean.IEmailContent;

/**
 * @author diego
 *
 */
public class EmailImpl implements IEmail {
	
	/**
	 * eMail sender.
	 */
	private IContact sender;
	
	/**
	 * eMail destinations.
	 */
	private List<String> recipients;
	
	/**
	 * eMail subject.
	 */
	private String subject;
	
	/**
	 * eMail content.
	 */
	private IEmailContent content;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSender(IContact contact) {
		this.sender = contact;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getRecipients() {
		return this.recipients;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRecipient(String eMailAddr) {
		if (eMailAddr == null) {
			this.recipients = null;;
		}
		this.recipients = new ArrayList<String>();
		this.recipients.add(eMailAddr);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRecipients(List<String> eMailAddr) {
		this.recipients = eMailAddr;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSubject() {
		return this.subject;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEmailContent getContent() {
		return this.content;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setContent(IEmailContent content) {
		this.content = content;
	}

	/**
	 *  {@inheritDoc}
	 */
	@Override
	public IContact getSender() {
		return this.sender;
	}

}

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
	private List<String> recipients = new ArrayList<String>();
	
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
		if (eMailAddr != null) {
			this.recipients.add(eMailAddr);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRecipients(List<String> list) {
		if (list == null) {
			throw new IllegalArgumentException("Argument list can not be null.");
		}
		this.recipients = new ArrayList<String>(list);
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
	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	public void setSender(String address) {
		if (address == null) {
			this.sender = null;
		} else {
			this.sender = new ContactImpl();
			this.sender.setEmail(address);
		}
	}

}

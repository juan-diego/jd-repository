package es.bgfabogados.web.form.impl;

import java.text.MessageFormat;

import es.bgfabogados.web.form.IForm;

/**
 * Contains field used in a "Contact us" form. 
 *
 * @author juan-diego
 */
public class ContactusFormImpl implements IForm {
	
	/**
	 * Template for composing the sender.
	 */
	private static final String SENDER_PATTERN = "{0} <{1}>";

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * User name.
	 */
	private String name;
	
	/**
	 * User eMail.
	 */
	private String email;
	
	/**
	 * User comments.
	 */
	private String comments;
	
	/**
	 * Message subject.
	 */
	private String subject;

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/**
	 * <p>
	 * Return the sender name and email address in the following format:
	 * {@code name <eMail address>}
	 * </p>
	 * 
	 * <p>
	 * 	if the name is null then the email is returned.
	 * </p>
	 * <p>
	 * 	if the email address is null then the name is returned.
	 * </p>
	 * <p>
	 * 	if the name and the email address are null then null is returned.
	 * </p>
	 * 
	 * @return
	 */
	public String getSender() {
		if (this.name == null) {
			if (this.email == null) {
				return null;
			} else {
				return this.email;
			}
		} else {
			if (this.email == null) {
				return this.name;
			} else {
				return MessageFormat.format(SENDER_PATTERN, this.name, this.email);
			}
		}
	}
}

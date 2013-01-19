package es.bgfabogados.web.form.impl;

import es.bgfabogados.web.form.IForm;

/**
 * Contains field used in a "Contact us" form. 
 *
 * @author juan-diego
 */
public class ContactusFormImpl implements IForm {

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
}

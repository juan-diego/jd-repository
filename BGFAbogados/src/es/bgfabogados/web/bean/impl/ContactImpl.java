package es.bgfabogados.web.bean.impl;

import es.bgfabogados.web.bean.IContact;

public class ContactImpl implements IContact {
	
	/**
	 * Contact's name.
	 */
	private String name;
	
	/**
	 * Contact's family name.
	 */
	private String familyName;
	
	/**
	 * Contact's email address.
	 */
	private String email;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}

}

package es.bgfabogados.web.bean;

/**
 * Represent a contact.  
 * 
 * @author jsuarezgonza
 *
 */
public interface IContact {

	/**
	 * @return Contact's name.
	 */
	String getName();
	
	/**
	 * @return Contact's family name.
	 */
	String getFamilyName();
	
	
	/**
	 * @return Contact's main email address.
	 */
	String getEmail();

	/**
	 * @param name the name to set
	 */
	void setName(String name);

	/**
	 * @param familyName the familyName to set
	 */
	void setFamilyName(String familyName);

	/**
	 * @param email the email to set
	 */
	void setEmail(String email);
}

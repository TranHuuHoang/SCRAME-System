
/**
This class instantiates professor objects.
@author SS2 Group 5
@version 1.0
@since 2018-11-14

*/

import java.io.Serializable;

/**
* The Class Professor.
*/
public class Professor implements Serializable {
	
	public static final long serialVersionUID = -3914670736074682579L; 
	
	/** The professor name. */
	private String name ;
	
	/** The professor email. */
	private String email ;
	
	/** The professor's contact number. */
	private int contact ;
	
	/**
	 * Instantiates a new professor object.
	 */
	public Professor() {};

	/**
	 * Instantiates a new professor object.
	 *
	 * @param n the name 
	 * @param e the email
	 * @param c the contact
	 */
	public Professor(String n, String e, int c)  {
		name = n ;
		email = e ;
		contact = c ;
	}
	
	/**
	 * Gets the professor name.
	 *
	 * @return the professor name
	 */
	public String getName() { return name ; }
	
	/**
	 * Gets the professor contact.
	 *
	 * @return the professor contact
	 */
	public int getContact() { return contact ; }
	
	/**
	 * Gets the professor email.
	 *
	 * @return the professor email
	 */
	public String getEmail() { return email ; }
	
	/**
	 * Sets the professor name.
	 *
	 * @param profName the professor name
	 */
	public void setName(String profName) {
		this.name = profName;
	}
	
	/**
	 * Sets the professor email.
	 *
	 * @param email the professor email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Sets the professor contact.
	 *
	 * @param contact the professor contact
	 */
	public void setContact(int contact) {
		this.contact = contact;
	}

	/* To check if the professor exists 
	 * 
	 */
	public boolean equals(Object o) {
		if (o instanceof Professor) {
			Professor p = (Professor)o;
			return (getName().equals(p.getName()));
		}
		return false;
	}
}

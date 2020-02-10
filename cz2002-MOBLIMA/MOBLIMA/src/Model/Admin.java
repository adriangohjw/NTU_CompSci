package Model;

import java.security.NoSuchAlgorithmException;

/**
 * Represents an Admin with access to the system
 * An admin has editing rights (Update + Delete) to certain records
 */
@SuppressWarnings("serial")
public class Admin extends User {
	
	
	/** 
	 * Creates a Admin with the given attributes
	 * @param username						This Admin's username (email)
	 * @param password						This Admin's password (unencrypted)
	 * @throws NoSuchAlgorithmException		Thrown due to SHA256 encryption required but not available in the environment
	 */
	public Admin(String username, String password) throws NoSuchAlgorithmException {
		super(username, password, ADMIN);
	}
}

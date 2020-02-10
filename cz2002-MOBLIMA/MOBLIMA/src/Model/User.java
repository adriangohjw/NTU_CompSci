package Model;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Represents an User in the system
 */
@SuppressWarnings("serial")
public class User implements Serializable {

	 /**
	  * this User's email (username)
	  */
	private String email;
	
	/**
	 * this User's password (hashed and encrypted with SHA256)
	 */
	private String passwordHashed;
	
	/**
	 * this User's role (used to determine if Admin or Movie_Goer)
	 */
	private int role; 
	
	/**
     * Declaring constant for better readability and easier referencing to attribute
     */
    public static final int MOVIE_GOER = 1, ADMIN = 2;
    
	/** 
	 * Creates a User with the given attributes
	 * Encrypt user's password with SHA256 encryption and store the hashed value
	 * @param email			This User's username (email)
	 * @param password		This User's password (unencrypted)
	 * @param role			This User's role (used to determine if Admin or Movie_Goer)
	 */
	public User (String email, String password, int role) {
        this.email = email;
        this.passwordHashed = PasswordSHA256(password, email);  // using SHA-256 to hash password to ensure security
        this.role = role;
    }
    
    
	/** 
	 * Validate if a password input is correct 
	 * Done by hashing the input and comparing with the stored hashed value
	 * @param passwordToCompare		Password input to be compared with
	 * @return boolean				Return true if password is input is correct, else false
	 */
	public boolean validatePassword(String passwordToCompare){
    	return this.passwordHashed.equals(PasswordSHA256(passwordToCompare, this.email));
    }
    
    
	/** 
	 * Get the email of this User
	 * @return String	this user's email
	 */
	public String getEmail() {
    	return this.email;
	}
	
	
	/** 
	 * Get the hashed password of this User
	 * @return String	this user's hashed password
	 */
	public String getPasswordHashed() {
		return this.passwordHashed;
	}
    
    
	/** Get the role of this User
	 * @return int	this User's role
	 */
	public int getRole() {
    	return this.role;
	}
	
	
	/** 
	 * Change the password of this User
	 * Validate that person changing it knows the current password
	 * Done by hashing the input and comparing with the stored hashed value
	 * @param currentPassword	Password input to be compared with
	 * @param newPassword		This User's new password
	 */
	public void updatePassword(String currentPassword, String newPassword) {
		if (this.validatePassword(currentPassword))
			this.passwordHashed = PasswordSHA256(newPassword, this.getEmail());		
	}
    	
	
	/** 
	 * Used to encrypt User's password
	 * Improved security by using Salt (User's)
	 * @param passwordToHash 	Password to be encrypted
	 * @param salt				Salt to be used (will be User's email)
	 * @return String
	 */
	public String PasswordSHA256(String passwordToHash, String salt){
		String generatedPassword = null;
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-512");
	        md.update(salt.getBytes(StandardCharsets.UTF_8));
	        byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i< bytes.length ;i++){
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        generatedPassword = sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return generatedPassword;
	}

	
	/** 
	 * String to return when this User is being called
	 * @return String
	 */
	public String toString(){
		String toReturn = "";
		toReturn 	+= "Username: " + getEmail() + "\n"
					+ "Hashed Password: " + getPasswordHashed() + "\n"
					+ "Role: " + getRole();
		return toReturn; 
	}
    
}
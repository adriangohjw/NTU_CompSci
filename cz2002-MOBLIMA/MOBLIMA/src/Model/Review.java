package Model;

import java.io.Serializable;

/**
 * Represents a Review of a Movie in the system
 */
@SuppressWarnings("serial")
public class Review implements Serializable {

     /**
      * this Review's username (email)
      */
    private String username;
    
    /**
     * this Review's number of stars
     */
    private double numOfStars;

    /**
     * this Review's additional comment (optional)
     */
    private String additionalComment;

    
    /** 
     * Creates a Review with the given attributes
     * Additional comment is optional
     * @param username              this Review's username (email)
     * @param numOfStars            this Review's number of stars
     * @param additionalComment     this Review's additional coomment (optional)
     */
    public Review(String username, double numOfStars, String additionalComment){
    	this.username = username;
        this.numOfStars = numOfStars;
        this.additionalComment = additionalComment;
    }
    
    
    /** 
     * Get username (email) of reviewer of this Review
     * @return String   Reviewer's username for this Review
     */
    public String getUsername() {
    	return this.username;
    }

    
    /** Get number of stars given by the reviewer of this Review
     * @return double   Reviewer's number of stars given for this Review
     */
    public double getNumOfStars(){
        return this.numOfStars;
    }

    
    /** Get additional comment given by the reviewer of this Review
     * @return String   Reviewer's additional comment for this Review
     */
    public String getAdditionalComment(){
        return this.additionalComment;
    }

    
    /** 
     * Change the number of stars given by the reviewer of this Review
     * @param numOfStars    Reviewer's new number of stars for this Review
     */
    public void setNumOfStars(double numOfStars){
        this.numOfStars = numOfStars;
    }

    
    /** 
     * Change the additional comment given by the reviewew of this Review
     * @param additionalComment Reviewer's new additional comment for this Review
     */
    public void setAdditionalComent(String additionalComment){
        this.additionalComment = additionalComment;
    }

    
	/** 
	 * String to return when this Movie_Goer is being called
	 * @return String	
	 */
    public String toString(){
        String details = "";
        details += "        Username: " + getUsername() + "\n"
                +  "        Number of stars: " + String.valueOf(getNumOfStars()) + "\n"
                +  "        Comment: " + getAdditionalComment();
        return details;
    }

    
    /** 
     * Compare 2 Review Instances to check if they are identical
     * @param review        Object to be compared to
     * @return boolean      Return true if both reviews are identical, else false
     */
    @Override
    public boolean equals(Object review) {
        if (!(review instanceof Review)) {
            return false;
        }
        Review other = (Review) review;        
        return 
            this.username.equals(other.getUsername()) 
            && this.numOfStars == other.getNumOfStars()
            && this.additionalComment.equals(other.getAdditionalComment());
    }
}

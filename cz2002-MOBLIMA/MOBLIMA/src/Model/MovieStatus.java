package Model;

/**
 * Enumerated type for better readability and easier referencing to attribute 
 */
public enum MovieStatus{
    COMING_SOON("Coming soon"),
    PREVIEW("Preview"),
    NOW_SHOWING("Now showing"),
    END_OF_SHOWING("End of showing");

    private final String text;

    private MovieStatus(String text){
        this.text = text;
    }

    public String toString(){
        return text;
    }
}

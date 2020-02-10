package Model;

/**
 * Enumerated type for better readability and easier referencing to attribute 
 */
public enum CinemaType implements PriceChanger{
    STANDARD("Standard"),
    PREMIUM("Premium");

    private final String text;

    private CinemaType(String text) {
        this.text = text;
    }

    public String toString(){
        return text;
    }
}

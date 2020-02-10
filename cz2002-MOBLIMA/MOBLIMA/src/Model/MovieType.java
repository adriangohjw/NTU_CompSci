package Model;

/**
 * Enumerated type for better readability and easier referencing to attribute 
 */
public enum MovieType implements PriceChanger {
    TWO_D("2D"),
    THREE_D("3D"),
    BLOCKBUSTER("Blockbuster");

    private final String text;

    private MovieType(String text) {
        this.text = text;
    }

    public String toString(){
        return text;
    }
}

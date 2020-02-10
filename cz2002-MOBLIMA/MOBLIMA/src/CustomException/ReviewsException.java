package CustomException;

public class ReviewsException {

    @SuppressWarnings("serial")
    public static class ExistingReviewException extends Exception {
        public ExistingReviewException() {
            super("User already reviewed movie");
        }
    }

    @SuppressWarnings("serial")
    public static class StarsOutOfRangeException extends Exception {
        public StarsOutOfRangeException() {
            super("Stars given should be between 0 and 5 (inclusive)");
        }
    }
}
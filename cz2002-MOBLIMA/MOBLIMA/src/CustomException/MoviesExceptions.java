package CustomException;

public class MoviesExceptions {

    @SuppressWarnings("serial")
    public static class ExistingMovieException extends Exception {
        public ExistingMovieException() {
            super("Movie already existed");
        }
    }

    @SuppressWarnings("serial")
    public static class EndBeforeReleaseException extends Exception {
        public EndBeforeReleaseException() {
            super("End Date is before Release Date");
        }
    }

    @SuppressWarnings("serial")
    public static class NegativeDurationException extends Exception {
        public NegativeDurationException() {
            super("Duration is negative");
        }
    }

    @SuppressWarnings("serial")
    public static class MovieUnavailableException extends Exception {
        public MovieUnavailableException() {
            super("Movie is unavailable for booking");
        }
    }

    @SuppressWarnings("serial")
    public static class EmptyCastException extends Exception {
        public EmptyCastException() {
            super("Cast list is empty");
        }
    }

    @SuppressWarnings("serial")
    public static class EmptyStringException extends Exception {
        public EmptyStringException(String errorMessage){
            super(errorMessage);
        }
    }
}
package CustomException;

public class CineplexesExceptions {

    @SuppressWarnings("serial")
    public static class ExistingCineplexException extends Exception {
        public ExistingCineplexException() {
            super("Cineplex already existed");
        }
    }

    @SuppressWarnings("serial")
    public static class LessThan3CinemasException extends Exception {
        public LessThan3CinemasException() {
            super("Cineplex has less than 3 cinemas");
        }
    }

    @SuppressWarnings("serial")
    public static class EmptyStringException extends Exception {
        public EmptyStringException(String errorMessage){
            super(errorMessage);
        }
    }
}
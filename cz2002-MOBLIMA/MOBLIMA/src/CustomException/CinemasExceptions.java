package CustomException;

public class CinemasExceptions {

    @SuppressWarnings("serial")
    public static class ExistingCinemaException extends Exception {
        public ExistingCinemaException() {
            super("Cinema already existed");
        }
    }

    @SuppressWarnings("serial")
    public static class CinemaDoesNotExistException extends Exception {
        public CinemaDoesNotExistException() {
            super("Cinema does not exist");
        }
    }    

    @SuppressWarnings("serial")
    public static class CinemaCodeNot3CharException extends Exception {
        public CinemaCodeNot3CharException() {
            super("Cinema's code have to be 3 characters");
        }
    }

    @SuppressWarnings("serial")
    public static class EmptyStringException extends Exception {
        public EmptyStringException(String errorMessage){
            super(errorMessage);
        }
    }
}
package CustomException;

public class SessionsExceptions {

    @SuppressWarnings("serial")
    public static class InvalidSessionDateTimeException extends Exception {
        public InvalidSessionDateTimeException() {
            super("Session cannot be created (due to conflicting datetime)");
        }
    }
}
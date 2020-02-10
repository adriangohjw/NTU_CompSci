package CustomException;

public class UsersExceptions {

    @SuppressWarnings("serial")
    public static class ExistingUserException extends Exception {
        public ExistingUserException() {
            super("User already existed");
        }
    }

    @SuppressWarnings("serial")
    public static class InvalidEmailAddressException extends Exception {
        public InvalidEmailAddressException() {
            super("Email address is invalid (wrong format)");
        }
    }
}
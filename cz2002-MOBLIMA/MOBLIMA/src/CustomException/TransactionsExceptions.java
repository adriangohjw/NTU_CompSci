package CustomException;

public class TransactionsExceptions {

    @SuppressWarnings("serial")
    public static class InvalidTransactionException extends Exception {
        public InvalidTransactionException() {
            super("Transaction is invalid");
        }
    }
}
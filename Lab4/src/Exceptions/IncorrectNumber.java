package Exceptions;

public class IncorrectNumber extends RuntimeException{
    public IncorrectNumber() {
    }

    public IncorrectNumber(String message) {
        super(message);
    }

    public IncorrectNumber(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectNumber(Throwable cause) {
        super(cause);
    }

    public IncorrectNumber(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

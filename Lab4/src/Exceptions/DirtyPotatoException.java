package Exceptions;

public class DirtyPotatoException extends Exception{
    public DirtyPotatoException() {
    }

    public DirtyPotatoException(String message) {
        super(message);
    }

    public DirtyPotatoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DirtyPotatoException(Throwable cause) {
        super(cause);
    }

    public DirtyPotatoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

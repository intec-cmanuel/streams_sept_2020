package be.intecbrussel.oefening;

public class TooBigForIntegerException extends RuntimeException{
    public TooBigForIntegerException() {
    }

    public TooBigForIntegerException(String message) {
        super(message);
    }

    public TooBigForIntegerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooBigForIntegerException(Throwable cause) {
        super(cause);
    }
}

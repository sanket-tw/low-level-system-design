package exception;

public class PositionAlreadyFilledException extends RuntimeException {
    public PositionAlreadyFilledException(String message) {
        super(message);
    }
}

package exceptions;
public class MazeSizeMissmatchException extends Exception{
    public MazeSizeMissmatchException() {
        super();
    }
    /**
     * Constructs a MazeSizeMissmatchException that contains a helpful message
     * detailing why the exception occurred.
     * @param message detail message
     */
    public MazeSizeMissmatchException(String message) {
        super(message);
    }
}

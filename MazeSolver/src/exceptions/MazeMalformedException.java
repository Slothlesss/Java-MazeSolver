package exceptions;
public class MazeMalformedException extends Exception {
    public MazeMalformedException() {
        super();
    }
    /**
     * Constructs a MazeMalformedException that contains a helpful message
     * detailing why the exception occurred.
     * @param message detail message
     */
    public MazeMalformedException(String message) {
        super(message);
    }
}

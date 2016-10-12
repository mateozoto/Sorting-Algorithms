public class FullHeapException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception with a full heap case.
     */
    public FullHeapException() {
    	super();
    }

    /**
     * Creates an exception with cause message.
     */
    public FullHeapException(String message) {
    	super(message);
    }
}
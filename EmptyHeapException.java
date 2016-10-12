public class EmptyHeapException extends Exception {

    private static final long serialVersionUID = 1L;
    
    /**
     * Creates an exception with a empty heap case.
     */
    public EmptyHeapException() {
    	super();
    }

    /**
     * Creates an exception with cause message.
     */
    public EmptyHeapException(String message) {
    	super(message);
    }
}
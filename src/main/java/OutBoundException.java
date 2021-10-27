public class OutBoundException extends RuntimeException{
    public String message;

    public OutBoundException(String message) {
        super();
        this.message = message;
    }
}

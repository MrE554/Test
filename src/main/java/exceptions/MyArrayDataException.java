package exceptions;

public class MyArrayDataException extends Exception {
    public MyArrayDataException() { super(); }

    public MyArrayDataException(String message) {
        super(message);
    }
}

package exceptions;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() { super(); }

    public MyArraySizeException(String message) {
        super(message);
    }
}

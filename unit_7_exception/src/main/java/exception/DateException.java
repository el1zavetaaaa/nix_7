package exception;

public class DateException extends Exception {

    public DateException() {
    }

    @Override
    public String toString() {
        return "Incorrect input";
    }
}

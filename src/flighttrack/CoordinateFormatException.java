package flighttrack;

public class CoordinateFormatException extends RuntimeException { 
    public CoordinateFormatException(String errorMessage) {
        super(errorMessage);
    }
}
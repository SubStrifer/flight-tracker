package flight.tracking.system;

public class CoordinateFormatException extends RuntimeException { 
    public CoordinateFormatException(String errorMessage) {
        super(errorMessage);
    }
}
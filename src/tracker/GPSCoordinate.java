package tracker;

/**Class represents GPS coordinates in degrees. */
public class GPSCoordinate {

    private double latitude;
    private double longitude;
    
    /**Default constructor. */
    public GPSCoordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.latitude = longitude;
    }

    /**Create coordinates from String. */
    public GPSCoordinate(String latitude, String longitude) throws IllegalArgumentException {
        try {
            this.latitude = parseCoordinate(latitude);
            this.longitude = parseCoordinate(longitude);
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not parse coordinate.");
        }
    }

    /**Parse single coordinate from String. */
    private double parseCoordinate(String coord) throws NumberFormatException {
        //todo coordinate check
        double degrees = 0;
        String[] coords = coord.split("°|'|\"");
        // Convert coordinates to degrees
        degrees += Float.parseFloat(coords[0]);
        degrees += Float.parseFloat(coords[1]) / 60.0;
        degrees += Float.parseFloat(coords[0]) / 3600.0;
        // Make coordinate positive for N/E and negative for S/W
        if(coord.contains("N") || coord.contains("E")) {
            degrees = Math.abs(degrees);
        } else if(coord.contains("S") || coord.contains("W")) {
            degrees = -Math.abs(degrees);
        }
        return degrees;
    }
}

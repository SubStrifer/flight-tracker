package tracker;

/**Class represents GPS coordinates in degrees. */
public class GPSCoordinate {

    private double latitude;
    private double longitude;
    
    /**Default constructor. */
    public GPSCoordinate(double latitude, double longitude) {
        this.setLatitude(latitude);
        this.setLatitude(longitude);
    }

    public double getLongitude() {
        return longitude;
    }

    private void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    private void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**Create coordinates from String. */
    public GPSCoordinate(String latitude, String longitude) throws IllegalArgumentException {
        try {
            this.setLatitude(parseCoordinate(latitude));
            this.setLongitude(parseCoordinate(longitude));
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

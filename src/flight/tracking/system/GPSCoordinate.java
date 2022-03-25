package flight.tracking.system;

/**Class represents GPS coordinates in degrees. */
public class GPSCoordinate {

    private double latitude;
    private double longitude;
    private final double radius = 6378;
    
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
    public GPSCoordinate(String latitude, String longitude) throws CoordinateFormatException {
        try {
            this.setLatitude(parseCoordinate(latitude));
            this.setLongitude(parseCoordinate(longitude));
        } catch (Exception e) {
            throw new CoordinateFormatException("Could not parse coordinate.");
        }
    }

    /**Parse single coordinate from String. */
    private double parseCoordinate(String coord) throws CoordinateFormatException {
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

    /**
     * Calculate distance to other GPSCoordinate.
     * @return distance in km
     */
    // public double distance(GPSCoordinate other) {
    //     double deltaLongitude = other.longitude - longitude;
    //     return radius * Math.acos(
    //         Math.sin(latitude) * Math.sin(other.latitude) +
    //         Math.cos(latitude) * Math.cos(other.latitude) * deltaLongitude
    //     );
    // }

    /**
     * Get distance from this GPSCoordinate to the other GPSCoordinate.
     * @return distance in km
     */
    public double distanceTo(GPSCoordinate other) {
        double radianLatitude1 = latitude * (Math.PI / 180.0);
        double radianLongitude1 = longitude * (Math.PI / 180.0);
        double radianLatitude2 = other.latitude * (Math.PI / 180.0);
        double radianLongitude2 = other.longitude * (Math.PI / 180.0);
        double deltaLatitude = radianLatitude2 - radianLatitude1;
        double deltaLongitude = radianLongitude2 - radianLongitude1;
        double trigo = Math.sin(Math.pow(deltaLatitude / 2.0, 2)) + Math.cos(radianLatitude1) *
            Math.cos(radianLatitude2) * Math.sin(Math.pow(deltaLongitude / 2.0, 2));
        return 12742.0 * Math.asin(Math.sqrt(trigo));
    }
}

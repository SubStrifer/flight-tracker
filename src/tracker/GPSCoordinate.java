package tracker;

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
        //todo fix
        double degrees = 0;
        String[] coords = coord.split("°|'|\"");
        degrees += Float.parseFloat(coords[0]);
        degrees += Float.parseFloat(coords[1]) / 60.0;
        degrees += Float.parseFloat(coords[0]) / 3600.0;
        return degrees;
    }
}

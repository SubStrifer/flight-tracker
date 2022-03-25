package flight.tracking.system;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents a single plane.
 */
public class Aeroplane {
    
    private String model;
    private String manufacturer;
    private float speed;
    private float consumption;

    /**
     * Aeroplane constructor.
     */
    public Aeroplane(String model, String manufacturer, float speed, float consumption) throws IllegalArgumentException {
        if (Utils.emptyOrWhitespace(model) || Utils.emptyOrWhitespace(manufacturer)) {
            throw new IllegalArgumentException("Aeroplane model and manufacturer cannot be empty or null.");
        } else if (speed <= 0f || consumption <= 0f) {
            throw new IllegalArgumentException("Aeroplane speed and consumption must be a positive value.");
        }
        //todo negative
        this.setModel(model);
        this.manufacturer = manufacturer;
        this.setSpeed(speed);
        this.setConsumption(consumption);
    }

    public float getSpeed() {
        return speed;
    }

    private void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getConsumption() {
        return consumption;
    }

    private void setConsumption(float consumption) {
        this.consumption = consumption;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    /**
     * Load all planes from a file.
     */
    public static ArrayList<Aeroplane> loadAeroplanes() {
        ArrayList<Aeroplane> planes = new ArrayList<Aeroplane>();
        List<String> lines = new ArrayList<String>();

        // Read file
        try {
            lines = Files.readAllLines(Paths.get("data/planes.txt"));
        } catch (IOException e) {
            System.out.println("Could not read planes file.");
            return planes;
        }

        // Create Aeroplane from each line
        for (String line : lines) {
            try {
                String[] plane = line.split(";");
                float speed = Float.parseFloat(plane[2]);
                float consumption = Float.parseFloat(plane[3]);
                planes.add(new Aeroplane(plane[0].trim(), plane[1].trim(), speed, consumption));
            } catch (NumberFormatException e) {
                System.out.println("Could not parse plane data.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Could not parse plane data.");
            }       
        }

        return planes;
    }

    
}

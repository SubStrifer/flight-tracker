package tracker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**Class represents a single plane. */
public class Aeroplane {
    
    private String model;
    private String manufacturer;
    private float speed;
    private float consumption;

    /**Aeroplane constructor. */
    public Aeroplane(String model, String manufacturer, float speed, float consumption) {
        //todo can't be empty/0/negative
        this.model = model;
        this.manufacturer = manufacturer;
        this.speed = speed;
        this.consumption = consumption;
    }

    public static ArrayList<Aeroplane> loadAeroplanes() {
        ArrayList<Aeroplane> planes = new ArrayList<Aeroplane>();
        List<String> lines = new ArrayList<String>();

        // Read file
        try {
            lines = Files.readAllLines(Paths.get("data/planes.txt"));
        } catch (IOException e) {
            System.out.println("Could not read planes file.");
            e.printStackTrace();
        }

        // Create Aeroplane from each line
        for (String line : lines) {
            String[] plane = line.split(";");
            try {
                float speed = Float.parseFloat(plane[2]);
                float consumption = Float.parseFloat(plane[3]);
                planes.add(new Aeroplane(plane[0].trim(), plane[1].trim(), speed, consumption));
            } catch (NumberFormatException e) {
                System.out.println("Could not parse plane data.");
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Could not parse plane data.");
                e.printStackTrace();
            }       
        }

        return planes;
    }
}

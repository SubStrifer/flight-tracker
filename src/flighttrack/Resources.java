package flighttrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Resources {
    private static Resources instance;

    public static Resources getInstance() {
		if (instance == null)
			instance = new Resources();
		return instance;
	}

    public List<String> loadResource(String name) {
        List<String> lines = new ArrayList<String>();

        // Read file
        try {
            InputStream data = getClass().getResourceAsStream(name);
            BufferedReader reader = new BufferedReader(new InputStreamReader(data));
            String line = null;
            while ((line = reader.readLine()) != null ) {
                lines.add(line);
            }
        } catch (Exception e) {
            System.out.println("Could not read resource file " + name);
        }

        return lines;
    }
    
}

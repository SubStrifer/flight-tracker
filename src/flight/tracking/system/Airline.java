package flight.tracking.system;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Airline {
	
	private String code;
	private String name;

	/**
	 * Default constructor.
	 */
	public Airline(String code, String name) {
		 if (Utils.emptyOrWhitespace(code)) {
	            throw new IllegalArgumentException("The Airline code cannot be empty.");
	        } else if (Utils.emptyOrWhitespace(name)) {
	            throw new IllegalArgumentException("The Airline name cannot be empty");
	        }else {
	        //todo negative
	        this.code = code;
	        this.name = name;
		}
	}

	/**
	 * Load all airlines from a file.
	 */
	 public static ArrayList<Airline> loadAirlines() {
	
	        ArrayList<Airline> airlines = new ArrayList<Airline>();
	        List<String> listOfAirlines = new ArrayList<String>();

	        // Read file
	        try {
	            listOfAirlines = Files.readAllLines(Paths.get("data/airlines.txt"));
	        } catch (IOException e) {
	            System.out.println("Could not read airlines file.");
	            return airlines;
	        }

	        // Create Airlines from each line
	        for (String airlinelist : listOfAirlines) {
	            try {
	                String[] airline = airlinelist.split(";");
	                airlines.add(new Airline(airline[0].trim(), airline[1].trim()));
	              
	            } catch (NumberFormatException e) {
	                System.out.println("Could not parse airline data.");
	            } catch (IndexOutOfBoundsException e) {
	                System.out.println("Could not parse airline data.");
	            }       
	        }

	        return airlines;
	    }

}

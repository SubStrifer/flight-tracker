package flighttrack;

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
	        this.setCode(code);
	        this.setName(name);
		}
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	private void setCode(String code) {
		this.code = code;
	}

	/**
	 * Load all airlines from a file.
	 */
	 public static ArrayList<Airline> loadAirlines() {
	
	        ArrayList<Airline> airlines = new ArrayList<Airline>();

	        // Create Airlines from each line
	        for (String airlinelist : Resources.getInstance().loadResource("airlines.txt")) {
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

package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.company.entities.Flight;
import com.company.entities.Place;
import com.company.util.DatabaseManager;

public class FlightSearchService {
	
	DatabaseManager dbManager;

    public FlightSearchService() {
		this.dbManager = new DatabaseManager();
	}

	public List<Flight> searchFlights(String date, Place source, Place destination) {
    	
    	List<Flight> flights = dbManager.getFlights();
        List<Flight> matchingFlights = new ArrayList<>();
        
        for (Flight flight : flights) {
            if (flight.getDateField().toString().equals(date) &&
                    flight.getSource().getId() == source.getId() &&
                    flight.getDestination().getId() == destination.getId()) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
	public List<Flight> searchFlights(Place source, Place destination) {
		
		List<Flight> flights = dbManager.getFlights();
		
		List<Flight> matchingFlights = new ArrayList<>();
		for (Flight flight : flights) {
			if (flight.getSource().getId() == source.getId() &&
                    flight.getDestination().getId() == destination.getId()) {
				matchingFlights.add(flight);
			}
		}
		return matchingFlights;
	}
}

package com.company.util;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.company.entities.Airline;
import com.company.entities.Flight;
import com.company.entities.Passenger;
import com.company.entities.Place;

public class DatabaseManager {
	
	private SessionFactory sessionFactory;
    
    public DatabaseManager() {
        this.sessionFactory = HibernateUtil.buildSessionFactory();
    }
    
    public void addPlace(Place place) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(place);
            session.getTransaction().commit();
        }
    }
    public void addAirline(Airline airline) {
    	try (Session session = sessionFactory.openSession()) {
    		session.beginTransaction();
    		session.save(airline);
    		session.getTransaction().commit();
    	}
    }
    public void addFlight(Flight flight) {
    	try (Session session = sessionFactory.openSession()) {
    		session.beginTransaction();
    		session.save(flight);
    		session.getTransaction().commit();
    	}
    }
    
    public void addPassenger(Passenger passenger) {
    	try (Session session = sessionFactory.openSession()) {
    		session.beginTransaction();
    		session.save(passenger);
    		session.getTransaction().commit();
    	}
    }
    
    
    // GETTING SINGLE RECORD
    public Place getPlace(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Place place = (Place) session.get(Place.class, id);
            session.getTransaction().commit();
            return place;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Airline getAirline(Long id) {
    	try (Session session = sessionFactory.openSession()) {
    		session.beginTransaction();
    		Airline airline = (Airline) session.get(Airline.class, id);
    		session.getTransaction().commit();
    		return airline;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    public Flight getFlight(Long id) {
    	try (Session session = sessionFactory.openSession()) {
    		session.beginTransaction();
    		Flight flight = (Flight) session.get(Flight.class, id);
    		session.getTransaction().commit();
    		return flight;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    // GETTING LIST OF OBJECTS
    
    public List<Place> getPlaces() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Place> places = session.createQuery("from Place", Place.class).list();
            session.getTransaction().commit();
            return places;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Airline> getAirlines() {
    	try (Session session = sessionFactory.openSession()) {
    		session.beginTransaction();
    		List<Airline> airlines = session.createQuery("from Airline", Airline.class).list();
    		session.getTransaction().commit();
    		return airlines;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    public List<Flight> getFlights() {
    	try (Session session = sessionFactory.openSession()) {
    		session.beginTransaction();
    		List<Flight> flights = session.createQuery("from Flight", Flight.class).list();
    		session.getTransaction().commit();
    		return flights;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
  
}

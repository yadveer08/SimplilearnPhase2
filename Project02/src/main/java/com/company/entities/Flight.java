package com.company.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Flight {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "source_id", nullable = false, foreignKey = @ForeignKey(name = "fk_flight_source"))
    private Place source;

    @OneToOne
    @JoinColumn(name = "destination_id", nullable = false, foreignKey = @ForeignKey(name = "fk_flight_destination"))
    private Place destination;

    @OneToOne
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;
    
    @Column
    private LocalDate dateField;

    @Column
    private LocalTime timeField;

    @Column(nullable = false)
    private double ticketPrice;

    // Constructors, getters, and setters
    
    public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(Place source, Place destination, Airline airline, LocalDate dateField, LocalTime timeField,
			double ticketPrice) {
		super();
		this.source = source;
		this.destination = destination;
		this.airline = airline;
		this.dateField = dateField;
		this.timeField = timeField;
		this.ticketPrice = ticketPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Place getSource() {
		return source;
	}

	public void setSource(Place source) {
		this.source = source;
	}

	public Place getDestination() {
		return destination;
	}

	public void setDestination(Place destination) {
		this.destination = destination;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public LocalDate getDateField() {
		return dateField;
	}

	public void setDateField(LocalDate dateField) {
		this.dateField = dateField;
	}

	public LocalTime getTimeField() {
		return timeField;
	}

	public void setTimeField(LocalTime timeField) {
		this.timeField = timeField;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	
    
    
    
    
}


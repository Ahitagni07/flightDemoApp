package com.test.aeroplane.details.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.aeroplane.details.demo.model.Flight;

@Repository
public class FlightRepositoryImpl implements FlightRepository {

	@Autowired
	IFlightRepository repo;

	@Override
	public Optional<Flight> findByFlightNumberIgnoreCase(String flightNumber) {
		Optional<Flight> flight = repo.findByFlightNumberIgnoreCase(flightNumber);
		return flight;
	}

	@Override
	public Optional<List<Flight>> findByOriginAirportCodeIgnoreCaseAndDestinationAirportCodeIgnoreCase(
			String originAirportCode, String destinationAirportCode) {
		Optional<List<Flight>> flightList = repo.findByOriginAirportCodeIgnoreCaseAndDestinationAirportCodeIgnoreCase(
				originAirportCode, destinationAirportCode);
		return flightList;
	}

}

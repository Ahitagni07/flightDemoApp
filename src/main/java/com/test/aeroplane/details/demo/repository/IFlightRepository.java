package com.test.aeroplane.details.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.aeroplane.details.demo.model.Flight;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Long>{

	Optional<Flight> findByFlightNumberIgnoreCase(String flightNumber);

	Optional<List<Flight>> findByOriginAirportCodeIgnoreCaseAndDestinationAirportCodeIgnoreCase(String originAirportCode, String destinationAirportCode);
}

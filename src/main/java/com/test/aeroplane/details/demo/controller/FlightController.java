package com.test.aeroplane.details.demo.controller;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.test.aeroplane.details.demo.dto.FilteredFlightRespDTO;
import com.test.aeroplane.details.demo.dto.FlightResponseDTO;
import com.test.aeroplane.details.demo.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	FlightService flightService;

	@GetMapping(value = "flight/flightnumber/{flightNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getFlightByNumber(@PathVariable String flightNumber)
			throws Exception {

		try {

			FlightResponseDTO response = flightService.getFlightDetails(flightNumber);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping(value = "flight/airportcode", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getFlightByNumber(@RequestHeader("originCode") @NotEmpty String originAirportCode, @RequestHeader("destCode") @NotEmpty String destinationAirportCode)
			throws Exception {

		try {

			FilteredFlightRespDTO response = flightService.getFilteredFlightDetails(originAirportCode, destinationAirportCode);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
}

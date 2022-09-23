package com.test.aeroplane.details.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.aeroplane.details.demo.dto.FilteredFlightRespDTO;
import com.test.aeroplane.details.demo.dto.FlightResponseDTO;
import com.test.aeroplane.details.demo.exception.CustomException;
import com.test.aeroplane.details.demo.model.Flight;
import com.test.aeroplane.details.demo.repository.FlightRepositoryImpl;

@Service
public class FlightService {

	@Autowired
	FlightRepositoryImpl flightRepository;

	public FlightResponseDTO getFlightDetails(String flightNumber) {
		Optional<Flight> flight = flightRepository.findByFlightNumberIgnoreCase(flightNumber);
		FlightResponseDTO responseDto = new FlightResponseDTO();
		if (flight.isPresent()) {
			responseDto.setDestinationAirportCode(flight.get().getDestinationAirportCode().toUpperCase());
			responseDto.setOriginAirportCode(flight.get().getOriginAirportCode().toUpperCase());
			responseDto.setFlightNumber(flightNumber.toUpperCase());
		} else {
			throw new CustomException("Searched Flight not found");
		}
		return responseDto;
	}

	public FilteredFlightRespDTO getFilteredFlightDetails(String originAirportCode, String destinationAirportCode) {
		FilteredFlightRespDTO resp = new FilteredFlightRespDTO();
		List<String> flightNumbers = new ArrayList<>();
		Optional<List<Flight>> flightList = flightRepository
				.findByOriginAirportCodeIgnoreCaseAndDestinationAirportCodeIgnoreCase(originAirportCode,
						destinationAirportCode);
		if (flightList.isPresent()) {
			List<Flight> sortedFlight = flightList.get().stream().sorted(Comparator.comparing(Flight::getDuration))
					.collect(Collectors.toList());
			resp.setOriginAirportCode(originAirportCode.toUpperCase());
			resp.setDestinationAirportCode(destinationAirportCode.toUpperCase());
			sortedFlight.forEach(flights -> {
				flightNumbers.add(flights.getFlightNumber());
			});
			resp.setFlightNumbers(flightNumbers);
		} else {
			throw new CustomException("No matching flight found for given location combination");
		}
		return resp;
	}

}

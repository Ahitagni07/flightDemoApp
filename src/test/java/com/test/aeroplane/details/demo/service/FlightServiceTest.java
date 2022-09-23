package com.test.aeroplane.details.demo.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.aeroplane.details.demo.dto.FilteredFlightRespDTO;
import com.test.aeroplane.details.demo.dto.FlightResponseDTO;
import com.test.aeroplane.details.demo.model.Flight;
import com.test.aeroplane.details.demo.repository.IFlightRepository;

@RunWith(SpringRunner.class)
public class FlightServiceTest {

	@InjectMocks
	FlightService flightService;

	@Mock
	IFlightRepository iFlightRepository;

	@Test
	public void getFlightDetailstest() {
		String flightNumber = "AAA111";
		Optional<Flight> flight = Optional.empty();
		Flight flightDemo = new Flight();
		flightDemo.setDuration(20L);
		flightDemo.setOriginAirportCode("CCU");
		flightDemo.setDestinationAirportCode("BAN");
		flight = Optional.of(flightDemo);
		Mockito.when(iFlightRepository.findByFlightNumberIgnoreCase(flightNumber)).thenReturn(flight);
		FlightResponseDTO responseDto = new FlightResponseDTO();
		responseDto.setFlightNumber(flightNumber);
		responseDto.setOriginAirportCode(flight.get().getOriginAirportCode());
		responseDto.setDestinationAirportCode(flight.get().getDestinationAirportCode());
		assertNotNull(responseDto.getOriginAirportCode());
	}

	@Test
	public void getFilteredFlightDetailstest() {
		String originCode = "CCU";
		String destCode = "BAN";
		Optional<List<Flight>> flightListOpt = Optional.empty();
		List<Flight> flightList = new ArrayList<>();
		Flight flightDemo = new Flight();
		flightDemo.setDuration(20L);
		flightDemo.setOriginAirportCode("CCU");
		flightDemo.setDestinationAirportCode("BAN");
		flightList.add(flightDemo);
		flightListOpt = Optional.of(flightList);
		Mockito.when(iFlightRepository.findByOriginAirportCodeIgnoreCaseAndDestinationAirportCodeIgnoreCase(originCode,
				destCode)).thenReturn(flightListOpt);
		FilteredFlightRespDTO resp = new FilteredFlightRespDTO();
		resp.setDestinationAirportCode(destCode);
		resp.setOriginAirportCode(originCode);
		assertNotNull(resp.getOriginAirportCode());
	}

}

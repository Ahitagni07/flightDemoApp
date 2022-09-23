package com.test.aeroplane.details.demo.repository;

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

import com.test.aeroplane.details.demo.model.Flight;

@RunWith(SpringRunner.class)
public class FlightRepositoryImplTest {

	@Mock
	IFlightRepository repo;
	@InjectMocks
	FlightRepositoryImpl flightRepoImpl;
	
	@Test
	public void findByFlightNumberIgnoreCasetest() {
		Flight flightDemo = new Flight();
		Optional<Flight> flight = Optional.of(flightDemo);
		Mockito.when(repo.findByFlightNumberIgnoreCase("AAA111")).thenReturn(flight);
		assertNotNull(flightRepoImpl.findByFlightNumberIgnoreCase("AAA111"));
	}
	
	@Test
	public void findByOriginAirportCodeIgnoreCaseAndDestinationAirportCodeIgnoreCasetest() {
		Flight flightDemo = new Flight();
		List<Flight> flightList = new ArrayList<>();
		flightList.add(flightDemo);
		Optional<List<Flight>> flight = Optional.of(flightList);
		String originCode = "CCU";
		String destCode = "AMS";
		Mockito.when(repo.findByOriginAirportCodeIgnoreCaseAndDestinationAirportCodeIgnoreCase(originCode, destCode)).thenReturn(flight);
		assertNotNull(flightRepoImpl.findByOriginAirportCodeIgnoreCaseAndDestinationAirportCodeIgnoreCase(originCode, destCode));
	}

}

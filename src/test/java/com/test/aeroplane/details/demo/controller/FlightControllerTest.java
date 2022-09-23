package com.test.aeroplane.details.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.test.aeroplane.details.demo.exception.CustomException;
import com.test.aeroplane.details.demo.service.FlightService;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
class FlightControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	FlightService service;

	@Test
	public void testfindFlightDetails() {
		try {
			MvcResult mvcResult = mockMvc
					.perform(MockMvcRequestBuilders.get("/flight/flightnumber/{flightNumber}", "AAA111")
							.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@Test
	public void testfindFilteredFlightDetails() {
		try {
			MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/flight/airportcode")
					.header("originCode", "CCU").header("destCode", "DEL").contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

}
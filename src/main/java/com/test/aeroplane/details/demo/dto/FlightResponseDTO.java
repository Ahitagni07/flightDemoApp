package com.test.aeroplane.details.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponseDTO {

	private String flightNumber;
	private String originAirportCode;
	private String destinationAirportCode;
}

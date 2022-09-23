package com.test.aeroplane.details.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilteredFlightRespDTO {

	private String originAirportCode;
	private String destinationAirportCode;
	private List<String> flightNumbers;
}

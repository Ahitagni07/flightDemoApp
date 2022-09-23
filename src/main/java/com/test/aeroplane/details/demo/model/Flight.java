package com.test.aeroplane.details.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

	@Id
	private Long id;
	private String flightNumber;
	private String originAirportCode;
	private String destinationAirportCode;
	private Long duration;
}

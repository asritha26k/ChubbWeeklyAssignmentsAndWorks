package com.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flight.entity.Flight;
import com.flight.exception.ResourceNotFoundExceptionForResponseEntity;
import com.flight.repository.FlightRepository;
import com.flight.request.SearchReq;

@Service
public class FlightService {
	@Autowired
	FlightRepository flightRepo;

	public ResponseEntity<Integer> addService(Flight flight) {

		Flight savedFlight = flightRepo.save(flight);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedFlight.getFlightId());
	}

	public void saveAll(List<Flight> flights) {
		flightRepo.saveAll(flights);
	}

	public ResponseEntity<List<Flight>> searchService(SearchReq searchReq)
			throws ResourceNotFoundExceptionForResponseEntity {
		String from = searchReq.origin;
		String to = searchReq.destination;

		// no optional because default return value is list only, if ntg to return then
		// empty list
		// so optional becomes redundant anyways
		List<Flight> flights = flightRepo.findByOriginAndDestination(from, to);

		if (flights.isEmpty()) {
			throw new ResourceNotFoundExceptionForResponseEntity("No flights found from " + from + " to " + to);
		}

		return ResponseEntity.status(HttpStatus.OK).body(flights);
	}

	public ResponseEntity<Void> deleteFlightService(int flightId) throws ResourceNotFoundExceptionForResponseEntity {

		Flight flight = flightRepo.findById(flightId).orElseThrow(
				() -> new ResourceNotFoundExceptionForResponseEntity("Flight with id " + flightId + " not found"));

		flightRepo.delete(flight);

		return ResponseEntity.ok().build();
	}

	public List<Flight> getByFlightId(int flightId) {
		return flightRepo.findByflightId(flightId);

	}

}

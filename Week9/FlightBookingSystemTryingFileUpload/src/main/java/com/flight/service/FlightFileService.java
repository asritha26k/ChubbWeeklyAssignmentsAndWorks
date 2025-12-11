package com.flight.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.flight.entity.Flight;
import com.flight.repository.FlightRepository;

@Service
public class FlightFileService {

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private FlightRepository flightRepo;

	public List<Flight> parseFlightJsonFile(MultipartFile file) throws IOException {

		CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, Flight.class);

		return objectMapper.readValue(file.getInputStream(), listType);
	}

	public ResponseEntity<?> validateFlights(MultipartFile file) {
		try {
			CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, Flight.class);

			List<Flight> flights = objectMapper.readValue(file.getInputStream(), listType);
			List<String> errors = new ArrayList<>();

			for (int i = 0; i < flights.size(); i++) {
				Flight f = flights.get(i);
				int index = i + 1;

				if (f.getAirline() == null) {
					errors.add("Flight " + index + ": Airline is missing");
				}
				if (f.getOrigin() == null || f.getOrigin().isBlank()) {
					errors.add("Flight " + index + ": Origin cannot be empty");
				}
				if (f.getDestination() == null || f.getDestination().isBlank()) {
					errors.add("Flight " + index + ": Destination cannot be empty");
				}
				if (f.getPrice() <= 0) {
					errors.add("Flight " + index + ": Price must be positive");
				}
				if (f.getDepartureTime() == null) {
					errors.add("Flight " + index + ": Departure time cannot be null");
				}
				if (f.getArrivalTime() == null) {
					errors.add("Flight " + index + ": Arrival time cannot be null");
				}
				if (f.getArrivalTime() != null && f.getDepartureTime() != null
						&& !f.getArrivalTime().isAfter(f.getDepartureTime())) {
					errors.add("Flight " + index + ": Arrival time must be after departure time");
				}
			}

			if (!errors.isEmpty()) {
				return ResponseEntity.badRequest().body(errors);
			}

			flightRepo.saveAll(flights);

			return ResponseEntity.ok("All flights uploaded successfully!");

		} catch (IOException e) {
			return ResponseEntity.status(500).body("Invalid JSON file format");
		}
	}

}

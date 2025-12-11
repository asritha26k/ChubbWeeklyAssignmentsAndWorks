package com.flight.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.flight.entity.Flight;

@Service
public class FlightFileService {

	@Autowired
	private ObjectMapper objectMapper;

	public List<Flight> parseFlightJsonFile(MultipartFile file) throws IOException {

		CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, Flight.class);

		return objectMapper.readValue(file.getInputStream(), listType);
	}
}

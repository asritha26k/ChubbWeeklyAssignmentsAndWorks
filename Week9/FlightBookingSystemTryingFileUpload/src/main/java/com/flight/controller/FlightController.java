package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.flight.entity.FileInfo;
import com.flight.entity.Flight;
import com.flight.exception.ResourceNotFoundExceptionForResponseEntity;
import com.flight.request.SearchReq;
import com.flight.response.ResponseMessage;
import com.flight.service.FilesStorageService;
import com.flight.service.FlightFileService;
import com.flight.service.FlightService;

import jakarta.validation.Valid;

@RestController
public class FlightController {
	@Autowired
	FilesStorageService storageService;

	@Autowired
	FlightService flightService;
	@Autowired
	FlightFileService flightFileService;
	@Autowired
	FilesStorageService filesStorageService;
	@Autowired
	FlightFileService fileService;

	@PostMapping("/flight-service/flight/register/uploadFile")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
		return fileService.validateFlights(file);
	}

	@PostMapping("/flight-service/flight/register/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {

		try {
			filesStorageService.save(file);

			List<Flight> flights = flightFileService.parseFlightJsonFile(file);
			flightService.saveAll(flights);

			String message = "Uploaded & processed file: " + file.getOriginalFilename();
			return ResponseEntity.ok(new ResponseMessage(message));

		} catch (Exception e) {
			String message = "Failed: " + e.getMessage();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@GetMapping("/flight-service/flight/files")
	public ResponseEntity<List<FileInfo>> getListFiles() {
		List<FileInfo> fileInfos = filesStorageService.loadAll()
				.map(path -> new FileInfo(path.getFileName().toString(),
						MvcUriComponentsBuilder
								.fromMethodName(FlightController.class, "getFile", path.getFileName().toString())
								.build().toString()))
				.toList();

		return ResponseEntity.ok(fileInfos);
	}

	@GetMapping("/flight-service/flight/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = filesStorageService.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	// flight added
	@PostMapping("/flight-service/flight/register")
	public ResponseEntity<Integer> addController(@Valid @RequestBody Flight flight) {
		return flightService.addService(flight);
	}

	@PostMapping("/flight-service/flight/getByOriginDestination")
	public ResponseEntity<List<Flight>> searchController(@Valid @RequestBody SearchReq searchReq)
			throws ResourceNotFoundExceptionForResponseEntity {

		return flightService.searchService(searchReq);
	}

	@DeleteMapping("/flight-service/flight/delete/{flightId}")
	public ResponseEntity<Void> deleteFlightController(@PathVariable int flightId)
			throws ResourceNotFoundExceptionForResponseEntity {
		return flightService.deleteFlightService(flightId);
	}

}

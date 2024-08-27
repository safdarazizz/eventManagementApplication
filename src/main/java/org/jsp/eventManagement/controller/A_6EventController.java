package org.jsp.eventManagement.controller;

import org.jsp.eventManagement.entity.A_2Event;
import org.jsp.eventManagement.service.A_7EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
//@RequestMapping(value = {"/events", "/e", "/eve"})
@RequestMapping(value = "/events")
public class A_6EventController {
	
	@Autowired
	private A_7EventService eventService;
	
	@Operation(summary = "To create the event", description = "This API will accept the RequestBody of Event entity and persist to the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Event Saved Successfully"), @ApiResponse(responseCode = "400", description = "Unable to save Event")})
	@PostMapping
	public ResponseEntity<?> saveEvent(@RequestBody A_2Event event)
	{
		return eventService.saveEvent(event);
	}
	
	@Operation(summary = "To fetch all the events", description = "This API will fetch all the events available in the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Fetched all the events successfully"), @ApiResponse(responseCode = "400", description = "Could not fetch all the events, No events found")})
	@GetMapping()
	public ResponseEntity<?> fetchAllEvents()
	{
		return eventService.fetchAllEvents();
	}
	
	@Operation(summary = "To change the status of an event to ongoing", description = "This API will change the status of an event to ON_GOING in the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Event status changed to ON_GOING successfully"), @ApiResponse(responseCode = "400", description = "Could not change the Event status to ON_GOING")})
	@PatchMapping("/ongoing/{id}")
	public ResponseEntity<?> setStatusToOngoing(@PathVariable int id)
	{
		return eventService.setStatusToOngoing(id);
	}
	
	@Operation(summary = "To change the status of an event to completed", description = "This API will change the status of an event to COMPLETED in the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Event status changed to COMPLETED successfully"), @ApiResponse(responseCode = "400", description = "Could not change the Event status to COMPLETED")})
	@PatchMapping("/completed/{id}")
	public ResponseEntity<?> setStatusToCompleted(@PathVariable int id)
	{
		return eventService.setStatusToCompleted(id);
	}
	
	@Operation(summary = "To change the status of an event to upcoming", description = "This API will change the status of an event to UP_COMING in the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Event status changed to UP_COMING successfully"), @ApiResponse(responseCode = "400", description = "Could not change the Event status to UP_COMING")})
	@PatchMapping("/upcoming/{id}")
	public ResponseEntity<?> setStatusToUpcoming(@PathVariable int id)
	{
		return eventService.setStatusToUpcoming(id);
	}
	
	@Operation(summary = "To fetch the upcoming events", description = "This API will fetch all the upcoming events from the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Fetched all the upcoming events successfully"), @ApiResponse(responseCode = "400", description = "Could not fetch the upcoming events, it may not be present")})
	@GetMapping("/upcoming")
	public ResponseEntity<?> fetchUpcomingEvents()
	{
		return eventService.fetchUpcomingEvents();
	}
	
	@Operation(summary = "To fetch the ongoing events", description = "This API will fetch all the ongoing events from the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Fetched all the ongoing events successfully"), @ApiResponse(responseCode = "400", description = "Could not fetch the ongoing events, it may not be present")})
	@GetMapping("/ongoing")
	public ResponseEntity<?> fetchOngoingEvents()
	{
		return eventService.fetchOngoingEvents();
	}
	
	@Operation(summary = "To fetch the completed events", description = "This API will fetch all the completed events from the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Fetched all the completed events successfully"), @ApiResponse(responseCode = "400", description = "Could not fetch the completed events, it may not be present")})
	@GetMapping("/completed")
	public ResponseEntity<?> fetchCompletedEvents()
	{
		return eventService.fetchCompletedEvents();
	}
}

package org.jsp.eventManagement.controller;

import org.jsp.eventManagement.entity.A_2Event;
import org.jsp.eventManagement.service.A_7EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/events", "/e", "/eve"})
public class A_6EventController {
	
	@Autowired
	private A_7EventService eventService;
	
	@PostMapping
	public ResponseEntity<?> saveEvent(@RequestBody A_2Event event)
	{
		return eventService.saveEvent(event);
	}
}

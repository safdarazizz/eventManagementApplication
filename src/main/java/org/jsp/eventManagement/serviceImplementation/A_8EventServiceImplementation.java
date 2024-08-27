package org.jsp.eventManagement.serviceImplementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.eventManagement.dao.A_9EventDao;
import org.jsp.eventManagement.entity.A_2Event;
import org.jsp.eventManagement.exceptionClasses.A_12NoEventFoundException;
import org.jsp.eventManagement.exceptionClasses.A_14InvalidEventIdException;
import org.jsp.eventManagement.exceptionClasses.A_15EventNotFoundException;
import org.jsp.eventManagement.responseStructure.A_5ResponseStructure;
import org.jsp.eventManagement.service.A_7EventService;
import org.jsp.eventManagement.util.A_3EventStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class A_8EventServiceImplementation implements A_7EventService{

	@Autowired
	private A_9EventDao eventDao;
	
	@Override
	public ResponseEntity<?> saveEvent(A_2Event event) {
		event.setStatus(A_3EventStatus.UP_COMING);
		
		int yyyy = Integer.parseInt(event.getFromDateTime().toString().substring(0, 4));
		int mm = Integer.parseInt(event.getFromDateTime().toString().substring(5, 7));
		int dd = Integer.parseInt(event.getFromDateTime().toString().substring(8, 10));
		int hh = Integer.parseInt(event.getFromDateTime().toString().substring(11, 13));
//		int min = Integer.parseInt(event.getFromDateTime().toString().substring(14, 16)); // Event though 16th index is not present it will not consider it as it is considered as last index - 1 // Or
		int min = Integer.parseInt(event.getFromDateTime().toString().substring(14)); // If we don't provide anything as the second argument then by default it will take up to the last index
		
		event.setFromDateTime(LocalDateTime.of(yyyy, mm, dd, hh, min));
		
		int yyyy1 = Integer.parseInt("" + event.getToDateTime().toString().substring(0, 4));
		int mm1 = Integer.parseInt("" + event.getToDateTime().toString().substring(5, 7));
		int dd1 = Integer.parseInt("" + event.getToDateTime().toString().substring(8, 10));
		int hh1 = Integer.parseInt("" + event.getToDateTime().toString().substring(11, 13));
		int min1 = Integer.parseInt("" + event.getToDateTime().toString().substring(14));
		
		event.setToDateTime(LocalDateTime.of(yyyy1, mm1, dd1, hh1, min1)); // Should be sent in this format "2024-08-27T20:00" where T is the separation for time and colon for minute
		
		A_2Event dbEvent  = eventDao.saveEvent(event);
		
		return ResponseEntity.status(HttpStatus.OK).body(A_5ResponseStructure.builder().status(HttpStatus.OK.value()).message("Event Saved Successfully").body(dbEvent).build());
	}

	@Override
	public ResponseEntity<?> fetchAllEvents() {
		List<A_2Event> eventList = eventDao.fetchAllEvents();
		
		if(eventList.isEmpty())
			throw A_12NoEventFoundException.builder().message("No event present in the database table").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(A_5ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Events found Successfully").body(eventList).build());
	}

	@Override
	public ResponseEntity<?> setStatusToOngoing(int id) {
		Optional<A_2Event> optional = eventDao.findEventById(id);
		
		if(optional.isEmpty())
			throw A_14InvalidEventIdException.builder().message("Invalid Task ID").build();
		
		A_2Event event = optional.get();
		event.setStatus(A_3EventStatus.ON_GOING);
		A_2Event updatedEvent = eventDao.updateEvent(event);
		
		return ResponseEntity.status(HttpStatus.OK).body(A_5ResponseStructure.builder().status(HttpStatus.OK.value()).message("Event Status changed to ON_GOING successfully").body(updatedEvent).build());
	}

	@Override
	public ResponseEntity<?> setStatusToCompleted(int id) {
		Optional<A_2Event> optional = eventDao.findEventById(id);
		
		if(optional.isEmpty())
			throw A_14InvalidEventIdException.builder().message("Invalid Task ID").build();
		
		A_2Event event = optional.get();
		event.setStatus(A_3EventStatus.COMPLETED);
		A_2Event updatedEvent = eventDao.updateEvent(event);
		
		return ResponseEntity.status(HttpStatus.OK).body(A_5ResponseStructure.builder().status(HttpStatus.OK.value()).message("Event Status changed to COMPLETED successfully").body(updatedEvent).build());
	}

	@Override
	public ResponseEntity<?> setStatusToUpcoming(int id) {
		Optional<A_2Event> optional = eventDao.findEventById(id);
		
		if(optional.isEmpty())
			throw A_14InvalidEventIdException.builder().message("Invalid Task ID").build();
		
		A_2Event event = optional.get();
		event.setStatus(A_3EventStatus.UP_COMING);
		A_2Event updatedEvent = eventDao.updateEvent(event);
		
		return ResponseEntity.status(HttpStatus.OK).body(A_5ResponseStructure.builder().status(HttpStatus.OK.value()).message("Event Status changed to UP_COMING successfully").body(updatedEvent).build());
	}

	@Override
	public ResponseEntity<?> fetchUpcomingEvents() {
		List<A_2Event> eventList = eventDao.fetchAllEvents();
		ArrayList<A_2Event> aList = new ArrayList<>();
		
		for(A_2Event e : eventList)
		{
			if(e.getStatus().toString().equalsIgnoreCase("UP_COMING"))
				aList.add(e);
		}
		
		if(aList.isEmpty())
			throw A_15EventNotFoundException.builder().message("No upcoming event present in the database table").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(A_5ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Upcoming Events found Successfully").body(aList).build());
	}

	@Override
	public ResponseEntity<?> fetchOngoingEvents() {
		List<A_2Event> eventList = eventDao.fetchAllEvents();
		ArrayList<A_2Event> aList = new ArrayList<>();
		
		for(A_2Event e : eventList)
		{
			if(e.getStatus().toString().equalsIgnoreCase("ON_GOING"))
				aList.add(e);
		}
		
		if(aList.isEmpty())
			throw A_15EventNotFoundException.builder().message("No ongoing event present in the database table").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(A_5ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Ongoing Events found Successfully").body(aList).build());
	}

	@Override
	public ResponseEntity<?> fetchCompletedEvents() {
		List<A_2Event> eventList = eventDao.fetchAllEvents();
		ArrayList<A_2Event> aList = new ArrayList<>();
		
		for(A_2Event e : eventList)
		{
			if(e.getStatus().toString().equalsIgnoreCase("COMPLETED"))
				aList.add(e);
		}
		
		if(aList.isEmpty())
			throw A_15EventNotFoundException.builder().message("No completed event present in the database table").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(A_5ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Completed Events found Successfully").body(aList).build());
	}
}

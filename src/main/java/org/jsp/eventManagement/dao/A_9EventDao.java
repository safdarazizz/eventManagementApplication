package org.jsp.eventManagement.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.eventManagement.entity.A_2Event;

public interface A_9EventDao {

	A_2Event saveEvent(A_2Event event);

	List<A_2Event> fetchAllEvents();

	Optional<A_2Event> findEventById(int id);

	A_2Event updateEvent(A_2Event event);
}

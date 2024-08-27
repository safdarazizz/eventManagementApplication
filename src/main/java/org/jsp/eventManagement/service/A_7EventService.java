package org.jsp.eventManagement.service;

import org.jsp.eventManagement.entity.A_2Event;
import org.springframework.http.ResponseEntity;

public interface A_7EventService {

	ResponseEntity<?> saveEvent(A_2Event event);

}

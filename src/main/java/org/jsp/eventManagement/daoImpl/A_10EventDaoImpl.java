package org.jsp.eventManagement.daoImpl;

import org.jsp.eventManagement.dao.A_9EventDao;
import org.jsp.eventManagement.entity.A_2Event;
import org.jsp.eventManagement.repository.A_4EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class A_10EventDaoImpl implements A_9EventDao {

	@Autowired
	private A_4EventRepository eventRepository;

	@Override
	public A_2Event saveEvent(A_2Event event) {
		return eventRepository.save(event);
	}
}

package org.jsp.eventManagement.repository;

import java.util.List;

import org.jsp.eventManagement.entity.A_2Event;
import org.jsp.eventManagement.util.A_3EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface A_4EventRepository extends JpaRepository<A_2Event, Integer> {

	List<A_2Event> findByStatus(A_3EventStatus upComing);

}

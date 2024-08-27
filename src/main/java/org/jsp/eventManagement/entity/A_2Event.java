package org.jsp.eventManagement.entity;

import java.time.LocalDateTime;

import org.jsp.eventManagement.util.A_3EventStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class A_2Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String organizer;
	private String chiefGuest;
	
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	
	@Enumerated(EnumType.STRING)
	private A_3EventStatus status;
}

package org.jsp.eventManagement.responseStructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class A_5ResponseStructure<T> {
	
	private int status;
	private String message;
	private T body;
}

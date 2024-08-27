package org.jsp.eventManagement.exceptionClasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class A_14InvalidEventIdException extends RuntimeException{
	
	private String message;
	
	A_14InvalidEventIdException(String message)
	{
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}

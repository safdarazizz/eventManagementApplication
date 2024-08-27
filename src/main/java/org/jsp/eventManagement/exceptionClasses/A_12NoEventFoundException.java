package org.jsp.eventManagement.exceptionClasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class A_12NoEventFoundException extends RuntimeException{
	
	private String message;
	
	A_12NoEventFoundException(String message)
	{
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}

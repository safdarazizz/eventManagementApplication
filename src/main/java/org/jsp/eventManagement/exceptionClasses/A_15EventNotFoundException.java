package org.jsp.eventManagement.exceptionClasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class A_15EventNotFoundException extends RuntimeException {
	
	private String message;
	
	A_15EventNotFoundException(String message)
	{
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}

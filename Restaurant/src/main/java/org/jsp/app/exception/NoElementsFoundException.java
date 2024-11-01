package org.jsp.app.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NoElementsFoundException extends RuntimeException {
	
	private String message;
	private NoElementsFoundException() {
		super("No Bills Found");
	}
	private NoElementsFoundException(String message) {
		this.message=message;
	}
	@Override
	public String toString() {
		return this.message;
	}
}

package org.jsp.app.exception;

import javax.naming.directory.InvalidAttributeIdentifierException;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class InvalidDataException extends RuntimeException {
	private String message;
	private InvalidDataException() {
		super("Invalid Data");
	}
	private InvalidDataException(String message) {
		this.message=message;
	}
	@Override
	public String toString() {
		return this.message;
	}
}

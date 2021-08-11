package com.jhanmorales.TestColfondos.util;

public class BusinessException extends Exception {
	
	
	public BusinessException(String message) {
        super(message);
    }
	
	public BusinessException(String message, Throwable t) {
		super(message, t);
	}
}

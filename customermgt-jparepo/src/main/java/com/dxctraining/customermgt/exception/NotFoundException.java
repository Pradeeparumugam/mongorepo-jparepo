package com.dxctraining.customermgt.exception;

public class NotFoundException extends RuntimeException{
	public NotFoundException(String alert) {
		super(alert);
	}

}

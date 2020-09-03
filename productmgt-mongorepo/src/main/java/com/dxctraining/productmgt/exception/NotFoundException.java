package com.dxctraining.productmgt.exception;

public class NotFoundException extends RuntimeException{
	public NotFoundException(String alert) {
		super(alert);
	}

}

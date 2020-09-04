package com.dxctraining.wishlistmgt.exception;

public class NotFoundException extends RuntimeException{
	public NotFoundException(String alert) {
		super(alert);
	}

}

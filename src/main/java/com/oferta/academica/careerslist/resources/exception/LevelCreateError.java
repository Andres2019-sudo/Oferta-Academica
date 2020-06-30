package com.oferta.academica.careerslist.resources.exception;

public class LevelCreateError extends Exception {

	private static final long serialVersionUID = -7717691994704695707L;
	
	public static final String DESCRIPTION="Bad information send";
	
	public LevelCreateError() {
		super(DESCRIPTION);
	}
	
	public LevelCreateError(String message) {
		super(DESCRIPTION+""+message);
	}
	
}

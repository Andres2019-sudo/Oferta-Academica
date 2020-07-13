package com.oferta.academica.careerslist.resources.exception;

public class CareerDontFound extends Exception{

	private static final long serialVersionUID = -7717691994704695707L;

	public static final String DESCRIPTION = "Career don't found";

	public CareerDontFound() {
		super(DESCRIPTION);
	}

	public CareerDontFound(String message ) {
		super(DESCRIPTION + " " +message);
	}
}

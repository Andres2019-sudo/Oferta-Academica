package com.oferta.academica.careerslist.resources.exception;

public class LevelDontFound extends Exception {
	
private static final long serialVersionUID = -7717691994704695707L;
	
	public static final String DESCRIPTION="No se encontró el nivel";
	
	public LevelDontFound() {
		super(DESCRIPTION);
	}
	
	public LevelDontFound(String message ) {
		super(DESCRIPTION + " " +message);
	}

}

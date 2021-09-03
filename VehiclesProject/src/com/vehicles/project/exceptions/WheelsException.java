package com.vehicles.project.exceptions;


public class WheelsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String MAXIMO_RUEDAS = "Máximo 2 ruedas delanteras y 2 traseras";	
	public static final String RUEDAS_DISTINTAS = "Los diámetros de las ruedas delanteras y traseras deben ser iguales";
	/*public static final String DIAMETRO_NO_VALIDO = "El diámetro de la rueda tiene que ser superior a 0,4 e inferior a 4,0";
	public static final String DIAMETRO_VALOR = "El diámetro tiene que ser un número decimal [Ej: 0,4]";*/
	
	
	public WheelsException(String mensaje) {
		super(mensaje);
		
	}

}

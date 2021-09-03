package com.vehicles.project.exceptions;


public class WheelsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String MAXIMO_RUEDAS = "M�ximo 2 ruedas delanteras y 2 traseras";	
	public static final String RUEDAS_DISTINTAS = "Los di�metros de las ruedas delanteras y traseras deben ser iguales";
	/*public static final String DIAMETRO_NO_VALIDO = "El di�metro de la rueda tiene que ser superior a 0,4 e inferior a 4,0";
	public static final String DIAMETRO_VALOR = "El di�metro tiene que ser un n�mero decimal [Ej: 0,4]";*/
	
	
	public WheelsException(String mensaje) {
		super(mensaje);
		
	}

}

package com.vehicles.project.exceptions;

public class LicenseException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	//mensaje para tipo de carnet(A,B,C)
	public static final String TIPO_LICENCIA_INCORRECTA = "El tipo de licencia no permite crear el vehículo elegido";
	public static final String TIPO_INCORRECTO = "El tipo de licencia no es correcto";
	
	//mensajes para el id de la licencia
	public static final String FORMATO_NO_CORRECTO="La licencia debe tener 8 números y una letra final";
	public static final String PARTE_LETRA_INCORRECTA="El último carácter debe ser una letra entre A y Z";
	public static final String LICENCIA_NO_VALIDA="La licencia es incorrecta";

			
	public LicenseException(String mensaje) {
		super(mensaje);
	}
}

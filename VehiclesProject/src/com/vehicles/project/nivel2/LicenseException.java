package com.vehicles.project.nivel2;

public class LicenseException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public static final String TIPO_LICENCIA_INCORRECTA = "El tipo de licencia no permite crear el vehículo elegido";
			
	public LicenseException(String mensaje) {
		super(mensaje);
	}
}

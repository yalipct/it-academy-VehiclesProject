package com.vehicles.project.nivel2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.vehicles.project.exceptions.LicenseException;

public class DriverLicense {

	private String licenseId;
	private char licenseType; //A(moto), B(coche) o C(camión)
	private String name;
	private String lastname;	
	//fecha caducidad
	private LocalDate fechaCad;
	
	//constructor con 5 parámetros
	public DriverLicense(String licenseId, char licenseType, String name, String lastname, String fecha) {		
		
		this.licenseId=licenseId;		
		this.licenseType=licenseType;
		this.name = name;
		this.lastname=lastname;
		try {
			LocalDate fechaFormateada = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			this.fechaCad=fechaFormateada;
			
		} catch (DateTimeParseException e) {
			System.err.println("Formato de fecha incorrecto");
        }	
	}
	
	//constructor por defecto
	public DriverLicense() {}
	

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		
		this.licenseId=licenseId;
		
	}

	public char getLicenseType() {	
		
		return licenseType; 		
	}

	public void setLicenseType(char licenseType){		
			
		this.licenseType=licenseType;	
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	   
	public String getFechaCad() {
		DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fecha=formato.format(fechaCad);
		
	    return fecha;
	}

	public void setFechaCad(String fecha) {
		try {
			LocalDate fechaFormateada = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			this.fechaCad=fechaFormateada;
			
		} catch (DateTimeParseException e) {
			System.err.println("Formato de fecha incorrecto");
        }
	}
	

	//validar el número de licencia del usuario(conductor/titular)
	public boolean validarLicenseId(String licenseId) throws LicenseException{
		boolean esValido=false;
		if(licenseId.length()==9) {
			esValido=true;
		}else {
			throw new LicenseException(LicenseException.FORMATO_NO_CORRECTO);
		}
		
		if(esValido) {
			char letra=licenseId.substring(licenseId.length()-1, licenseId.length()).toUpperCase().charAt(0);
			if(Character.isDigit(letra)) {
				esValido=false;
				throw new LicenseException(LicenseException.PARTE_LETRA_INCORRECTA);
			}else {
				String numero=licenseId.substring(0, licenseId.length()-1);
							
				try {
					Integer.parseInt(numero);
					esValido=true;
					
				}catch(NumberFormatException e) {
					throw new LicenseException(LicenseException.FORMATO_NO_CORRECTO);
				}
			}
		}
		return esValido;

	}
	
	public boolean validarTipoLicencia(String tipo) throws LicenseException {
				
		boolean tipo_correcto=false;
		if(tipo.length()>1 || tipo.isEmpty() || Character.isDigit(tipo.charAt(0))){
			throw new LicenseException(LicenseException.TIPO_INCORRECTO);	
			
		}else if(tipo.charAt(0)>'A' &&  tipo.charAt(0)>'C') {
				throw new LicenseException(LicenseException.TIPO_INCORRECTO);
		}
		tipo_correcto=true;
		
		return tipo_correcto;		
	}

	@Override
	public String toString() {
		return "DriverLicense [licenseId=" + getLicenseId() + ", licenseType=" + getLicenseType() + ", name=" + getname()
				+ ", lastname=" + getLastname() + ", fechaCad=" + getFechaCad() + "]";
	}
	
}

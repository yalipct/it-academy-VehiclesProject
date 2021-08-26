package com.vehicles.project.nivel2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DriverLicense {

	private int Id;
	private static int IdSiguiente;
	private char licenseType; //A(moto), B(coche) o C(camión)
	private String name;
	private String lastname;	
	//fecha caducidad
	private LocalDate fechaCad;
	
	
	public DriverLicense(char licenseType, String name, String lastname, String fecha) {
		++IdSiguiente;
		Id=IdSiguiente;		
		this.licenseType=licenseType;
		this.name = name;
		this.lastname=lastname;
		this.setFechaCad(fecha);
	}
	
	public DriverLicense() {
		
	}
		
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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
			System.err.println("Fecha incorrecta");
        }
	}

}

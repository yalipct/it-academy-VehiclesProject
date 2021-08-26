package com.vehicles.project.nivel2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Persona {

	protected String name;
	protected String lastname;
	//fecha de nacimiento
	protected LocalDate fechaNac;
	
	
	
	public Persona(String name, String lastname, String fecha) {
		this.name = name;
		this.lastname = lastname;
		this.setFechaNac(fecha);		
		
	}

	public Persona() {
	
	}
	
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFechaNac() {
		
		DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fecha=formato.format(fechaNac);
		
	    return fecha;
	}

	public void setFechaNac(String fecha){
				
		try {
			LocalDate fechaFormateada = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			this.fechaNac=fechaFormateada;
			
		} catch (DateTimeParseException e) {
			System.err.println("Formato de fecha incorrecto");
			
        }	
	}


}

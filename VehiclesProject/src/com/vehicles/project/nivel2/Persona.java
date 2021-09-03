package com.vehicles.project.nivel2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Persona {

	protected String name;
	protected String lastname;
	// fecha de nacimiento
	protected LocalDate fechaNac;
	
	//constructor con 3 parámetros
	public Persona(String name, String lastname, String fecha) {
		this.name = name;
		this.lastname = lastname;

		try {
			LocalDate fechaFormateada = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			this.fechaNac = fechaFormateada;

		} catch (DateTimeParseException e) {
			System.err.println("Formato de fecha incorrecto");

		}

	}
	
	//constructor por defecto
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
	
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public void setFechaNac(String fecha) {
		try {
			LocalDate fechaFormateada = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			this.fechaNac=fechaFormateada;
			
		} catch (DateTimeParseException e) {
			System.err.println("Formato de fecha incorrecto");
        }
	}
	
	
	//método para validar la fecha
	public boolean esFechaValida(String fecha) {
		boolean esFechaValida = true;
		try {
			LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		} catch (DateTimeParseException e) {
			esFechaValida = false;

		}
		return esFechaValida;
	}

}

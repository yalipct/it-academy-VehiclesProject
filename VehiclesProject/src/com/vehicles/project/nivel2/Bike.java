package com.vehicles.project.nivel2;

import java.util.List;

import com.vehicles.project.exceptions.LicenseException;
import com.vehicles.project.exceptions.WheelsException;

public class Bike extends Vehicle {
	
	//constructor con 3 par�metros
	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	//constructor por defecto
	public Bike() {
		
	}
	
	//a�ade las ruedas a la moto
	public void addWheels(Wheel frontWheel, Wheel backWheel) throws WheelsException {
		this.wheels.add(frontWheel);
		this.wheels.add(backWheel);
	}
	
	//implementaci�n del m�todo de la clase veh�culo para a�adir ruedas
	public void addTwoWheels(List<Wheel> wheels) throws WheelsException {
		
		if (wheels.get(0).getDiameter()!=wheels.get(1).getDiameter()) 
			throw new WheelsException(WheelsException.RUEDAS_DISTINTAS);
		
		this.wheels.add(wheels.get(0));
		this.wheels.add(wheels.get(1));			
	}
	
	// m�todo comprobar licencia para conducir una moto
	public boolean comprobarLicencia(char license) throws LicenseException {
		
		if (license != 'A') {
			throw new LicenseException(LicenseException.TIPO_LICENCIA_INCORRECTA);
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Bike [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels + " \n"
				+ getTitular() + "] \n"
				+ getConductor() + "]";
	}
	

}

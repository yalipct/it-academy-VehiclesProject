package com.vehicles.project.nivel2;

import java.util.List;

import com.vehicles.project.exceptions.LicenseException;
import com.vehicles.project.exceptions.WheelsException;

public class Truck extends Vehicle{
	
	//constructor con 3 par�metros
	public Truck(String plate, String brand, String color) {
		super(plate, brand, color);		
	}	
	
	//constructor por defecto
	public Truck() {
	}
	
	//a�ade las ruedas al cami�n
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws WheelsException {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}
	
	//implementaci�n del m�todo de la clase veh�culo para a�adir ruedas
	public void addTwoWheels(List<Wheel> wheels) throws WheelsException {
		if (wheels.size() != 2)
			throw new WheelsException(WheelsException.MAXIMO_RUEDAS);

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (rightWheel.getDiameter()!=leftWheel.getDiameter()) 
			throw new WheelsException(WheelsException.RUEDAS_DISTINTAS);
		
		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}
	
	// m�todo comprobar licencia para conducir un cami�n
	public boolean comprobarLicencia(char license) throws LicenseException {

		if (license != 'C') {
			throw new LicenseException(LicenseException.TIPO_LICENCIA_INCORRECTA);
		}
		return true;
	}

	@Override
	public String toString() {
		return "Truck [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels + " \n"
				+ getTitular() + "] \n"
				+ getConductor() + "]";
	}

	
}

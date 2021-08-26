package com.vehicles.project.nivel2;
import java.util.List;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color, TitularVehicle titular) {
		super(plate, brand, color, titular);		
	}
	public Car() {
	}
	

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception();

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}
		
	@Override
	public String toString() {
		return "Car [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels + ", titular="
				+ titular.getName() + "]";
	}	
	
	
	// m�todo comprobar licencia
	public boolean comprobarLicencia(char license) throws LicenseException {

		if (!(license=='B' || license=='b')) {			
			throw new LicenseException(LicenseException.TIPO_LICENCIA_INCORRECTA);
		}else {			
			return true;
		}
					
	}
}
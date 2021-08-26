package com.vehicles.project.nivel2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Vehicle {	
	Scanner input;
		
	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	protected TitularVehicle titular;
	protected List<Persona> conductores = new ArrayList<>();	

	public Vehicle(String plate, String brand, String color, TitularVehicle titular) {
	
		this.plate=plate;
		this.brand = brand;
		this.color = color;
		this.titular=titular;		
	}
	
	public Vehicle() {
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;				
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
			
	public TitularVehicle getTitular() {
		return titular;
	}

	public void setTitular(TitularVehicle titular) {
		this.titular = titular;
	}
	
	public String agregarConductor(Persona p) {
		conductores.add(p);
		
		return "Ingreso exitoso";
	}

	 

	// m�todo para pedir los datos del veh�culo
	public void pedirDatosVehicle() {
		
		input= new Scanner(System.in);
		
		do {
			System.out.println("Introduce la matr�cula del veh�culo: ");
			plate = input.nextLine();

			// comprobar que la matr�cula tenga 4 n�meros y tres letras
			if (!validarMatricula(plate)) {
				System.out.println("La matr�cula debe teber 4 n�meros y 3 letras");
			}

		} while (!validarMatricula(plate));

		System.out.println("Introduce la marca del veh�culo: ");
		brand = input.nextLine();

		System.out.println("Introduce el color del veh�culo: ");
		color = input.nextLine();
	}
		
	
	// comprobar la matr�cula
	public boolean validarMatricula(String texto) {

		return texto.matches("^[0-9]{4}[A-Za-z]{3}$");

	}
		
	public abstract boolean comprobarLicencia(char license) throws LicenseException;

}

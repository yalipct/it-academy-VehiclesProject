package com.vehicles.project.nivel1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
	
	public Vehicle() {
		this.plate="";
		this.brand="";
		this.color="";
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
		
	public List<Wheel> getWheels() {
		return wheels;
	}

	public void setWheels(List<Wheel> wheels) {
		this.wheels = wheels;
	}

	//metodos
	Scanner entrada = new Scanner(System.in);

	// m�todo para pedir los datos del veh�culo
	public void pedirDatosVehicle() {
		do {
			System.out.println("Introduce la matr�cula del veh�culo: ");
			plate = entrada.next();

			// comprobar que la matr�cula tenga 4 n�meros y tres letras
			if (!validarMatricula(plate)) {
				System.err.println("La matr�cula debe teber 4 n�meros y 3 letras");
			}

		} while (!validarMatricula(plate));

		System.out.println("Introduce la marca del veh�culo: ");
		brand = entrada.next();

		System.out.println("Introduce el color del veh�culo: ");
		color = entrada.next();
	}
		
	
	// comprobar la matr�cula
	public boolean validarMatricula(String texto) {

		return texto.matches("^[0-9]{4}[A-Za-z]{3}$");

	}	

}

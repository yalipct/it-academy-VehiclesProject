package com.vehicles.project.nivel2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vehicles.project.exceptions.WheelsException;

public abstract class Vehicle {	
	Scanner input;
		
	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	protected TitularVehicle titular;
	protected Conductor conductor;
	protected List<Persona> listaConductores;	

	//constructor con 3 parámetros
	public Vehicle(String plate, String brand, String color) {	
		this.plate=plate;
		this.brand = brand;
		this.color = color;		
	}
	
	//constructor por defecto
	public Vehicle() {
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		
		if(validarMatricula(plate)) {
			this.plate = plate;			
		}					
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
			
	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public List<Wheel> getWheels() {
		return wheels;
	}	
	

	public TitularVehicle getTitular() {
		return titular;
	}

	public void setTitular(TitularVehicle titular) {
		this.titular = titular;
	}
	
	/*
	public List<Persona> agregarConductores(Persona p) {
		this.listaConductores = new ArrayList<>();
		listaConductores.add(p);
		
		return listaConductores;
	}
	
	public void imprimirListadoConductores() {
		System.out.println("-------------------------------------");
		System.out.println("Listado de conductores registrados");
		System.out.println("-------------------------------------");
		
		for (Persona lista : listaConductores) {
			System.out.println(lista);
		}
	}
	*/ 

	// método para pedir los datos del vehículo
	public void pedirDatosVehicle() {
		
		input= new Scanner(System.in);
		
		String plate;
		do {
			System.out.println("Introduce la matrícula del vehículo: ");
			plate = input.nextLine();

			// comprobar que la matrícula tenga 4 números y tres letras
			if (!validarMatricula(plate)) {
				System.err.println("La matrícula debe teber 4 números y 3 letras");
			}

		} while (!validarMatricula(plate));
		
		this.setPlate(plate);

		System.out.println("Introduce la marca del vehículo: ");
		brand = input.nextLine();

		System.out.println("Introduce el color del vehículo: ");
		color = input.nextLine();
	}
		
	
	// validar la matrícula
	public boolean validarMatricula(String texto) {

		return texto.matches("^[0-9]{4}[A-Za-z]{3}$");

	}
	
	//método para añadir ruedas según tipo de vehículo
	public abstract void addTwoWheels(List<Wheel> wheels) throws WheelsException;
	

	@Override
	public String toString() {
		return "Vehicle [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels + "]";
	}
}

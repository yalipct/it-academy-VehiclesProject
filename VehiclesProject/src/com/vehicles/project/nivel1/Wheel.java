package com.vehicles.project.nivel1;

import java.util.ArrayList;
import java.util.Scanner;

public class Wheel {

	static Scanner entrada = new Scanner(System.in);

	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	public Wheel() {
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {		
		this.diameter = diameter;
	}

	public static ArrayList<Wheel> wheelsData(String rightWheel, String leftWheel) {
		ArrayList<Wheel> wheels = new ArrayList<>();
		Wheel wheel1 = new Wheel();
		Wheel wheel2 = new Wheel();

		double numero;
		boolean esDouble=true;
		System.out.println("Introduce la marca de la rueda " + rightWheel + ": ");
		wheel1.setBrand(entrada.nextLine());

		do {
			System.out.println("Introduce el diámetro de la rueda " + rightWheel + ": ");
			
			try {
				numero = Double.parseDouble(entrada.nextLine());
				esDouble=true;				
			} catch (NumberFormatException e) {
				numero=0.0;
				esDouble=false;
				System.err.println("El diámetro de la rueda tiene que ser un número decimal superior a 0,4 e inferior a 4,0");
			}
			if(numero<=0.0) {
				esDouble=false;
			}
			if(!validarDiametroRuedas(numero)) {
				esDouble=false;
			}		
			
		} while (!esDouble);
		
		wheel1.setDiameter(numero);
		wheels.add(wheel1);

		System.out.println("Introduce la marca de la rueda " + leftWheel + ": ");
		wheel2.setBrand(entrada.nextLine());

		do {
			System.out.println("Introduce el diámetro de la rueda " + leftWheel + ": ");
			try {
				numero = Double.parseDouble(entrada.nextLine());
				esDouble=true;				
			} catch (NumberFormatException e) {
				numero=0.0;
				esDouble=false;
				System.err.println("El diámetro de la rueda tiene que ser un número decimal superior a 0,4 e inferior a 4,0");
			}
			if(numero<0.0) {
				esDouble=false;
			}
			if(!validarDiametroRuedas(numero)) {
				esDouble=false;
			}
			
		} while (!esDouble);
		
		wheel2.setDiameter(numero);
		wheels.add(wheel2);

		return wheels;
	}

	// comprobar el diámetro de las ruedas
	public static boolean validarDiametroRuedas(double diameter) {
		if (diameter < 0.4 || diameter > 4) {			
			System.err.println("El diámetro de la rueda debe estar entre 0.4 y 4");
			return false;
		}
		return true;
	}
	

	@Override
	public String toString() {
		return "brand=" + brand + ", diameter=" + diameter;
	}

}

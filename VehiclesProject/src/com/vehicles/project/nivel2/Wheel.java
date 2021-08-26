package com.vehicles.project.nivel2;

import java.util.Scanner;

public class Wheel {
	private String brand;
	private double diameter;	

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.setDiameter(diameter);
	}
	public Wheel(){
		
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
		
		if (diameter < 0.4 || diameter > 4) {	
			
			System.out.println("El diámetro de la rueda tiene que ser superior a 0,4 e inferior a 4");
		}
		this.diameter = diameter;
	}
	
	Scanner entrada = new Scanner(System.in);

	// pedir datos ruedas delanteras
	public void frontWheelsData() {

		System.out.println("Introduce la marca de las ruedas delanteras: ");
		brand = entrada.next();

		do {
			System.out.println("Introduce el diámetro de las ruedas delanteras: ");
			setDiameter(entrada.nextDouble());
			
		} while (diameter < 0.4 || diameter > 4);

	}

	// pedir datos ruedas traseras
	public void backWheelsData() {

		System.out.println("Introduce la marca de las ruedas traseras: ");
		brand = entrada.next();

		do {
			System.out.println("Introduce el diámetro de las ruedas traseras: ");
			setDiameter(entrada.nextDouble());

		} while (diameter < 0.4 || diameter > 4);

	}

	/*
	// comprobar el diámetro de las ruedas
	public boolean validarDiametroRuedas(double diametro) {

		if (diametro < 0.4 || diametro > 4) {			
			return false;
		}

		return true;
	}*/

	@Override
	public String toString() {
		return "brand=" + brand + ", diameter=" + diameter;
	}
	
}

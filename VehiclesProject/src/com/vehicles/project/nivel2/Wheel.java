package com.vehicles.project.nivel2;

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

		double diametro;
		boolean esDouble=true;
		System.out.println("Introduce la marca de la rueda " + rightWheel + ": ");
		wheel1.setBrand(entrada.nextLine());

		do {
			System.out.println("Introduce el di?metro de la rueda " + rightWheel + ": ");
			esDouble=true;
			try {
				diametro = Double.parseDouble(entrada.nextLine());
			} catch (NumberFormatException e) {
				diametro=0.0;
				esDouble=false;
				System.err.println("El di?metro de la rueda tiene que ser un n?mero decimal superior a 0,4 e inferior a 4,0");
			}
			if(diametro<=0.0) {
				esDouble=false;
			}
			if(!validarDiametroRuedas(diametro)) {
				esDouble=false;
			}		

		} while (!esDouble);
		wheel1.setDiameter(diametro);
		wheels.add(wheel1);

		System.out.println("Introduce la marca de la rueda " + leftWheel + ": ");
		wheel2.setBrand(entrada.nextLine());

		do {
			System.out.println("Introduce el di?metro de la rueda " + leftWheel + ": ");
			try {
				diametro = Double.parseDouble(entrada.nextLine());
				esDouble=true;
			} catch (NumberFormatException e) {
				diametro=0.0;
				esDouble=false;
				System.err.println("El di?metro de la rueda tiene que ser un n?mero decimal superior a 0,4 e inferior a 4,0");
			}
			if(diametro<=0.0) {
				esDouble=false;
			}
			if(!validarDiametroRuedas(diametro)) {
				esDouble=false;
			}		

		} while (!esDouble);
		wheel2.setDiameter(diametro);
		wheels.add(wheel2);

		return wheels;
	}

	// comprobar el di?metro de las ruedas
	public static boolean validarDiametroRuedas(double diameter) {
		boolean diametroCorrecto = false;

		if (diameter < 0.4 || diameter > 4) {
			System.err.println("El di?metro de la rueda debe estar entre 0.4 y 4");
			return diametroCorrecto;
		}
		diametroCorrecto = true;

		return diametroCorrecto;
	}

	@Override
	public String toString() {
		return "brand=" + brand + ", diameter=" + diameter;
	}

}

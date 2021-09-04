package com.vehicles.project.nivel1;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.vehicles.project.exceptions.WheelsException;

public class ClasePrincipal {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion;
		boolean salir = false;

		// preguntar al usuario si quiere crear coche o moto

		while (!salir) {
			try {
				System.out.println("Selecciona el vehículo:");
				System.out.println("0: Salir!");
				System.out.println("1: Car");
				System.out.println("2: Bike");
				opcion = entrada.nextInt();

				switch (opcion) {

				case 0:
					salir = true;
					System.out.println("No se ha registrado ningún vehículo");
					System.out.println("¡Hasta pronto!");
					break;

				case 1:
					// crear el objeto coche
					Car coche = new Car();

					// llamada método pedir datos del vehículo
					coche.pedirDatosVehicle();

					// crear el obj coche con los datos
					coche = new Car(coche.getPlate(), coche.getBrand(), coche.getColor());

					// añadir las ruedas delanteras
					try {
						coche.addWheels(Wheel.wheelsData("delantera derecha", "delantera izquierda"),
								Wheel.wheelsData("trasera derecha", "trasera izquierda"));
					} catch (WheelsException e) {
						System.err.println(e.getMessage());
					}					
					if(coche.getWheels().isEmpty()) {
						System.err.println("No se añadieron ruedas al vehículo");
					}else {
						System.out.println(coche);
					}					
					

					break;

				case 2:
					// crear el objeto moto
					Bike moto = new Bike();

					// llamada método pedir datos del vehículo
					moto.pedirDatosVehicle();

					// crear el obj coche con los datos
					moto = new Bike(moto.getPlate(), moto.getBrand(), moto.getColor());

					/// añadir las ruedas delanteras

					try {
						moto.addTwoWheels(Wheel.wheelsData("delantera", "trasera"));
					} catch (WheelsException e) {
						System.err.println(e.getMessage());
					}					
					if(moto.getWheels().isEmpty()) {
						System.err.println("No se añadieron ruedas al vehículo");						
					}else {
						System.out.println(moto);
					}					
					
					break;

				default:
					System.out.println("El vehiculo que intentas crear no existe");
				}
			}  catch (InputMismatchException e) {
				System.err.println("Debes introducir un número");
				entrada.next();
			}

		}

		// cerrar consola
		entrada.close();

	}

}

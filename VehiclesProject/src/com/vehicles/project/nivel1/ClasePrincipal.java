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
				System.out.println("Selecciona el veh�culo:");
				System.out.println("0: Salir!");
				System.out.println("1: Car");
				System.out.println("2: Bike");
				opcion = entrada.nextInt();

				switch (opcion) {

				case 0:
					salir = true;
					System.out.println("No se ha registrado ning�n veh�culo");
					System.out.println("�Hasta pronto!");
					break;

				case 1:
					// crear el objeto coche
					Car coche = new Car();

					// llamada m�todo pedir datos del veh�culo
					coche.pedirDatosVehicle();

					// crear el obj coche con los datos
					coche = new Car(coche.getPlate(), coche.getBrand(), coche.getColor());

					// a�adir las ruedas delanteras
					try {
						coche.addWheels(Wheel.wheelsData("delantera derecha", "delantera izquierda"),
								Wheel.wheelsData("trasera derecha", "trasera izquierda"));
					} catch (WheelsException e) {
						System.err.println(e.getMessage());
					}					
					if(coche.getWheels().isEmpty()) {
						System.err.println("No se a�adieron ruedas al veh�culo");
					}else {
						System.out.println(coche);
					}					
					

					break;

				case 2:
					// crear el objeto moto
					Bike moto = new Bike();

					// llamada m�todo pedir datos del veh�culo
					moto.pedirDatosVehicle();

					// crear el obj coche con los datos
					moto = new Bike(moto.getPlate(), moto.getBrand(), moto.getColor());

					/// a�adir las ruedas delanteras

					try {
						moto.addTwoWheels(Wheel.wheelsData("delantera", "trasera"));
					} catch (WheelsException e) {
						System.err.println(e.getMessage());
					}					
					if(moto.getWheels().isEmpty()) {
						System.err.println("No se a�adieron ruedas al veh�culo");						
					}else {
						System.out.println(moto);
					}					
					
					break;

				default:
					System.out.println("El vehiculo que intentas crear no existe");
				}
			}  catch (InputMismatchException e) {
				System.err.println("Debes introducir un n�mero");
				entrada.next();
			}

		}

		// cerrar consola
		entrada.close();

	}

}

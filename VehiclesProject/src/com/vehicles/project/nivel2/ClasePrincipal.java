package com.vehicles.project.nivel2;

import java.util.*;

public class ClasePrincipal {

	static Scanner entrada = new Scanner(System.in);
	static List<Vehicle> listadoVehiculos = new ArrayList<>();

	public static void main(String[] args) {

		int opcion;
		boolean salir = false;

		while (!salir) {

			try {

				menuVehiculo();
				opcion = entrada.nextInt();

				switch (opcion) {

				case 0:
					salir = true;
					System.out.println("¡Hasta pronto!");
					break;

				case 1:
					TitularVehicle titularCoche = new TitularVehicle();

					char type = titularCoche.getLicense().getLicenseType();

					Vehicle coche = new Car();

					// Comprobar licencia que lanza una excepción
					if (coche.comprobarLicencia(type)) {

						coche.pedirDatosVehicle();

						// crear el obj coche con los datos
						coche = new Car(coche.getPlate(), coche.getBrand(), coche.getColor(), titularCoche);

						// añadir ruedas delateras
						Wheel ruedas_delanteras = new Wheel();
						ruedas_delanteras.frontWheelsData();
						coche.wheels.add(ruedas_delanteras);

						// añadir ruedas traseras
						Wheel ruedas_traseras = new Wheel();
						ruedas_traseras.backWheelsData();
						coche.wheels.add(ruedas_traseras);

						// ¿El titular será el conductor?
						System.out.println("¿El titular del vehículo será el conductor?: [si]/[no]");

						String respuesta = entrada.next();

						// si, lo añado a la lista de conductores
						if (respuesta.equalsIgnoreCase("si")) {
							
							coche.agregarConductor(titularCoche);
							
						} else if ((respuesta.equalsIgnoreCase("no"))) {

							// no, crear un nuevo usuario (en este caso conductor)
							Conductor driverCoche = new Conductor();

							// comprobar licencia del conductor;
							if (coche.comprobarLicencia(driverCoche.getLicense().getLicenseType())) {

								// agregar el conductor
								coche.agregarConductor(driverCoche);
							} else {
								System.out.println("Su tipo de licencia no le permite crear un coche");
							}

						} else {
							System.out.println("Opción incorrecta");
						}

					}
					// agregar el coche a listVehicles
					agregarVehiculo(coche);

					System.out.println(coche);

					break;

				case 2:
					TitularVehicle titularMoto = new TitularVehicle();

					Vehicle moto = new Bike();

					// Comprobar licencia que lanza una excepción
					if (moto.comprobarLicencia(titularMoto.getLicense().getLicenseType())) {

						moto.pedirDatosVehicle();

						// crear el obj coche con los datos
						moto = new Bike(moto.getPlate(), moto.getBrand(), moto.getColor(), titularMoto);

						// añadir ruedas delateras
						Wheel ruedas_delanteras = new Wheel();
						ruedas_delanteras.frontWheelsData();
						moto.wheels.add(ruedas_delanteras);

						// añadir ruedas traseras
						Wheel ruedas_traseras = new Wheel();
						ruedas_traseras.backWheelsData();
						moto.wheels.add(ruedas_traseras);

						// ¿El titular será el conductor?
						System.out.println("¿El titular del vehículo será el conductor?: [si]/[no]");

						String respuesta = entrada.next();

						// si, lo añadiria a la lista de conductores
						if (respuesta.equalsIgnoreCase("si")) {
							
							moto.agregarConductor(titularMoto);
							
						} else if ((respuesta.equalsIgnoreCase("no"))) {

							// no, crear un nuevo usuario (en este caso conductor)
							Conductor driverMoto = new Conductor();

							// comprobar licencia del conductor;
							if (moto.comprobarLicencia(driverMoto.getLicense().getLicenseType())) {

								// agregaria el conductor
								moto.agregarConductor(driverMoto);
							} else {
								System.out.println("Su tipo de licencia no le permite crear un coche");
							}

						} else {
							System.out.println("Opción incorrecta");
						}

					}
					// agregar el coche a listVehicles
					agregarVehiculo(moto);

					System.out.println(moto);
					
					break;
				case 3:
					TitularVehicle titularCamion = new TitularVehicle();

					Vehicle camion = new Truck();

					// Comprobar licencia que lanza una excepción
					if (camion.comprobarLicencia(titularCamion.getLicense().getLicenseType())) {

						camion.pedirDatosVehicle();

						// crear el obj coche con los datos
						camion = new Truck(camion.getPlate(), camion.getBrand(), camion.getColor(), titularCamion);

						// añadir ruedas delateras
						Wheel ruedas_delanteras = new Wheel();
						ruedas_delanteras.frontWheelsData();
						camion.wheels.add(ruedas_delanteras);

						// añadir ruedas traseras
						Wheel ruedas_traseras = new Wheel();
						ruedas_traseras.backWheelsData();
						camion.wheels.add(ruedas_traseras);

						// ¿El titular será el conductor?
						System.out.println("¿El titular del vehículo será el conductor?: [si]/[no]");

						String respuesta = entrada.next();

						// si, lo añado a la lista de conductores
						if (respuesta.equalsIgnoreCase("si")) {
							
							camion.agregarConductor(titularCamion);
							
						} else if ((respuesta.equalsIgnoreCase("no"))) {

							// no, crear un nuevo usuario (en este caso conductor)
							Conductor driverCamion = new Conductor();

							// comprobar licencia del conductor;
							if (camion.comprobarLicencia(driverCamion.getLicense().getLicenseType())) {

								// agregar el conductor
								camion.agregarConductor(driverCamion);
							} else {
								System.out.println("Su tipo de licencia no le permite crear un coche");
							}

						} else {
							System.out.println("Opción incorrecta");
						}

					}
					// agregar el coche a listVehicles
					agregarVehiculo(camion);

					System.out.println(camion);
					break;

				case 4:
					if (listadoVehiculos == null || listadoVehiculos.isEmpty()) {
						System.out.println("No hay vehiculos para mostrar");
					} else {
						imprimirListadoVehiculos();
					}
					break;

				default:
					System.out.println("El vehiculo que intentas crear no existe");
				}

			} catch (LicenseException e) {

				System.out.println(e.getMessage());

			} catch (InputMismatchException e) {
				System.out.println("Debes introducir un número");
				entrada.next();
			}

		} // fin while

		// cerrar consola
		entrada.close();

	}

	public static void menuUsuario() {
		System.out.println("Selecciona el usuario:");
		System.out.println("0: Salir!");
		System.out.println("1: Conductor");
		System.out.println("2: Titular");
		System.out.println("3: Listado de Usuarios");
	}

	public static void menuVehiculo() {
		System.out.println("Selecciona el vehículo:");
		System.out.println("0: Salir!");
		System.out.println("1: Car");
		System.out.println("2: Bike");
		System.out.println("3: Truck");
		System.out.println("4: Listado de Vehículos");
	}

	public static String agregarVehiculo(Vehicle v) {

		listadoVehiculos.add(v);

		return "Ingreso exitoso";
	}

	public static void imprimirListadoVehiculos() {

		for (Vehicle lista : listadoVehiculos) {
			System.out.println(lista);
		}
	}

}

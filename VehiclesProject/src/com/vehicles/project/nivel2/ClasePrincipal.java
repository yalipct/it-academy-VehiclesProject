package com.vehicles.project.nivel2;

import java.util.*;

import com.vehicles.project.exceptions.*;

public class ClasePrincipal {

	static Scanner entrada = new Scanner(System.in);
	static List<Vehicle> listadoVehiculos = new ArrayList<>();

	public static void main(String[] args) {

		boolean continuar = true;
		char opcion;
		String respuesta;

		while (continuar) {
			try {

				TitularVehicle titular = new TitularVehicle();

				// objeto de tipo conductor almacenará si el titular es el conductor
				Conductor conductor;				
				
				opcion = menuVehiculo();
				
				
				switch (opcion) {

				case 'Q':
					continuar = false;
					System.out.println("No se ha registrado ningún vehículo a nombre de la siguiente persona: \n" + titular);
					System.out.println("¡Hasta pronto!");
					break;

				case 'A':

					Bike moto = new Bike();

					continuar = moto.comprobarLicencia(titular.getLicense().getLicenseType());

					moto.pedirDatosVehicle();

					// crear el obj coche con los datos
					moto = new Bike(moto.getPlate(), moto.getBrand(), moto.getColor());

					moto.setTitular(titular);

					// añadir ruedas puede lanzar la excepción de tipo WheelsException
					do {
						try {
							moto.addTwoWheels(Wheel.wheelsData("delantera", "trasera"));
						} catch (WheelsException e) {
							System.err.println(e.getMessage());
							
						} 

					} while (moto.getWheels().isEmpty());

					// ¿El titular será el conductor?
					System.out.println("¿El titular del vehículo será el conductor?: [si]/[no]");
					respuesta = entrada.nextLine();

					if (respuesta.equalsIgnoreCase("si")) {

						// creo el conductor titular
						conductor = new Conductor(titular.getName(), titular.getLastname(), titular.getFechaNac(),
								titular.getLicense().getLicenseId(), titular.getLicense().getLicenseType(),
								titular.getLicense().getFechaCad());

						moto.setConductor(conductor);

					} else if ((respuesta.equalsIgnoreCase("no"))) {

						// no, crear un nuevo usuario (en este caso conductor)

						Conductor driverMoto = new Conductor(); // pido los datos del conductor
						try {
							// comprobar licencia del conductor;
							if (moto.comprobarLicencia(driverMoto.getLicense().getLicenseType())) {

								// creo el conductor
								driverMoto = new Conductor(driverMoto.getName(), driverMoto.getLastname(),
										driverMoto.getFechaNac(), driverMoto.getLicense().getLicenseId(),
										driverMoto.getLicense().getLicenseType(),
										driverMoto.getLicense().getFechaCad());

								moto.setConductor(driverMoto);

							} // sino se lanza la excepción LicenseException

							/*
							 * si el conductor es nulo pq no tiene la licencia adecuada asigno el titular
							 * como conductor por defecto
							 */
							if (moto.getConductor() == null) {

								conductor = new Conductor(titular.getName(), titular.getLastname(),
										titular.getFechaNac(), titular.getLicense().getLicenseId(),
										titular.getLicense().getLicenseType(), titular.getLicense().getFechaCad());

								moto.setConductor(conductor);
							}

						} catch (LicenseException e) {
							System.err.println(e.getMessage());
							System.err.println("Se ha añadido al titular como conductor por defecto del vehículo");
						}

					} else {
						System.out.println("Opción incorrecta");
					}

					System.out.println(moto);

					continuar = false;

					break;

				case 'B':
					Car coche = new Car();

					continuar = coche.comprobarLicencia(titular.getLicense().getLicenseType());

					coche.pedirDatosVehicle();

					// crear el obj coche con los datos
					coche = new Car(coche.getPlate(), coche.getBrand(), coche.getColor());

					coche.setTitular(titular);

					// añadir ruedas puede lanzar excepción de tipo WheelsException
					do {
						try {
							coche.addWheels(Wheel.wheelsData("delantera derecha", "delantera izquierda"),
									Wheel.wheelsData("trasera derecha", "trasera izquierda"));
						} catch (WheelsException e) {
							System.err.println(e.getMessage());
						}

					} while (coche.getWheels().isEmpty());

					// ¿El titular será el conductor?
					System.out.println("¿El titular del vehículo será el conductor?: [si]/[no]");
					respuesta = entrada.next();

					if (respuesta.equalsIgnoreCase("si")) {

						// creo el conductor titular
						conductor = new Conductor(titular.getName(), titular.getLastname(), titular.getFechaNac(),
								titular.getLicense().getLicenseId(), titular.getLicense().getLicenseType(),
								titular.getLicense().getFechaCad());

						coche.setConductor(conductor);

					} else if ((respuesta.equalsIgnoreCase("no"))) {

						// no, crear un nuevo usuario (en este caso conductor)
						Conductor driverCoche = new Conductor();// pido los datos del conductor

						try {

							// comprobar licencia del conductor;
							if (coche.comprobarLicencia(driverCoche.getLicense().getLicenseType())) {

								// creo el conductor
								driverCoche = new Conductor(driverCoche.getName(), driverCoche.getLastname(),
										driverCoche.getFechaNac(), driverCoche.getLicense().getLicenseId(),
										driverCoche.getLicense().getLicenseType(),
										driverCoche.getLicense().getFechaCad());

								coche.setConductor(driverCoche);

							} // sino se lanza la excepción LicenseException

							/*
							 * si el conductor es nulo pq no tiene la licencia adecuada asigno el titular
							 * como conductor por defecto
							 */
							if (coche.getConductor() == null) {
								conductor = new Conductor(titular.getName(), titular.getLastname(),
										titular.getFechaNac(), titular.getLicense().getLicenseId(),
										titular.getLicense().getLicenseType(), titular.getLicense().getFechaCad());

								coche.setConductor(conductor);
							}

						} catch (LicenseException e) {
							System.err.println(e.getMessage());
							System.err.println("Se ha añadido al titular como conductor por defecto del vehículo");
						}
					} else {
						System.out.println("Opción incorrecta");
					}

					System.out.println(coche);

					continuar = false;

					break;
				case 'C':

					Truck camion = new Truck();

					continuar = camion.comprobarLicencia(titular.getLicense().getLicenseType());

					camion.pedirDatosVehicle();

					// crear el obj coche con los datos
					camion = new Truck(camion.getPlate(), camion.getBrand(), camion.getColor());

					camion.setTitular(titular);

					// añadir ruedas puede lanzar la excepción de tipo WheelsException
					do {
						try {
							camion.addWheels(Wheel.wheelsData("delantera derecha", "delantera izquierda"),
									Wheel.wheelsData("trasera derecha", "trasera izquierda"));						
														
						} catch (WheelsException e) {
							System.err.println(e.getMessage());
						}
					} while (camion.getWheels().isEmpty());

					// ¿El titular será el conductor?
					System.out.println("¿El titular del vehículo será el conductor?: [si]/[no]");
					respuesta = entrada.next();

					// si, lo añado a la lista de conductores
					if (respuesta.equalsIgnoreCase("si")) {

						// creo el conductor titular
						conductor = new Conductor(titular.getName(), titular.getLastname(), titular.getFechaNac(),
								titular.getLicense().getLicenseId(), titular.getLicense().getLicenseType(),
								titular.getLicense().getFechaCad());

						camion.setConductor(conductor);

					} else if ((respuesta.equalsIgnoreCase("no"))) {

						// no, crear un nuevo usuario (en este caso conductor)
						Conductor driverCamion = new Conductor();// pido los datos del conductor

						try {
							// comprobar licencia del conductor;
							if (camion.comprobarLicencia(driverCamion.getLicense().getLicenseType())) {

								// creo el conductor
								driverCamion = new Conductor(driverCamion.getName(), driverCamion.getLastname(),
										driverCamion.getFechaNac(), driverCamion.getLicense().getLicenseId(),
										driverCamion.getLicense().getLicenseType(),
										driverCamion.getLicense().getFechaCad());

								camion.setConductor(driverCamion);

							} // se lanza la excepción LicenseException

							/*
							 * si el conductor es nulo pq no tiene la licencia adecuada asigno el titular
							 * como conductor por defecto
							 */
							if (camion.getConductor() == null) {
								conductor = new Conductor(titular.getName(), titular.getLastname(),
										titular.getFechaNac(), titular.getLicense().getLicenseId(),
										titular.getLicense().getLicenseType(), titular.getLicense().getFechaCad());

								camion.setConductor(conductor);
							}

						} catch (LicenseException e) {
							System.err.println(e.getMessage());
							System.err.println("Se ha añadido al titular como conductor por defecto del vehículo");
						}
					} else {
						System.out.println("Opción incorrecta");
					}

					System.out.println(camion);
					
					continuar = false;

					break;

				default:
					System.out.println("El vehiculo que intentas crear no existe");
				}

			} catch (LicenseException e) {
				System.err.println(e.getMessage());

			} 
		} // fin while

	}

	public static char menuVehiculo() throws LicenseException {
		char type =0;
		String caracter;

		System.out.println("Selecciona el vehículo:");
		System.out.println("a: Bike");
		System.out.println("b: Car");
		System.out.println("c: Truck");
		System.out.println("q: Salir!");
		
		caracter=entrada.nextLine().toUpperCase();
		
		if(caracter.length()>1 || caracter.isEmpty() || Character.isDigit(caracter.charAt(0))) {
			type='Q';
			System.err.println("Opción no válida para crear un vehículo");
		}else {
			type=caracter.charAt(0);
		}
		return type;
	}


	/*
	 * public static String agregarVehiculo(Vehicle v) {
	 * 
	 * listadoVehiculos.add(v);
	 * 
	 * return "Ingreso exitoso"; }
	 * 
	 * public static void imprimirListadoVehiculos() {
	 * 
	 * for (Vehicle lista : listadoVehiculos) { System.out.println(lista); } }
	 */
}

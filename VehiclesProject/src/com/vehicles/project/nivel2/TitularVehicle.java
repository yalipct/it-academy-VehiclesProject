package com.vehicles.project.nivel2;

import java.util.Scanner;

import com.vehicles.project.exceptions.LicenseException;

public class TitularVehicle extends Persona {

	Scanner sc = new Scanner(System.in);

	protected DriverLicense license = new DriverLicense();
	protected boolean insurance;
	protected boolean garage;

	// constructor con parámetros
	public TitularVehicle(String name, String lastname, String fechaNac, String insurance, String garage,
			DriverLicense license) {

		super(name, lastname, fechaNac);

		this.setInsurance(insurance);
		this.setGarage(garage);
	}

	// constructor por defecto
	public TitularVehicle() {

		boolean fechaValida = false; // para validar la fecha

		// menú crear personas(tipo titular)
		System.out.println("-----------------------------------");
		System.out.println("Crear Usuario Titular del Vehículo");
		System.out.println("-----------------------------------");

		System.out.println("Introduce nombre: ");
		name = sc.nextLine();
		license.setname(name);

		System.out.println("Introduce apellido: ");
		lastname = sc.nextLine();
		license.setLastname(lastname);

		// pedir y validar la fecha de nacimiento
		String fechaNac;
		do {
			System.out.println("Introduce fecha de nacimiento con formato dd/mm/yyyy: ");
			fechaNac = sc.nextLine();
			fechaValida = esFechaValida(fechaNac);
			if (!fechaValida) {
				System.err.println("Error: Introduce una fecha válida");
			} else {
				setFechaNac(fechaNac);
			}
		} while (!fechaValida);

		System.out.println("¿Tienes seguro?: [si]/[no]");
		setInsurance(sc.nextLine());

		System.out.println("¿Tienes garage?: [si]/[no]");
		setGarage(sc.nextLine());

		// pedir y validar el número de la licencia de conducir
		String licenseId;
		boolean validId = false;
		do {
			System.out.println("Número de la licencia de conducir (Ej: 12345678P)");
			licenseId = sc.nextLine();
			try {
				validId = license.validarLicenseId(licenseId);
				license.setLicenseId(licenseId);
			} catch (LicenseException e) {
				System.err.println("Error: " + e.getMessage());
			}
		} while (!validId);

		String tipo;
		boolean tipoCorrecto = false;
		do {
			System.out.println("Introduce tipo de licencia: [A]/[B]/[C]");
			tipo = sc.nextLine().toUpperCase(); //
			try {
				tipoCorrecto = license.validarTipoLicencia(tipo);
				license.setLicenseType(tipo.charAt(0));
			} catch (LicenseException e) {
				System.err.println(e.getMessage());
			}

		} while (!tipoCorrecto);

		// pedir y validar la fecha de caducidad de la licencia
		String fechaCad;
		do {
			System.out.println("Introduce fecha de caducidad de la licencia con formato dd/mm/yyyy: ");
			fechaCad = sc.nextLine();
			fechaValida = esFechaValida(fechaCad);
			if (!fechaValida) {
				System.err.println("Error: Introduce una fecha válida");
			} else {
				license.setFechaCad(fechaCad);
			}
		} while (!fechaValida);
	}

	public String getInsurance() {

		if (insurance == true) {
			return "Tiene seguro";
		} else {
			return "No tiene seguro";
		}

	}

	public void setInsurance(String insurance) {

		if (insurance.equalsIgnoreCase("si")) {
			this.insurance = true;
		} else {
			this.insurance = false;
		}

	}

	public String getGarage() {

		if (garage == true) {
			return "Tiene garage";
		} else {
			return "No tiene garage";
		}
	}

	public void setGarage(String garage) {

		if (garage.equalsIgnoreCase("si")) {
			this.garage = true;
		} else {
			this.garage = false;
		}
	}

	public DriverLicense getLicense() {
		return license;
	}

	public void setLicense(DriverLicense license) {
		this.license = license;
	}

	@Override
	public String toString() {
		return "TitularVehicle [name=" + name + ", lastname=" + lastname + ", fechaNac=" + getFechaNac() + ", garage="
				+ garage + ", insurance=" + insurance + "]\n" + license.toString();
	}

}

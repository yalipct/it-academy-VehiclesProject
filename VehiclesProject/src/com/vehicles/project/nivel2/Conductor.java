package com.vehicles.project.nivel2;

import java.util.Scanner;

import com.vehicles.project.exceptions.LicenseException;

public class Conductor extends Persona {

	Scanner sc = new Scanner(System.in);
	protected DriverLicense license = new DriverLicense();

	public Conductor(String name, String lastname, String fechaNac, DriverLicense license) {
		super(name, lastname, fechaNac);
	}

	public Conductor(String name, String lastname, String fechaNac, String licenseId, char licenseType,
			String fechaCad) {
		super(name, lastname, fechaNac);
		this.license.setname(name);
		this.license.setLastname(lastname);
		this.setFechaNac(fechaNac);
		this.license.setLicenseId(licenseId);
		this.license.setLicenseType(licenseType);
		this.license.setFechaCad(fechaCad);
	}

	public Conductor() {

		boolean fechaValida = false; // para validar la fecha

		// menú crear personas(tipo conductor)
		System.out.println("-------------------------------------");
		System.out.println("Crear Usuario Conductor del Vehículo");
		System.out.println("-------------------------------------");

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

		// pedir y validar el número de la licencia de conducir
		boolean validId = false;
		String licenseId;
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
			tipo = sc.nextLine().toUpperCase();
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

	public DriverLicense getLicense() {
		return license;
	}

	public void setLicense(DriverLicense license) {
		this.license = license;
	}

	@Override
	public String toString() {
		return "Conductor [name=" + getName() + ", lastname=" + getLastname() + ", fechaNac=" + getFechaNac() + "]\n"
				+ license.toString();
	}

}

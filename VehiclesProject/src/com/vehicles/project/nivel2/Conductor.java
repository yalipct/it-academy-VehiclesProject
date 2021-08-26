package com.vehicles.project.nivel2;

import java.util.Scanner;

public class Conductor extends Persona{	
	Scanner sc;
	protected DriverLicense license;
	

	public Conductor(String name, String lastname, String fecha, DriverLicense license) {
		super(name, lastname, fecha);
		
		this.license = new DriverLicense();
	}
	
	public Conductor() {
		
		this.license = new DriverLicense();
		
		// menú crear personas(tipo conductor)	
		sc = new Scanner(System.in);
		
		System.out.println("-------------------------------------");
		System.out.println("Crear Usuario Conductor del Vehículo");
		System.out.println("-------------------------------------");

		System.out.println("Introduce nombre: ");
		name = sc.nextLine();
		license.setname(name);
		
		System.out.println("Introduce apellido: ");
		lastname = sc.nextLine();
		license.setLastname(lastname);
		
		System.out.println("Introduce fecha de nacimiento con formato dd/mm/yyyy: ");
		setFechaNac(sc.nextLine());
		
		System.out.println("Introduce tipo de licencia: [A]/[B]/[C]");		
		license.setLicenseType(sc.nextLine().charAt(0));
		
		System.out.println("Introduce fecha de caducidad de la licencia con formato dd/mm/yyyy: ");
		license.setFechaCad(sc.nextLine());	
		
	}	
	
	public DriverLicense getLicense() {
		return license;
	}

	
}

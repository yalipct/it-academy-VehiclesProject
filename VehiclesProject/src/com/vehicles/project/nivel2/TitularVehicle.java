package com.vehicles.project.nivel2;

import java.util.Scanner;

public class TitularVehicle extends Persona{
	
	Scanner sc = new Scanner(System.in);
	
	protected DriverLicense license;
	protected boolean insurance;
	protected boolean garage;
	
	public TitularVehicle(String name, String lastname, String fechaNac, String insurance, String garage, DriverLicense license) {
		
		super(name, lastname, fechaNac);

		this.setInsurance(insurance);
		this.setGarage(garage);	
		this.license = new DriverLicense();
	}
	
	public TitularVehicle() {

		this.license = new DriverLicense();
		
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
		
		System.out.println("Introduce fecha de nacimiento con formato dd/mm/yyyy: ");		
		setFechaNac(sc.nextLine());
		
		System.out.println("¿Tienes seguro?: [si]/[no]");
		setInsurance(sc.nextLine());

		System.out.println("¿Tienes garage?: [si]/[no]");
		setGarage(sc.nextLine());

		System.out.println("Introduce tipo de licencia: [A]/[B]/[C]");
		license.setLicenseType(sc.nextLine().charAt(0));		
		
		System.out.println("Introduce fecha de caducidad de la licencia con formato dd/mm/yyyy: ");
		license.setFechaCad(sc.nextLine());	
	}
	

	public String getInsurance() {
		
		if(insurance==true) {
			return "Tiene seguro";
		}else {
			return "No tiene seguro";
		}		
		
	}

	public void setInsurance(String insurance) {
		
		if(insurance.equalsIgnoreCase("si")) {
			this.insurance = true;
		}else {
			this.insurance = false;
		}
		
	}

	public String getGarage() {
		
		if(garage==true) {
			return "Tiene garage";
		}else {
			return "No tiene garage";
		}
	}

	public void setGarage(String garage) {
		
		if(garage.equalsIgnoreCase("si")) {
			this.garage = true;
		}else {
			this.garage = false;
		}
	}

	public DriverLicense getLicense() {		
	
		return license;
	}

}

package edu.servicios;

import java.util.Scanner;

///
///Autor Carlos 07/03/2024
/// Clase donde se encuentran los menus
///
public class MenuImplementacion implements MenuInterfaz{

	Scanner sc = new Scanner(System.in);
	
	public int eleccion() {
		
			System.out.println("Opción de usuario");
			System.out.println("/////////////////");
			System.out.println("[0] - Cerrar Menú");
			System.out.println("[1] - Empleado");
			System.out.println("[2] - Paciente");
			System.out.println("/////////////////");
			
			int opcion1 = sc.nextInt();
			return opcion1;
	}
	
	public int menuEmpleado(){
		
		System.out.println("Menú de Empleado");
		System.out.println("/////////////////");
		System.out.println("[0] - Volver");
		System.out.println("[1] - Validar nuevo paciente");
		System.out.println("[2] - Imprimir citas médicas para un día específico");
		System.out.println("/////////////////");
		
		int opcionEmpleado = sc.nextInt();
		return opcionEmpleado;
		
		
	}
	public int menuPaciente(){
		
		System.out.println("Menú de Paciente");
		System.out.println("/////////////////");
		System.out.println("[0] - Volver");
		System.out.println("[1] - Registro de cliente");
		System.out.println("[2] - Solicitud de cita médica");
		System.out.println("[3] - Consultar citas médicas para un intervalo de tiempo");
		System.out.println("/////////////////");
		
		int opcionPaciente = sc.nextInt();
		return opcionPaciente;
		
	}
	
	public int menuCitas() {
		
		System.out.println("Menú de citas");
		System.out.println("/////////////");
		System.out.println("[0] - cerrar menú");
		System.out.println("[1] - Psicología");
		System.out.println("[2] - Traumatología");
		System.out.println("[3] - Fisioterapia");
		System.out.println("/////////////");
		
		int opcion = sc.nextInt();
		return opcion;
	}
}

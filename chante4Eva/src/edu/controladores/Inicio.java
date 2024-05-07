package edu.controladores;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import edu.dtos.CitasDto;
import edu.dtos.PacienteDto;

import edu.servicios.MenuImplementacion;
import edu.servicios.MenuInterfaz;
import edu.servicios.OperativaImplementacion;
import edu.servicios.OperativaInterfaz;


///
///Autor Carlos 07/03/2024
/// Clase principal del programa que contiene el main
///
public class Inicio {
	///
	///Autor Carlos 07/03/2024
	/// Metodo main que contienen las llamadas a metodos, menus, etc
	///

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			MenuInterfaz menu = new MenuImplementacion();
			OperativaInterfaz operativa = new OperativaImplementacion();
			List<PacienteDto> pacientes = new ArrayList<PacienteDto>();
			List<CitasDto> citas = new ArrayList<CitasDto>();
			boolean cerrarMenu = false;
			
			LocalDate fechaHoy = LocalDate.now();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
			
			String FechaDeHoy = formatter.format(fechaHoy);
			
			
			String log = "C:\\Users\\Carlos\\Desktop\\log-" + FechaDeHoy + ".txt";
			
			FileWriter escribe = new FileWriter(log, true);
			
			
			
			while(!cerrarMenu) {
				int opcion = menu.eleccion();
				
				switch (opcion) {
				case 0: {
					
					System.out.println("Se cierra el menu");
					escribe.write("Se cierra el menu \n");
					escribe.close();
					cerrarMenu = true;
					break;
				}
				case 1: {
					System.out.println("Menu de Empleado");
					escribe.write("Menu de Empleado \n");
					int opcionEmpleado = menu.menuEmpleado();
					switch (opcionEmpleado) {
					case 0: {
						System.out.println("Volver al menu de inicio");
						escribe.write("Volver al menu de inicio \n");
						break;
					}
					case 1: {
						System.out.println("Validar nuevo paciente");
						escribe.write("Validar nuevo paciente \n");
						operativa.validarCliente(pacientes);
						break;
					}
					
					case 2:{
						System.out.println("Imprimir citas médicas para un día específico");
						escribe.write("Imprimir citas médicas para un día específico \n");
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + opcionEmpleado);
					}
					break;
					
				}
				
				case 2: {
					System.out.println("Menu de Paciente");
					escribe.write("Menu de Paciente \n");
					int opcionPaciente = menu.menuPaciente();
					switch (opcionPaciente) {
					case 0: {
						System.out.println("Volver al menu de inicio");
						escribe.write("Volver al menu de inicio \n");
						break;
					}
					case 1: {
						System.out.println("Registro de cliente");
						escribe.write("Registro de cliente \n");
						operativa.registroCliente(pacientes);
						break;
					}
					
					case 2:{
						System.out.println("Solicitud de cita médica");
						escribe.write("Solicitud de cita médica \n");
						operativa.SolicitudCitaMedica(citas, pacientes);
						break;
					}
					case 3:{
						System.out.println("Consultar citas médicas para un intervalo de tiempo");
						escribe.write("Consultar citas médicas para un intervalo de tiempo \n");
						operativa.entreFechas(citas, pacientes);
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + opcionPaciente);
					}
					break;
					
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + opcion);
				}
				
			}
			escribe.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el inicio de la aplicación " + e.getMessage());
		}
	}

}

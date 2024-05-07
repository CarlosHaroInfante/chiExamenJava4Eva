package edu.servicios;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import edu.dtos.CitasDto;
import edu.dtos.PacienteDto;

///
///Autor Carlos 07/03/2024
/// Clase que contiene los metodos de las operativas
///
public class OperativaImplementacion implements OperativaInterfaz{

	LocalDate fechaHoy = LocalDate.now();
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
	
	String FechaDeHoy = formatter.format(fechaHoy);
	
	
	String log = "C:\\Users\\Carlos\\Desktop\\log-" + FechaDeHoy + ".txt";
	
	
	Scanner sc = new Scanner(System.in);
	public void registroCliente(List<PacienteDto> listaPacientes) {
		
		try {
		FileWriter escribe = new FileWriter(log, true);
		System.out.println("Registrar nuevo cliente");
		//PacienteDto pacienteNuevo = new PacienteDto();
		
		
		System.out.println("Apellidos del cliente");
		String apellidosPaciente = sc.nextLine();
		
		System.out.println("Nombre del cliente");
		String nombrePaciente = sc.next();
		/*pacienteNuevo.setNombre(sc.next());
		
		String nomCompleto = pacienteNuevo.getApellidos() + ", " + pacienteNuevo.getNombre();
		pacienteNuevo.setNombreCompleto(nomCompleto);*/
		
		System.out.println("Dni del cliente");
		String dniPaciente = sc.next();
		
		LocalDateTime fechaAhora = LocalDateTime.now();
		
		
		
		long idPaciente = idAunto(listaPacientes);
		
		PacienteDto paciente = new PacienteDto(idPaciente, dniPaciente, nombrePaciente, apellidosPaciente, fechaAhora);
		
		listaPacientes.add(paciente);
		
		for (PacienteDto pacienteN : listaPacientes) {
			System.out.println(pacienteN.getId() + ";" + paciente.getDni() + ";"+ paciente.getApellidos() + "" +paciente.getNombre());
		}
		
		escribe.write("Se ha registrado un paciente \n");
		escribe.close();
		
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al registrar el paciente" + e.getMessage());
		}
		
		
		
	}
	
	public void validarCliente(List<PacienteDto> listaPacientes) {
		
		try {
			FileWriter escribe = new FileWriter(log, true);
			
			for (PacienteDto pacientesNovalidados : listaPacientes) {
				
				if(pacientesNovalidados.isEsValido() == false) {
				System.out.println(pacientesNovalidados.getDni() + " - " + pacientesNovalidados.getApellidos() + ", " + pacientesNovalidados.getNombre());
				System.out.println("Dni del cliente que quieres validar");
				String dniValido = sc.next();
				
				if(pacientesNovalidados.getDni().equals(dniValido)) {
					pacientesNovalidados.setEsValido(true);
					System.out.println("Se valida el cliente con dni "  + dniValido);
					escribe.write("Se valida el cliente con dni "  + dniValido + "\n");
				}
				else {
					System.out.println("Ningun cliente con dni"  + dniValido);
					escribe.write("Ningun cliente con dni "  + dniValido + "\n");
				}
					
				}
				else {
					System.out.println("Ningún paciente sin el dni válido");
					escribe.write("Ningún paciente sin el dni válido \n");
				}
				
				
				
				escribe.close();
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al validar el paciente" + e.getMessage());
		}
	}
	
	public void SolicitudCitaMedica(List<CitasDto> listaCitas, List<PacienteDto> listaPacientes) {
		try {
			FileWriter escribe = new FileWriter(log, true);
			MenuInterfaz menu = new MenuImplementacion();
			
			boolean cerrarMenu = false;
			
			System.out.println("inserte su dni");
			String dniCliente = sc.next();
			
			for (PacienteDto dniValido : listaPacientes) {
				
				if(dniValido.getDni().equals(dniCliente) && dniValido.isEsValido() == true) {
					
					int num = menu.menuCitas();
					
					switch (num) {
						case 0: {
							System.out.println("Se cierrar el menú");
							cerrarMenu = true;
							break;
						}
						case 1: {
							System.out.println("Psicología");
							
							CitasDto citasNuevas = new CitasDto();
								
							citasNuevas.setEspecialidad("Psicología");
							citasNuevas.setIdCita(idAuntoCita(listaCitas));
							System.out.println("Fecha y hora de la cita yyyy-MM-dd HH:mm");
							LocalDateTime fecha = LocalDateTime.parse(sc.next());
							citasNuevas.setFechaCita(fecha);
							listaCitas.add(citasNuevas);
							escribe.write("Se ha pedido una cita en Psicología");
							escribe.close();
							break;
							
							
						}
						
						case 2:{
							System.out.println("Traumatología");
							
								CitasDto citasNuevas = new CitasDto();
								citasNuevas.setEspecialidad("Traumatología");
								citasNuevas.setIdCita(idAuntoCita(listaCitas));
								System.out.println("Fecha y hora de la cita yyyy-MM-dd HH:mm");
								LocalDateTime fecha = LocalDateTime.parse(sc.next());
								citasNuevas.setFechaCita(fecha);
								listaCitas.add(citasNuevas);
								escribe.write("Se ha pedido una cita en Traumatología");
								escribe.close();
								
								break;
							
						}
						
						case 3:{
								System.out.println("Fisioterapia");
							
								CitasDto citasNuevas = new CitasDto();
								citasNuevas.setEspecialidad("Fisioterapia");
								citasNuevas.setIdCita(idAuntoCita(listaCitas));
								System.out.println("Fecha y hora de la cita yyyy-MM-dd HH:mm");
								LocalDateTime fecha = LocalDateTime.parse(sc.next());
								citasNuevas.setFechaCita(fecha);
								listaCitas.add(citasNuevas);
								escribe.write("Se ha pedido una cita en Fisioterapia");
								escribe.close();
								break;
								}
							
						
						
						
						default:
							throw new IllegalArgumentException("Unexpected value: " + num);
						}
					
					}
				else {
					System.out.println("DNI no validado o no existente");
				}
				for (CitasDto citas : listaCitas) {
						
					System.out.println(citas.getEspecialidad() + ";" + citas.getFechaCita());
				}
		
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Fallo al mostrar la cita médica" + e.getMessage());
		}
	}
	
	
	public void entreFechas(List<CitasDto> listaCitas, List<PacienteDto> listaPacientes) {
		
		try {
			
			FileWriter escribe = new FileWriter(log, true);
			System.out.println("inserte su dni");
			String dniCliente = sc.next();
			
			System.out.println("Fecha Inicio");
			LocalDateTime fechaInicio = LocalDateTime.parse(sc.next());
			
			
			System.out.println("Fecha Fin");
			LocalDateTime fechaFin = LocalDateTime.parse(sc.next());
			
			
			for (PacienteDto paciente : listaPacientes) {
				
				if(paciente.getDni().equals(dniCliente) && paciente.isEsValido() == true) {
				
				for (CitasDto citas : listaCitas) {
				
					
				if(citas.getFechaCita().isBefore(fechaFin) && citas.getFechaCita().isAfter(fechaInicio)) {	
				
				System.out.println("El paciente "+ paciente.getApellidos() + ", " + paciente.getNombre() + " tiene la cita de: " +  citas.getEspecialidad() + " el dia y hora" + citas.getFechaCita());
				escribe.write("Se muestran las citas entre horas");
				}
				
				}
			}
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Fallo al mostrar la cita médica entre fechas" + e.getMessage());
		}
		
	}
	
	private long idAunto(List<PacienteDto> listaPacientes) {
		
		long idN = 0;
		int tamanioLista = listaPacientes.size();
		
		if(tamanioLista > 0) {
			idN = listaPacientes.get(tamanioLista - 1).getId() + 1;
		}
		else {
			idN = 1;
		}
		
		return idN;
		
	}
private long idAuntoCita(List<CitasDto> listaCitas) {
		
		long idN = 0;
		int tamanioLista = listaCitas.size();
		
		if(tamanioLista > 0) {
			idN = listaCitas.get(tamanioLista - 1).getIdCita() + 1;
		}
		else {
			idN = 1;
		}
		
		return idN;
		
	}
}

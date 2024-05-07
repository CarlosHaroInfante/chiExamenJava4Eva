package edu.servicios;

import java.util.List;

import edu.dtos.CitasDto;
import edu.dtos.PacienteDto;
///
///Autor Carlos 07/03/2024
/// Interfaz donde se encuentran los metodos de la operativa
///
public interface OperativaInterfaz {

	public void registroCliente(List<PacienteDto> listaPacientes);
	
	public void validarCliente(List<PacienteDto> listaPacientes);
	
	
	public void SolicitudCitaMedica(List<CitasDto> listaCitas, List<PacienteDto> listaPacientes);
	
	public void entreFechas(List<CitasDto> listaCitas, List<PacienteDto> listaPacientes);
}

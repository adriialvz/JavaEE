package Modelo.daos;

import java.util.List;

import Modelo.beans.Eventos;

public interface IntEvento {
	
	
	
	Eventos buscarUno(int idEvento);
	List<Eventos> buscarTodos();
	int nuevoEvento(Eventos evento);
	int editarEvento(Eventos evento);
	int cancelarEvento(int IdEventos);
	boolean eliminarEvento(Eventos evento);
	List<Eventos> buscarActivos();

	
	

}

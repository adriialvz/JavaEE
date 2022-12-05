package Modelo.daos;

import java.util.List;

import Modelo.beans.Empleado;

public interface IntEmpleado {

				
	
				//MÉTODOS
				Empleado buscarUno(int idEmpleado);
				List<Empleado> buscarTodos();
				int altaEmpleado(Empleado empleado);
				int eliminarEmpleado(int idEmpleado);
				boolean eliminarEmpleado(Empleado empleado);
				
				
				
}

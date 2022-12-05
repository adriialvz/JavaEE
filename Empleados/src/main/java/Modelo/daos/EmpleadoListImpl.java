package Modelo.daos;

import java.util.ArrayList;
import java.util.List;

import Modelo.beans.Empleado;

public class EmpleadoListImpl implements IntEmpleado {

	
	
			private List<Empleado>  listilla;
			
			public EmpleadoListImpl() {
				listilla= new ArrayList<>();
				cargarDatos();
			}
			

//--------------------------------------------------------------------------------->	
			
			
			private void cargarDatos() {	//METODO PRIVADO
				listilla.add(new Empleado(114,"Rafael",110000));
				listilla.add(new Empleado(115,"Koo",100000));
				listilla.add(new Empleado(116,"Baida",10000));
				listilla.add(new Empleado(117,"Colmenares",11000));
				listilla.add(new Empleado(118,"Himuro",120000));
			}


//--------------------------------------------------------------------------------->	

			//SETTER Y GETTER DE LISTILLA
			public List<Empleado> getListilla() {
				return listilla;
			}


			public void setListilla(List<Empleado> listilla) {
				this.listilla = listilla;
			}			
			
			
//--------------------------------------------------------------------------------->
			
			
			//MÉTODOS
			@Override
			public Empleado buscarUno(int idEmpleado) {
				
				for(Empleado ele: listilla) {
					if(ele.getIdEmpleado() == idEmpleado) {
						return ele;
					}
				}
				return null;
			}



			@Override
			public List<Empleado> buscarTodos() {
				return listilla;
			}


//--------------------------------------------------------------------------------->	

			
			@Override
			public int altaEmpleado(Empleado empleado) {
				if(!listilla.contains(empleado)) {			//SI LA LISTA "NO CONTIENE" AL EMPLEADO 
					listilla.add(empleado);					//LO DA DE ALTA
					return 1;
				} else {
					return 0;
				}
				
			}



			@Override
			public int eliminarEmpleado(int idEmpleado) {
				return 0;
			}



			@Override
			public boolean eliminarEmpleado(Empleado empleado) {
					return listilla.remove(empleado);
			}
			
			
}

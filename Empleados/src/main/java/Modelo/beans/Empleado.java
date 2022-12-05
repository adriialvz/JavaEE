package Modelo.beans;

import java.io.Serializable;
import java.util.Objects;

public class Empleado implements Serializable{
	
	
	
			//PROPIEDADES
			private static final long serialVersionUID = 1L;
			private int idEmpleado;
			private String nombre;
			private double salario;
			
			
//--------------------------------------------------------------------------------->	
			
			
			//CONSTRUCTOR CON PARAMETROS
			public Empleado(int idEmpleado, String nombre, double salario) {
				super();
				this.idEmpleado = idEmpleado;
				this.nombre = nombre;
				this.salario = salario;
			}


			//CONTRUCTOR VACIO
			public Empleado() {
				super();
			}

			
//--------------------------------------------------------------------------------->	
			
			
			//SETTER --> CAMBIAN VALORES O IMPRIMEN DENTRO
			//GETTER --> RETORNAN VALORES O IMPRIMEN FUERA
			public int getIdEmpleado() {
				return idEmpleado;
			}


			public void setIdEmpleado(int idEmpleado) {
				this.idEmpleado = idEmpleado;
			}


			public String getNombre() {
				return nombre;
			}


			public void setNombre(String nombre) {
				this.nombre = nombre;
			}


			public double getSalario() {
				return salario;
			}


			public void setSalario(double salario) {
				this.salario = salario;
			}


//--------------------------------------------------------------------------------->			
			
			
			//HASCODE --> NUMERO
			@Override
			public int hashCode() {
				return Objects.hash(idEmpleado);
			}

			
			//EQUAL --> COMPARA SI SON IGUALES
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (!(obj instanceof Empleado))
					return false;
				Empleado other = (Empleado) obj;
				return idEmpleado == other.idEmpleado;
			}

			
//--------------------------------------------------------------------------------->		
			
			
			//TOSTRING --> IMPRIME DATOS
			@Override
			public String toString() {
				return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", salario=" + salario + "]";
			}
			
	
}

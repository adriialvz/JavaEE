 package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.beans.Empleado;
import Modelo.daos.EmpleadoListImpl;
import Modelo.daos.IntEmpleado;

/**
 * Servlet implementation class GestionEmpleados
 */
@WebServlet("/empleados")
public class GestionEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IntEmpleado edao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEmpleados() {
        super();
        
        edao= new EmpleadoListImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//PETICIONES DE LAS URL
		
		String opcion= request.getParameter("opcion");
		
		switch (opcion) {
		
			case "eliminar": 
				procEliminarEmpleado(request,response);
				break;
		
		
			case "editar": 
				procEditarEmpleado(request,response);
				break;
			
			case "alta": 
				procAltaEmpleado(request,response);
				break;
				
			default:
				System.out.println("Error!!!Valla tortazo se ah pegado");
		}
	}

//--------------------------------------------------------------------------------->	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//UN FORMULARIO PARA DARLO DE ALTA
		
		doGet(request, response);		//ENVIA EL FORMULARIO Y VUELVE
	}

	
	
	
//--------------------------------------------------------------------------------->	
//--------------------------------------------------------------------------------->	
//--------------------------------------------------------------------------------->	
//--------------------------------------------------------------------------------->	
	
	
	
	
	protected void procEliminarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//GUARDAMOS EN LA VARIABLE EL NUMERO "ID"
		Empleado emp1= edao.buscarUno(Integer.parseInt(request.getParameter("id")));
		
		//SI  CONTIENE UN EMPLEADO
		String mensaje= null;
		if(edao.eliminarEmpleado(emp1)) {
			mensaje= "Empleado eliminado";
		} else {
			mensaje= "Empleado no se ha podido eliminar";
		}
		
		//VA CON UN ATRIBUTO Y UN OBJETO AL JSP
		request.setAttribute("men", mensaje);
		request.getSession().setAttribute("listillaEmpleados", ((EmpleadoListImpl)edao).getListilla());
		request.getRequestDispatcher("inicio").forward(request, response);
	}
	
	
	//--------------------------------------------------------------------------------->	
	
	
	protected void procEditarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	//--------------------------------------------------------------------------------->	
	
	
	protected void procAltaEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Empleado empleado= new Empleado();
		empleado.setIdEmpleado(Integer.parseInt(request.getParameter("idEmpleado")));
		empleado.setNombre(request.getParameter("nombre"));
		empleado.setSalario(Double.parseDouble(request.getParameter("salario")));
		
		String mensaje= null;
		if(edao.altaEmpleado(empleado) == 1) {
			mensaje= "Alta realizada";
		} else {
			mensaje= "No se realizo el alta";
		}
		request.setAttribute("men", mensaje);
		request.getRequestDispatcher("inicio").forward(request, response);
	}

}

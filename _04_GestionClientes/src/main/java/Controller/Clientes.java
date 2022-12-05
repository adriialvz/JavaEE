package Controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.beans.Cliente;

/**
 * Servlet implementation class Clientes
 */
@WebServlet("/Clientes")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//TRAE UNA OPCION "UN DATO" DE POR "URL" EN EL HTML DEL NAVEGADOR Y LO GUARDAMOS EN LA VARIABLE OPCION
		String opcion= request.getParameter("opcion");
			
		
		
		//SI ESA OPCION "ESE DATO" COINCIDE CON LA CADENA "ALTA" IMPRIMES LO DE DENTRO EL OBJETO
		switch(opcion) {
		
			case "alta":	
				Cliente c1= new Cliente("Veleros","cruce");
				request.setAttribute("client", c1);
				request.setAttribute("Mensaje", "Estamos haciendo alta");break;
		
			case "editar": 	 	request.setAttribute("Mensaje", "Estamos editando");break;
		
			case "eliminar":	request.setAttribute("Mensaje", "Estamos eliminando");break;		//PONER EN EL NAVEGADOR --> ?opcion=alta
		
			default:			request.setAttribute("Mensaje", "Error en la opcion");break;
		}
		
		
		
		//DONDE LO IMPRIMIMOS EL "MENSAJE" EN EL JSP QUE LE PASAMOS
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}

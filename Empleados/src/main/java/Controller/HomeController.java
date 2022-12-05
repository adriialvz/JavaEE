package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.beans.Empleado;
import Modelo.daos.EmpleadoListImpl;
import Modelo.daos.IntEmpleado;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
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
	
		
			IntEmpleado edao= new EmpleadoListImpl();
		
			
			//ATRIBUTOS DE SESION	//SI LA SESION NO EXISTE EL ATRIBUTO NO EXISTE
			List<Empleado> listilla= null;
			List<Empleado> listillaEmpleados= (List<Empleado>)request.getSession().getAttribute("listillaEmpleados");
				if(listillaEmpleados == null) {
					 listilla= edao.buscarTodos();
				} else {
					((EmpleadoListImpl)edao).setListilla(listillaEmpleados);
					listilla= ((EmpleadoListImpl)edao).getListilla();
				}
			
			//DEVUELVE UNA LISTA
			//List<Empleado> listilla= edao.buscarTodos();
			request.setAttribute("empleados", listilla);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			}

}

package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Modelo.beans.Eventos;
import Modelo.daos.EventoListImpl;
import Modelo.daos.IntEvento;

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
		
		IntEvento eve= new EventoListImpl();
		
		
		//ATRIBUTOS DE SESION	//SI LA SESION NO EXISTE EL ATRIBUTO NO EXISTE
		List<Eventos> lista= null;
		List<Eventos> listaEventos= (List<Eventos>)request.getSession().getAttribute("listaEventos");
			if(listaEventos == null) {
				 lista= eve.buscarTodos();
			} else {
				((EventoListImpl)eve).setLista(listaEventos);
				lista= ((EventoListImpl)eve).getLista();
			}
			
			
		//DEVUELVE UNA LISTA
		request.setAttribute("evento", lista);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

}

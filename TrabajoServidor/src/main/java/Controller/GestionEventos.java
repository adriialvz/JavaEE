package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Modelo.beans.Eventos;
import Modelo.beans.Tipo;
import Modelo.daos.EventoListImpl;
import Modelo.daos.IntEvento;
import Modelo.daos.TipoDaoImpl;
import Modelo.daos.IntTipoDao;

/**
 * Servlet implementation class GestionEventos
 */
@WebServlet("/evento")
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IntEvento edao;
	private IntTipoDao tdao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEventos() {
        super();
        edao= new EventoListImpl();
        tdao = new TipoDaoImpl();
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//PETICIONES DE LAS URL

		String opcion = request.getParameter("opcion");

		switch(opcion){


			case "alta":
				procAlta(request, response);
				break;

			case "editar":
				procEditar(request, response);
				break;

			case "eliminar":
				procEliminar(request, response);
				break;

			case "cancelar":
				procCancelar(request, response);
				break;

			case "activos":
				procActivos(request, response);
				break;



			default:
				System.out.println("opciona incorrecta: " +opcion);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//UN FORMULARIO PARA DARLO DE ALTA

		doGet(request, response);		//ENVIA EL FORMULARIO Y VUELVE

	}
	//MÉTODO QUE CREA UN NUEVO EVENTO Y LO MUESTRA
	protected void procAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Eventos eve= new Eventos();
		eve.setIdEvento(Integer.parseInt(request.getParameter("idEvento")));
		eve.setNombre(request.getParameter("nombre"));
		eve.setPrecio(Double.parseDouble(request.getParameter("precio")));
		eve.setDescripcion(request.getParameter("descripcion"));
		Tipo tipo = tdao.findbyId(Integer.parseInt(request.getParameter("idTipo")));
	    eve.setTipo(tipo);
		String mensaje= null;
		if(edao.nuevoEvento(eve) == 1) {
			mensaje= "Alta realizada";
		} else {
			mensaje= "No se realizo el alta";
		}
		request.setAttribute("men", mensaje);
		request.getSession().setAttribute("listaEventos", ((EventoListImpl)edao).getLista());
		request.getRequestDispatcher("inicio").forward(request, response);
	}

	//MÉTODO QUE NOS MUESTRA LA INFORMACIÓN DE UN EVENTO
	protected void procEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Eventos evento = edao.buscarUno(id);


		request.setAttribute("evento", evento);
		request.getRequestDispatcher("editar.jsp").forward(request, response);
	}

	//MÉTODO QUE ELIMINA UN EVENTO Y LO BORRA DE LA LISTA
	protected void procEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//GUARDAMOS EN LA VARIABLE EL NUMERO "ID"
		Eventos eve= edao.buscarUno(Integer.parseInt(request.getParameter("id")));

		//SI  CONTIENE UN EMPLEADO
		String mensaje= null;
		if(edao.eliminarEvento(eve)) {
			mensaje= "Evento eliminado";
		} else {
			mensaje= "Evento no se ha podido eliminar";
		}

		//VA CON UN ATRIBUTO Y UN OBJETO AL JSP
		request.setAttribute("men", mensaje);
		request.getSession().setAttribute("listaEventos", ((EventoListImpl)edao).getLista());
		request.getRequestDispatcher("inicio").forward(request, response);
	}

	//MÉTODO QUE SETEA EL ESTADO A CANCELADO
	protected void procCancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//GUARDAMOS EN LA VARIABLE EL NUMERO "ID"
		 int eve= Integer.parseInt(request.getParameter("id"));

		//SI  CONTIENE UN EMPLEADO
		String mensaje= null;
		if(edao.cancelarEvento(eve) == 1) {
			mensaje= "Evento cancelado";
		} else {
			mensaje= "Evento no se ha podido cancelar";
		}

		//VA CON UN ATRIBUTO Y UN OBJETO AL JSP
		request.setAttribute("men", mensaje);
		request.getSession().setAttribute("listaEventos", ((EventoListImpl)edao).getLista());
		request.getRequestDispatcher("inicio").forward(request, response);
	}

	//MÉTODO QUE MUESTRA ÚNICAMENTE LOS EVENTOS ACTIVOS
	protected void procActivos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IntEvento eve= new EventoListImpl();
		List<Eventos> activos = new ArrayList<>();
		List<Eventos> listaEventos= (List<Eventos>)request.getSession().getAttribute("listaEventos");

		for (Eventos ele : listaEventos) {
            if(ele.getEstado().equals("activo")) {
                activos.add(ele);
            }
		}

		//DEVUELVE UNA LISTA
		request.setAttribute("evento", activos);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}



}

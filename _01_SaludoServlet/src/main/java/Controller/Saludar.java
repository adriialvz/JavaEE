package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Saludar
 */
@WebServlet("/Saludar")
public class Saludar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Saludar() {
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
		
		
		
		response.setContentType("text/html;charset=UTF-8"); 	//LA RESPUESTA QUE VAMOS A GENERAR
		
		
		PrintWriter out = response.getWriter();
		out.println("Hola me llamo cruceros");					//IMPRIME EN EL HTML ESTE STRING
		
		
		out.println(request.getParameter("opcion"));  		    //----> PONER AL FINAL DE LA URL ---->  ?opcion=Adrian
			
			
	}

}

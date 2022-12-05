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
 * Servlet implementation class Saludo
 */
@WebServlet("/Saludo")
public class SaludoEnAumento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaludoEnAumento() {
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
		
		
		
		
			PrintWriter out= response.getWriter();
			response.setContentType("text/html");
			out.println("<html><body><center>");
			
			
			for(int i=6;i>=1;i--) {
				out.println("<h"+i+">BIENVENIDO AL SERVLET</h"+i+">");
			}
			
			for(int i=1;i<=6;i++) {
				out.println("<h"+i+">BIENVENIDO AL SERVLET</h"+i+">");
			}
			
			
			out.println("</center></body></html>");
	}

}

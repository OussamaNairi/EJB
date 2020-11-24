package tn.essat.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.essat.service.CalculatriceService;

/**
 * Servlet implementation class CalculatriceServlet
 */
@WebServlet("/CalculatriceServlet")
public class CalculatriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB   
    private CalculatriceService calculatriceService ;
    public CalculatriceServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double x=Double.parseDouble(request.getParameter("x"));
		double y=Double.parseDouble(request.getParameter("y"));
		double res=calculatriceService.add(x,y);
		double res1=calculatriceService.mult(x,y);
		double res2=calculatriceService.sub(x,y);
		if(request.getParameter("add")!=null) {
	
		response.getWriter().append("<h1> La somme est "+ res +"</h1>");}
		else if(request.getParameter("mult")!=null) {
		
		response.getWriter().append("<h1> La multiplication est "+ res1 +"</h1>");}
		else if(request.getParameter("sub")!=null) {
	
		response.getWriter().append("<h1> La soustraction est" + res2 +"</h1>");}
		else {}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

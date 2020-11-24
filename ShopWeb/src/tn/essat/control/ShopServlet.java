package tn.essat.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.essat.dto.Productdto;
import tn.essat.service.ShopService;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ShopService shopService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("add")!=null) {
    	String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		float price = Float.parseFloat(request.getParameter("price"));
		Productdto productdto = new Productdto(name, quantity, price);
		shopService.add(productdto);}
		else if(request.getParameter("delete")!=null) {
			
			int index = Integer.parseInt(request.getParameter("index"));	
			shopService.delete(index-1);
			response.getWriter().print(shopService.getTotal());
			return; //ajax
		
		}else if(request.getParameter("load")!=null) {
			
			int index = Integer.parseInt(request.getParameter("index"));	
			Productdto product= shopService.listProducts().get(index-1);
			request.setAttribute("product", product);
			request.setAttribute("index", index);
			request.getRequestDispatcher("editProduct.jsp").forward(request, response);
			return ;
		}else if(request.getParameter("update")!=null) {
			int index = Integer.parseInt(request.getParameter("index"));
			String name = request.getParameter("name");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			float price = Float.parseFloat(request.getParameter("price"));
			Productdto updateProduct = new Productdto(name, quantity, price);
			shopService.update(updateProduct,index-1);
			
		
		}
		request.setAttribute("total", shopService.getTotal());
		request.setAttribute("products", shopService.listProducts());
		request.getRequestDispatcher("products.jsp").forward(request, response);
    }

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

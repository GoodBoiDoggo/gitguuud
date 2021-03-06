package com.ibm.ojt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateQuantityServelet
 */
@WebServlet("/UpdateQuantityServelet")
public class UpdateQuantityServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuantityServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Integer code = Integer.parseInt(request.getParameter("code"));
		Catalog cat = (Catalog)request.getServletContext().getAttribute("catalog");
		Product prod = cat.getProduct(code);
		Customer cust = (Customer) request.getSession().getAttribute("customer");
		cust.getShoppingCart().updateItemQuantity(prod,(int)Integer.parseInt(request.getParameter("quantity")));
		request.getSession().setAttribute("customer", cust);
		response.sendRedirect("/MiniShoppingCart/shoppingcart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

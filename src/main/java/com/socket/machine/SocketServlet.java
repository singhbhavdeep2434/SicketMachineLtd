package com.socket.machine;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SocketServlet
 */
public class SocketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final double PRICE_TYPE_A = 10.0;
    private static final double PRICE_TYPE_B = 12.5;
    private static final double PRICE_TYPE_C = 15.0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto- method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String socketType = request.getParameter("socketType");
        String quantityStr = request.getParameter("quantity");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        double pricePerSocket = 0.0;
        switch (socketType) {
            case "Type A":
                pricePerSocket = PRICE_TYPE_A;
                break;
            case "Type B":
                pricePerSocket = PRICE_TYPE_B;
                break;
            case "Type C":
                pricePerSocket = PRICE_TYPE_C;
                break;
            default:
                response.getWriter().println("<html><body>");
                response.getWriter().println("<h2>Error: Invalid socket type selected</h2>");
                response.getWriter().println("</body></html>");
                return;
        }

        double totalPrice = pricePerSocket * quantity;

        response.getWriter().println("<h2>Order Details</h2>");
        response.getWriter().println("<p>Name: " + name + "</p>");
        response.getWriter().println("<p>Quantity: " + quantity + ".</p>");
        response.getWriter().println("<p>SocketType: " + socketType + ".</p>");
        response.getWriter().println("<p>Price of one Socket: $" + pricePerSocket + "</p>");
        response.getWriter().println("<p>Total price: $" + totalPrice + "</p>");
        response.getWriter().println("<p>Email: " + email + "</p>");
        response.getWriter().println("</body></html>");
    }
}

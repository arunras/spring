package core.jwd.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import core.jwd.data.MenuDao;
import core.jwd.data.MenuDaoFactory;
import core.jwd.domain.Order;


@WebServlet("/thankYou.html")
@ServletSecurity(@HttpConstraint(rolesAllowed= {"user"}))
public class ThankYouServlet extends HttpServlet {

	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		HttpSession session = request.getSession();
    Long orderId = (Long) session.getAttribute("orderId");
    MenuDao dao = MenuDaoFactory.getMenuDao();

		Double total = (Double) dao.getOrderTotal(orderId);
    String status = dao.getOrder(orderId).getStatus();
		
		if (total == null) {
			response.sendRedirect("/order.html");
			return;
		}

    request.setAttribute("total", total);
    request.setAttribute("id", orderId);
    request.setAttribute("status", status);
    request.setAttribute("currency", "USD");

    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/thankYou.jsp");
    dispatch.forward(request, response);
	
	}
}

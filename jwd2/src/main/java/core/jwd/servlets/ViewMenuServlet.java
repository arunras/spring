package core.jwd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.jwd.data.MenuDao;
import core.jwd.data.MenuDaoFactory;
import core.jwd.domain.MenuItem;

@WebServlet("")
public class ViewMenuServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		List<MenuItem> menuItems = menuDao.getFullMenu();
		
		out.println("<html><body><h1>Ricky's Restaurant</h1>");
		out.println("<h2>Menu</h2><ul>");
		for (MenuItem menuItem : menuItems) {
			out.println("<li>" + menuItem + "</li>");
		}
		out.println("</ul>");
		out.println("<a href='searchResults.html?searchTerm=chicken' >View all of our chicken dishes</a>");
		out.println("</body></html>");
		out.close();
	}
	
}
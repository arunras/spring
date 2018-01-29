package core.jwd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.jwd.data.MenuDataService;
import core.jwd.domain.MenuItem;

public class OrderServlet extends HttpServlet {
  public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    response.setContentType("text/html");

    MenuDataService menuDataService = new MenuDataService();
    List<MenuItem> menuItems = menuDataService.getFullMenu();

    out.println("<html><bod><h1>Ricky's Restaurant</h1>");
    out.println("<h2>Order your food</h2>");

    out.println("<form action='orderReceived.html' method='POST' >");
    out.println("<ul>");
    for (MenuItem menuItem : menuItems) {
      out.println("<li>" + menuItem + "<input type='text' name='item_" + menuItem.getId() + "' /> </li>");
    }
    out.println("</ul>");
    out.println("<input type='submit' />");
    
    out.println("</form></body></html>");
    out.close();
  }
}



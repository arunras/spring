<%@ page import = "core.jwd.data.MenuDao" %>
<%@ page import = "core.jwd.data.MenuDaoFactory" %>
<%@ page import = "core.jwd.domain.MenuItem" %>
<%@ page import = "java.util.List" %>

<%
  MenuDao menuDao = MenuDaoFactory.getMenuDao();
  List<MenuItem> menuItems = menuDao.getFullMenu();
%>

<html>
<body>
  <jsp:include page="/header.jsp" />
  <h2>Menu</h2>
  <ul>
  <%
 		for (MenuItem menuItem : menuItems) {
  %>
  <li><%=menuItem%></li>
  <%
		}
  %>

	<a href='searchResults.html?searchTerm=chicken' >View all of our chicken dishes</a>
  <a href='order.html'>Place an order for food</a>
  </ul>
  <jsp:include page="/footer.jsp" />
</body>
</html>

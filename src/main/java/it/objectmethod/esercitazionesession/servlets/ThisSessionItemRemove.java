package it.objectmethod.esercitazionesession.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.esercitazionesession.domain.ToDoObject;


@WebServlet("/ThisSessionItemRemove")
public class ThisSessionItemRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		@SuppressWarnings("unchecked")
		List<ToDoObject> list = (List<ToDoObject>) session.getAttribute("objects");
		list.remove(id);
		for(int i =0;i<list.size();i++) {
			list.get(i).setid(i);
		}
		request.setAttribute("objects", list);
		request.getRequestDispatcher("pages/index.jsp").forward(request, response);
	}

}

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

@WebServlet("/ThisSessionItemsManager")
public class ThisSessionItemsManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String readObject = request.getParameter("ogg");
		if (readObject == null || readObject.isEmpty()) {
			request.setAttribute("errorMessage", "Il campo non può essere vuoto");
		} else {
			ToDoObject object = null;
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			List<ToDoObject> list = (List<ToDoObject>) session.getAttribute("objects");

			if (list == null) {
				request.getRequestDispatcher("ThisSessionListCreator").forward(request, response);
			} else {
				object = new ToDoObject();
				object.setName(readObject);
				object.setIsDone(false);
				object.setid(list.size());
				list.add(object);
				request.setAttribute("objects", list);
			}
		}
		request.getRequestDispatcher("pages/index.jsp").forward(request, response);

	}

}

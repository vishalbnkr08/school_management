package school_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewbyid")
public class ViewByIdServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id") ;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal") ;
		EntityManager em = emf.createEntityManager() ;
		EntityTransaction et = em.getTransaction() ;
		
		Teacher teacher = em.find(Teacher.class, Integer.valueOf(id)) ;
		if(teacher!=null) {
			HttpSession session = req.getSession() ;
			session.setAttribute("viewteacher", teacher);
			RequestDispatcher rd = req.getRequestDispatcher("viewteacher.jsp") ;
			rd.forward(req, resp);
		}
		else {
			PrintWriter out = resp.getWriter() ;
			out.write("There is a no teacher present this id");
			RequestDispatcher rd = req.getRequestDispatcher("viewbyid.html") ;
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}
}

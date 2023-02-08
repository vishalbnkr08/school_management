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

@WebServlet("/removeteacher")
public class RemoveTeacherServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id") ;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal") ;
		EntityManager em = emf.createEntityManager() ;
		EntityTransaction et = em.getTransaction() ;

		Teacher teacher = em.find(Teacher.class, Integer.valueOf(id)) ;
		et.begin();
		em.remove(teacher);
		et.commit();
		
		PrintWriter out = resp.getWriter() ;
		out.write("Removed successfully..");
		RequestDispatcher rd = req.getRequestDispatcher("teacher.html") ;
		rd.include(req, resp);
		resp.setContentType("text/html");
		
	}
}

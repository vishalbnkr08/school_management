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

@WebServlet("/addteacher")
public class TeacherServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name") ;
		String salary = req.getParameter("salary") ;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal") ;
		EntityManager em = emf.createEntityManager() ;
		EntityTransaction et = em.getTransaction() ;
		
		Teacher teacher = new Teacher() ;
		teacher.setName(name);
		teacher.setSalary(Double.valueOf(salary));
		
		et.begin();
		em.persist(teacher);
		et.commit();
		
		PrintWriter out = resp.getWriter() ;
		out.write("successfully add ...");
		RequestDispatcher rd = req.getRequestDispatcher("teacher.html") ;
		rd.include(req, resp);
		resp.setContentType("text/html");
		
		
		
	}
}

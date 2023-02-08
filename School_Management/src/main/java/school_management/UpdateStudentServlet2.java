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

@WebServlet("/updatestudentform")
public class UpdateStudentServlet2  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id") ;
		String name = req.getParameter("name") ;
		String regno = req.getParameter("regno") ;
		String fees = req.getParameter("fees") ;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal") ;
		EntityManager em = emf.createEntityManager() ;
		EntityTransaction et = em.getTransaction() ;
		
		HttpSession session = req.getSession() ;
		
		Student student = new Student() ;
		student.setId(Integer.valueOf(id));
		student.setName(name);
		student.setReg_no(Integer.valueOf(regno));
		student.setFees(Double.valueOf(fees));
		
		et.begin();
		em.merge(student) ;
		et.commit();
		
		PrintWriter out = resp.getWriter() ;
		out.write("Successfully updated !");
		RequestDispatcher rd = req.getRequestDispatcher("student.html") ;
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
}

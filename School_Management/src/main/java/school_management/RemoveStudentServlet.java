package school_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/removestudent")
public class RemoveStudentServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String regno = req.getParameter("regno") ;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal") ;
		EntityManager em = emf.createEntityManager() ;
		EntityTransaction et = em.getTransaction() ;
		
		Query query = em.createQuery("select a from Student a where reg_no = ?1") ;
		query.setParameter(1, Integer.valueOf(regno)) ;
		List<Student> student = query.getResultList() ;
		for (Student student2 : student) {
			et.begin();
			em.remove(student2);
			et.commit();
		}
		
		PrintWriter out = resp.getWriter() ;
		out.write("removed student !");
		RequestDispatcher rd = req.getRequestDispatcher("student.html") ;
		rd.include(req, resp);
		resp.setContentType("text/html");
		
	}
}

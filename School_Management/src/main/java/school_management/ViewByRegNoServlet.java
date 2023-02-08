package school_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewbyregno")
public class ViewByRegNoServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String regno = req.getParameter("regno") ;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal") ;
		EntityManager em = emf.createEntityManager() ;
		
		HttpSession session = req.getSession() ;
		Query query = em.createQuery("select a from Student a where reg_no = ?1") ;
		query.setParameter(1, Integer.valueOf(regno)) ;
		List<Student> student = query.getResultList() ;
		if(student.isEmpty()) {
			PrintWriter out = resp.getWriter() ;
			out.write("Data not available for this Reg No ");
			RequestDispatcher rd = req.getRequestDispatcher("viewbyregno.html") ;
			rd.include(req, resp);
			resp.setContentType("text/html");
		}else {
			session.setAttribute("viewstudbyreg", student);
			
			RequestDispatcher rd = req.getRequestDispatcher("viewstudent.jsp") ;
			rd.forward(req, resp);
		}
		
	}
}

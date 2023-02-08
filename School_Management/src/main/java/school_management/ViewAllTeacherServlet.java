package school_management;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

@WebServlet("/viewallteacher")
public class ViewAllTeacherServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal") ;
		EntityManager em = emf.createEntityManager() ;
		EntityTransaction et = em.getTransaction() ;
		
		Query query = em.createQuery("select a from Teacher a") ;
		List<Teacher> teachers = query.getResultList() ;
		
		HttpSession session = req.getSession() ;
		session.setAttribute("viewallteacher", teachers);
		
		RequestDispatcher rd = req.getRequestDispatcher("viewallteacher.jsp") ;
		rd.forward(req, resp);
	}
}

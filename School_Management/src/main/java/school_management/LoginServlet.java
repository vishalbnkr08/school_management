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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email") ;
		String password = req.getParameter("password") ;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal") ;
		EntityManager em = emf.createEntityManager() ;
		EntityTransaction et = em.getTransaction() ;
		
		Query query = em.createQuery("select a from Principle a where email = ?1 and password = ?2") ;
		query.setParameter(1, email) ;
		query.setParameter(2, password) ;
		List<Principle> principle = query.getResultList() ;
		
		if (principle.size() > 0) {
			PrintWriter out = resp.getWriter() ;
			out.write("welcome !");
			RequestDispatcher rd = req.getRequestDispatcher("welcome.html") ;
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
		else {
			PrintWriter out = resp.getWriter() ;
			out.write("invalid credential !");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html") ;
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}
}

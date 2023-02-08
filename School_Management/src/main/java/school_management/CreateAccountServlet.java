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

@WebServlet("/createaccount")
public class CreateAccountServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name") ;
		String email = req.getParameter("email") ;
		String password = req.getParameter("password") ;
		String age = req.getParameter("age") ;
		String mobile_no = req.getParameter("mobile_no") ;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal") ;
		EntityManager em = emf.createEntityManager() ;
		EntityTransaction et = em.getTransaction() ;
		
//		check the email is already register or not if it is already register 
//		then display msg and redirect to registration page.
		Query query = em.createQuery("select a from Principle a where email = ?1") ;
		query.setParameter(1, email) ;
		List<Principle> principle = query.getResultList() ;
		if (principle.isEmpty()) {
			
//			check the password are already exist or not if it's exist 
//			then display msg and redirect to register page.
			Query query1 = em.createQuery("select a from Principle a where password = ?1") ;
			query1.setParameter(1, password) ;
			
			List<Principle> principle1 = query1.getResultList() ;
			if(principle1.isEmpty()) {
				Principle pr = new Principle() ;
				pr.setName(name);
				pr.setAge(Integer.valueOf(age));
				pr.setMobile_no(Long.valueOf(mobile_no));
				pr.setEmail(email);
				pr.setPassword(password);
				
				et.begin();
				em.persist(pr);
				et.commit();
				
				PrintWriter out = resp.getWriter() ;
				out.write("Successfully Register !");
				RequestDispatcher rd = req.getRequestDispatcher("Login.html") ;
				rd.include(req, resp);
				resp.setContentType("text/html");
			}else {
				PrintWriter out = resp.getWriter() ;
				out.write("This password is already exist, please change password.");
				RequestDispatcher rd = req.getRequestDispatcher("account.html") ;
				rd.include(req, resp);
				resp.setContentType("text/html");
			}
			
		}else {
			PrintWriter out = resp.getWriter() ;
			out.write("This email is already register !");
			RequestDispatcher rd = req.getRequestDispatcher("account.html") ;
			rd.include(req, resp);
			resp.setContentType("text/html");
			
		}
		
		
		
		
	}
}

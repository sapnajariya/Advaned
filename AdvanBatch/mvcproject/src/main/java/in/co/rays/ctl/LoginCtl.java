package in.co.rays.ctl;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

/**
 * Servlet implementation class LoginCtl
 */

public class LoginCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		Logger logger = LogManager.getLogger(LoginCtl.class);
		  // basic log4j configurator  
		  BasicConfigurator.configure();  
		  logger.debug("debugging start"); 

		String email=request.getParameter("login");
		String pass=request.getParameter("password");
		UserBean bean= new UserBean();
		PrintWriter out=response.getWriter();
		UserModel um=new UserModel();
		HttpSession session=request.getSession();
		bean.setEmail(email);
		bean.setPassword(pass);
		try {
			bean = um.authenticate(bean.getEmail(), bean.getPassword());
			if (bean != null) {
				RequestDispatcher re=request.getRequestDispatcher("Welcome.jsp");
				session.setAttribute("user", bean.getFname());
				re.forward(request, response);
				}
				else {
					RequestDispatcher re=request.getRequestDispatcher("Login.jsp");
					request.setAttribute("err", "invalid login id and password");
					re.forward(request, response);
				
				}
				
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

			

			
		 
	}	

}

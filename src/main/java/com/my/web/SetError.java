package com.my.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;  
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetError
 */
@WebServlet(  
	    name="SetError",   
	    urlPatterns={"/SetError"},  
	    initParams = { @WebInitParam(name= "Site :", value="http://roseindia.net"),  
	    			    @WebInitParam(name= "Rose", value= "India"),  
	    			  },
	    loadOnStartup=1 
	)  
public class SetError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetError() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// get cookies
		
		Cookie[] cookies = request.getCookies();
		/*
		for (Cookie cookie : cookies) {
			if(cookie.getName().compareTo("user")==0){
			System.out.println(cookie.getName()+ ":"+cookie.getValue());
			}else {
				System.out.println("=====" + cookie.getName()+ ":"+cookie.getValue());
			}
			
		}				*/
		HttpSession session = request.getSession();
		System.out.println(session.isNew());
		response.getWriter().println(session.getAttribute("userName"));
		response.getWriter().println(session.getAttribute("password"));
		//request.getRequestDispatcher("/GetForward").forward(request, response);
		//this.getServletContext().getRequestDispatcher("/GetForward").forward(request, response);
		System.out.println("servletParam:"+this.getInitParameter("Rose"));
		System.out.println("servletParam:"+this.getServletConfig().getInitParameter("Site :"));
		
		response.getWriter().append("max"+this.getServletContext().getInitParameter("max"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.my.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Show
 */
@WebServlet("/CallWeb")
public class CallWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stuts		
		//set cookies
		Cookie cookie = new Cookie("user", "4397881111s");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("班级："+request.getParameter("stuClass")+"<br/>");
		pw.println("用户名："+request.getParameter("stuName")+"<br/>");
		pw.println("密码："+request.getParameter("stuPassword")+"<br/>");
		pw.println("性别："+request.getParameter("sex")+"<br/>");
		String[] arr = request.getParameterValues("love");
		for (String string : arr) {
			pw.println("兴趣："+string+"<br/>");
		}
		pw.println("地址："+request.getParameter("address")+"<br/>");	
		
		HttpSession session = request.getSession();
		System.out.println(session.isNew());
		System.out.println(new Date(session.getCreationTime()));
		session.setAttribute("userName", "abc123");
		session.setAttribute("password", "456");
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

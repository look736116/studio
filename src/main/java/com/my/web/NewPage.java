package com.my.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewPage
 */
@WebServlet("/NewPage")
public class NewPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // 设置响应内容类型
	      response.setContentType("text/html");

	      // 要重定向的新位置
	     // String site = new String("http://www.w3cschool.cn");
	     // response.setStatus(response.SC_MOVED_TEMPORARILY);
	     // response.setHeader("Location", site); 
	      //response.sendRedirect("http://localhost:8080/myWeb/showName.jsp");
	      //自动刷新页面
	      response.setIntHeader("Refresh", 5);
	     response.getWriter().append(String.valueOf(System.currentTimeMillis()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

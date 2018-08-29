package com.studio.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studio.entity.RoleInfo;
import com.studio.server.RoleInfoServer;
import com.studio.server.impl.RoleInfoServerImpl;
import com.studio.util.Utils;

/**
 * Servlet implementation class FindMapController
 */
@WebServlet("/FindMapController")
public class FindMapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<RoleInfo> roles = null;
		
		RoleInfoServer ris= new RoleInfoServerImpl();
		roles = ris.getAllRoleInfo();
		request.setAttribute("roles", roles);		
		
		request.setAttribute("dateStr", Utils.getCurrentDay());
		
		request.getRequestDispatcher("/findMap.jsp").forward(request, response);
		//this.getServletContext().getRequestDispatcher("/url").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

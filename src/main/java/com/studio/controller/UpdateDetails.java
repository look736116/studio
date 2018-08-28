package com.studio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studio.entity.RoleInfo;
import com.studio.server.RoleInfoServer;
import com.studio.server.impl.RoleInfoServerImpl;
import com.studio.util.DataBaseUtils;

/**
 * Servlet implementation class UpdateDetails
 */
@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String serverName = request.getParameter("serverName");

		List<RoleInfo> roles = null;

		RoleInfoServer ris = new RoleInfoServerImpl();
		if (serverName.equals("全部区服")) {
			roles = ris.getAllRoleInfo();
		} else {
			roles = ris.getRolesByServer(serverName);
		}

		request.setAttribute("roles", roles);
		request.setAttribute("dateStr", DataBaseUtils.getCurrentDay());
		request.setAttribute("serverName", serverName);

		request.getRequestDispatcher("/findMap.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

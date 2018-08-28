package com.studio.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studio.dao.RoleInfoDao;
import com.studio.dao.impl.RoleInfoDaoImpl;
import com.studio.entity.RoleInfo;
import com.studio.server.RoleInfoServer;
import com.studio.server.impl.RoleInfoServerImpl;

/**
 * Servlet implementation class AddRole
 */
@WebServlet("/AddRoleDetails")
public class AddRoleDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRoleDetails() {
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

		RoleInfo role = new RoleInfo();
		RoleInfoServer ris = new RoleInfoServerImpl();

		List<RoleInfo> roles = ris.getAllRoleInfo();
		String roleServer = request.getParameter("server");
		String roleName = request.getParameter("roleName");
		Boolean roleExist = false;
		for (RoleInfo roleInfo : roles) {
			if (roleInfo.getRole_server().equals(roleServer) && roleInfo.getRole_name().equals(roleName)) {
				request.setAttribute("message", "添加失败，角色已存在！");				
				roleExist = true;
				break;
			}

		}
		if (!roleExist) {
			role.setRole_server(roleServer);
			role.setRole_account(request.getParameter("accout")+"@changyou.com");
			if (roleName != null && roleName != "") {
				role.setRole_name(request.getParameter("roleName"));
			}
			role.setRole_sect(request.getParameter("sect"));
			String gradeStr = request.getParameter("grade");
			role.setRole_grade(Integer.parseInt(gradeStr));
			String roleId = UUID.randomUUID().toString().replaceAll("-", "");
			role.setRole_id(roleId);
			role.setRole_order(Integer.parseInt(request.getParameter("order")));
			ris.addNewRole(role);
			request.setAttribute("message", "添加成功！");
		}
		request.getRequestDispatcher("/WEB-INF/page/addRole.jsp").forward(request, response);

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

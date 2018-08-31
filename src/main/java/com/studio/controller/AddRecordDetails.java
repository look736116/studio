package com.studio.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studio.dao.RoleInfoDao;
import com.studio.dao.impl.RoleInfoDaoImpl;
import com.studio.entity.RecordInfo;
import com.studio.entity.RoleInfo;
import com.studio.server.RoleInfoServer;
import com.studio.server.impl.RoleInfoServerImpl;
import com.studio.util.Utils;

/**
 * Servlet implementation class AddRecordDetails
 */
@WebServlet("/AddRecordDetails")
public class AddRecordDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRecordDetails() {
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
		
		RecordInfo recordInfo = new RecordInfo();
		RoleInfoServer ris= new RoleInfoServerImpl();
		String dateStr = Utils.getCurrentTime();		
	
		
		String recordId = UUID.randomUUID().toString().replaceAll("-", "");
		recordInfo.setRecordId(recordId);
		
		String roleId  = request.getParameter("roleId");	
		recordInfo.setRoleId(roleId);
		
		String taskNum  = request.getParameter("taskNum");
		recordInfo.setRecordNum(taskNum);
		recordInfo.setRecordTime(dateStr);
		ris.addNewRecord(recordInfo);
		
		String roleServer = request.getParameter("roleServer");
		if(!roleServer.equals("全部区服")){
			roles = ris.getRolesByServer(roleServer);
		}
		
		request.setAttribute("roles", roles);
		request.setAttribute("dateStr", dateStr.substring(0, 11));
		request.setAttribute("serverName", roleServer);
		request.getRequestDispatcher("findMap.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

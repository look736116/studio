package com.studio.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studio.entity.WeightInfo;
import com.studio.server.WeightInfoServer;
import com.studio.server.impl.WeightInfoServerImpl;
import com.studio.util.Utils;

/**
 * Servlet implementation class AddWeightDetails
 */
@WebServlet("/AddWeightDetails")
public class AddWeightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWeightDetails() {
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
		
		WeightInfo weightInfo= new WeightInfo();
		WeightInfoServer wis = new WeightInfoServerImpl();
		
		weightInfo.setInfoId(UUID.randomUUID().toString().replace("-", ""));
		weightInfo.setInfoHost(request.getParameter("infoHost"));
		weightInfo.setInfoTime(Utils.getCurrentTime());
		weightInfo.setInfoDetails(request.getParameter("infoDetails"));
		weightInfo.setInfoNum(Double.parseDouble(request.getParameter("infoNum")));
		weightInfo.setInfoComment(request.getParameter("infoComment"));		
		request.getRequestDispatcher("/WEB-INF/page/weightMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

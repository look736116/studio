package com.studio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studio.entity.TradeInfo;
import com.studio.server.TradeInfoServer;
import com.studio.server.impl.TradeInfoServerImpl;
import com.studio.util.DataBaseUtils;

/**
 * Servlet implementation class GetTradeByServer
 */
@WebServlet("/GetTradeByServer")
public class GetTradeByServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTradeByServer() {
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
		String serverName = request.getParameter("serverName");

		List<TradeInfo> trades = null;
		
		TradeInfoServer tis = new TradeInfoServerImpl();
		if (serverName.equals("全部区服")) {
			trades=tis.getAllTradeInfo();
		} else {
			trades = tis.getTradeInfoByServer(serverName);

		}
		
		request.setAttribute("trades", trades);
		request.setAttribute("serverName", serverName);
		
		request.getRequestDispatcher("/WEB-INF/page/tradeMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

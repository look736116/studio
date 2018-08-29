package com.studio.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studio.entity.TradeInfo;
import com.studio.server.TradeInfoServer;
import com.studio.server.impl.TradeInfoServerImpl;
import com.studio.util.Utils;

/**
 * Servlet implementation class AddTradeDetails
 */
@WebServlet("/AddTradeDetails")
public class AddTradeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTradeDetails() {
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

		TradeInfo tradeInfo = new TradeInfo();
		TradeInfoServer tis = new TradeInfoServerImpl();

		tradeInfo.setTradeId(UUID.randomUUID().toString().replace("-", ""));
		tradeInfo.setTradeServer(request.getParameter("server"));
		tradeInfo.setTradeCurrency(Integer.parseInt(request.getParameter("tradeCurrency")));
		tradeInfo.setTradeMoney(Integer.parseInt(request.getParameter("tradeMoney")));
		tradeInfo.setTradeTime(Utils.getCurrentTime());
		tradeInfo.setTradeComment("");
		tis.addTradeInfo(tradeInfo);
		request.getRequestDispatcher("/WEB-INF/page/tradeMain.jsp").forward(request, response);
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

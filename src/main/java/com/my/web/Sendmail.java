package com.my.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Sendmail
 */
@WebServlet("/Sendmail")
public class Sendmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sendmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 收件人的电子邮件 ID
	      String to = "xxx@qq.com";
	 
	      // 发件人的电子邮件 ID
	      String from = "xxx@qq.com";
	 
	      // 假设您是从本地主机发送电子邮件
	      String host = "localhost";
	      
	   // 获取系统的属性
	      Properties properties = System.getProperties();
	      
	   // 设置邮件服务器 smtp.qq.com
	     // properties.setProperty("mail.smtp.host", host);
	      properties.setProperty("smtp.qq.com", host);
	      
	   // 获取默认的 Session 对象
	      Session session = Session.getDefaultInstance(properties);
	      
	      // 设置响应内容类型
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      try{
	          // 创建一个默认的 MimeMessage 对象
	          MimeMessage message = new MimeMessage(session);
	          // 设置 From: header field of the header.
	          message.setFrom(new InternetAddress(from));
	          // 设置 To: header field of the header.
	          message.addRecipient(Message.RecipientType.TO,
	                                   new InternetAddress(to));
	          // 设置 Subject: header field
	          message.setSubject("This is the Subject Line!");
	          // 现在设置实际消息
	          message.setText("This is actual message");
	          // 发送消息
	          Transport.send(message);
	          String title = "发送电子邮件";
	          String res = "成功发送消息...";
	          String docType =
	          "<!doctype html public \"-//w3c//dtd html 4.0 " +          "transitional//en\">\n";
	          out.println(docType +
	          "<html>\n" +
	          "<head><title>" + title + "</title></head>\n" +
	          "<body bgcolor=\"#f0f0f0\">\n" +
	          "<h1 align=\"center\">" + title + "</h1>\n" +
	          "<p align=\"center\">" + res + "</p>\n" +
	          "</body></html>");
	       }catch (MessagingException mex) {
	          mex.printStackTrace();
	       }
	 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

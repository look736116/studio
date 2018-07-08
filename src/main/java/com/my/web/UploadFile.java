package com.my.web;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet(name = "UploadFile", urlPatterns = { "/UploadFile" }, initParams = {
		@WebInitParam(name = "filepath", value = "D:/Tools/sandbox/data/") })
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int maxFileSize = 50 * 1024;
	private int maxMemSize = 4 * 1024;
	private boolean isMultipart;
	private String filePath;
	private File file;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		filePath = config.getInitParameter("filepath").toString();
		System.out.println(filePath);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 用于判断是普通表单，还是带文件上传的表单
		isMultipart = ServletFileUpload.isMultipartContent(request);

		response.setContentType("text/html; charset=UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("D:\\Tools\\sandbox\\temp"));

	    // 创建一个新的文件上传处理程序
		ServletFileUpload upload = new ServletFileUpload(factory);
		 upload.setHeaderEncoding("UTF-8");
		//允许上传的文件大小的最大值
		upload.setSizeMax(maxFileSize);
		
		try {
			 // 解析请求，获取文件项
			List<FileItem> fileItems = upload.parseRequest(request);
			// 处理上传的文件项
		    Iterator i = fileItems.iterator();
		    while ( i.hasNext () ) 
		      {
		         FileItem fi = (FileItem)i.next();
		         if ( !fi.isFormField () )   
		         {
		            // 获取上传文件的参数
		            String fieldName = fi.getFieldName();
		            String fileName = fi.getName();
		            String contentType = fi.getContentType();
		            boolean isInMemory = fi.isInMemory();
		            long sizeInBytes = fi.getSize();
		            // 写入文件
		            if( fileName.lastIndexOf("\\") >= 0 ){
		               file = new File( filePath + 
		               fileName.substring( fileName.lastIndexOf("\\"))) ;
		            }else{
		               file = new File( filePath + 
		               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		            }
		            fi.write( file ) ;
		         }
		      }
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(String.valueOf(isMultipart));
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

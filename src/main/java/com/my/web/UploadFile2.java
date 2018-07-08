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
@WebServlet(name = "UploadFile2", urlPatterns = { "/UploadFile2" }, initParams = {
		@WebInitParam(name = "filepath", value = "D:/Tools/sandbox/data/") })
public class UploadFile2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int maxFileSize = 50 * 1024;
	private int maxMemSize = 4 * 1024;
	private boolean isMultipart;
	private String filePath;
	private File file;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFile2() {
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
			for (FileItem item : fileItems) {
				 if(item.isFormField()){
	                    String name = item.getFieldName();
	                    //解决普通输入项的数据的中文乱码问题
	                    String value = item.getString("UTF-8");
	                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
	                    System.out.println(name + "=" + value);
	                }else{//如果fileitem中封装的是上传文件
	                    //得到上传的文件名称，
	                	String filename = item.getName();
	                    System.out.println(filename);
	                    if(filename==null || filename.trim().equals("")){
	                        continue;
	                    }
	                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
	                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
	                    filename = filename.substring(filename.lastIndexOf("\\")+1);
	                    //得到上传文件的扩展名
	                    String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
	                    filename = filename.substring(0,filename.lastIndexOf("."));
	                    //如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
	                    System.out.println("上传的文件的扩展名是："+fileExtName);
	                    //保存文件
	                    file = new File( filePath + filename +"." + fileExtName);
	                    item.write(file);
	                }
			}
		   
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/uploadFile.jsp").forward(request, response);
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

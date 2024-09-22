package com.my.dzzw.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownLoadServlet
 */
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* try
		  {
		   String downFilename=request.getParameter("curfile");
		   String filepath="D:/my"+request.getParameter("path");
		   response.setContentType("application/octet-stream");
		         response.setHeader("Location",downFilename);
		         response.setHeader("Content-Disposition", "attachment; filename=" + downFilename);
		         OutputStream outputStream = response.getOutputStream();
		         InputStream inputStream = new FileInputStream(filepath);
		         byte[] buffer = new byte[1024];
		         int i = -1;
		         while ((i = inputStream.read(buffer)) != -1) {
		          outputStream.write(buffer, 0, i);
		         }
		         outputStream.flush();
		         outputStream.close();
		  }catch(FileNotFoundException e1)
		  {
		   System.out.println("没有找到您要的文件");
		  }
		  catch(Exception e)
		  {
		   System.out.println("系统错误，请及时与管理员联系");
		  }
		 */
		 String filePath = "D:/my"+request.getParameter("path"); 
         String downloadFilename =request.getParameter("curfile"); 
         downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");  
         File file = new File(filePath); 
//         // 对默认下载的文件名编码。不编码的结果就是，在客户端下载时文件名乱码  
//         File file = new File(filePath);  
//         if (file.exists()) {  
//             // 写明要下载的文件的大小  
//             response.setContentLength((int) file.length());  
//             response.setHeader("Content-Disposition", "attachment;filename="  
//                     + downloadFilename);// 设置在下载框默认显示的文件名  
//             response.setContentType("application/x-download");  
//             // 读出文件到response  
//             // 这里是先需要把要把文件内容先读到缓冲区  
//             // 再把缓冲区的内容写到response的输出流供用户下载  
//             FileInputStream fileInputStream = new FileInputStream(file);  
//             BufferedInputStream bufferedInputStream = new BufferedInputStream(  
//                     fileInputStream);  
//             byte[] b = new byte[bufferedInputStream.available()];  
//             bufferedInputStream.read(b);  
//             OutputStream outputStream = response.getOutputStream();  
//             outputStream.write(b);  
//             // 人走带门  
//             bufferedInputStream.close();  
//             outputStream.flush();  
//             outputStream.close();  
             
             
             OutputStream out = response.getOutputStream();  
             FileInputStream fileInputStream = new FileInputStream(file);  
             BufferedInputStream bis = new BufferedInputStream(fileInputStream);  
             BufferedOutputStream  bos= new BufferedOutputStream(out);  
               
             int length =fileInputStream.available() ;  
             // Set Response  
             response.setContentType("application/msword");  
             response.setHeader("Content-Length", String.valueOf(length));  
             response.setHeader("Content-Disposition", "attachment;filename=\"" + downloadFilename + "\"");  
               
             byte[] buffer = new byte[1024];  
             int bytesRead = -1;  
             while ( (bytesRead = bis.read(buffer)) != -1){  
                 bos.write(buffer, 0, bytesRead);  
             }  
               
             bos.flush();  
               
             bis.close();  
             bos.close();  
             fileInputStream.close();  
             out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

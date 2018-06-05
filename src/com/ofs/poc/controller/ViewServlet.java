package com.ofs.poc.controller;
import com.ofs.poc.modal.*;
import com.ofs.poc.dao.*;
import com.ofs.poc.service.*;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

public class ViewServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
    
    	  response.setContentType("text/html");  
          PrintWriter out=response.getWriter();  
         
         // out.println("<h1>Employees List</h1>");  
            
          List<Employee> list=MySqlCon.getAllEmployees();  
            
          out.print("<table>");  
          out.print("<tr><th>Name</th><th>id</th><th>age</th><th>color</th></tr>");  
          for(Employee e:list){  
           out.print("<tr><td>"+e.getName()+"</td><td>"+e.getId()+"</td><td>"+e.getAge()+"</td><td>"+e.getColor()+"</td></tr>");  
          }  
          out.print("</table>");  
            
          out.close();  
    	
    	
    }  
}  
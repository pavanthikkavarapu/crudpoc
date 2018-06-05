package com.ofs.poc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ofs.poc.modal.Employee;
import com.ofs.poc.service.ConnectionService;

public class MySqlCon {

	  public static List<Employee> getAllEmployees(){  
	        List<Employee> list=new ArrayList<Employee>();  
	          
	        try{  
	            Connection con=ConnectionService.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from employee");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	Employee e=new Employee();  
	            
	                e.setName(rs.getString(1));  
	                e.setId(rs.getInt(2));  
	                e.setAge(rs.getInt(3));  
	                e.setColor(rs.getString(4));  
	                System.out.println(rs.getString(1));
	               list.add(e);
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}
			return list;  
	
	
}
}
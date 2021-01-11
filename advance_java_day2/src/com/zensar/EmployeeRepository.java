package com.zensar;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.zensar.bean.Employee;

public class EmployeeRepository {

	
	public void addEmployee(Employee employee)
	{
		Connection conn=DBUtil.mySQLdbConnection();
		
		String sql="insert into employee values(?,?,?,?,?)";
		
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1,employee.getEmployeeId());
			pst.setString(2,employee.getEmployeeName());
			pst.setString(3,employee.getDesignation());
			pst.setInt(4,employee.getSalary());
			pst.setString(5,employee.getGender());
			
			int result=pst.executeUpdate();
			if(result==0)
			{
				System.out.println("Insertion Failed..");
			}
			else
			{
				System.out.println("Successfully Inserted..");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Employee> getAllEmployees(){
		
		List<Employee> listOfAllEmployees = new ArrayList<Employee>();
		
		// jdbc code to fetch all employees from db and add them to this list
		
		Connection conn=DBUtil.mySQLdbConnection();
		String sql="select * from employee";
		
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				int employeeId=rs.getInt("employee_id");
				String employeeName=rs.getString("employee_name");
				String designation=rs.getString("designation");
				int salary=rs.getInt("salary");
				String gender=rs.getString("gender");
				
				Employee employee=new Employee(employeeId, employeeName, designation, salary, gender);
				listOfAllEmployees.add(employee);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listOfAllEmployees;
		}
}

package com.zensar;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.zensar.bean.Employee;

public class EmployeeController extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("I'm inside doGet()..");
		EmployeeRepository employeeRepository = new EmployeeRepository();
		List<Employee> listOfAllEmployees=employeeRepository.getAllEmployees();
		System.out.println(listOfAllEmployees);
		
		RequestDispatcher rd=request.getRequestDispatcher("viewAllEmployees.jsp");
		
		request.setAttribute("listOfAllEmployees",listOfAllEmployees);
		
		rd.forward(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		int employeeId=Integer.parseInt(request.getParameter("employeeId"));
		String employeeName=request.getParameter("employeeName");
		String designation=request.getParameter("designation");
		int salary=Integer.parseInt(request.getParameter("salary"));
		String gender=request.getParameter("gender");
		
		System.out.println("Employee Id = "+employeeId);
		System.out.println("Employee Name = "+employeeName);
		System.out.println("Employee Designation = "+designation);
		System.out.println("Employee Salary = "+salary);
		System.out.println("Employee Gender ="+gender);

		EmployeeRepository empRepository=new EmployeeRepository();
		Employee employee=new Employee(employeeId, employeeName, designation, salary,gender);
		empRepository.addEmployee(employee);
		
		RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

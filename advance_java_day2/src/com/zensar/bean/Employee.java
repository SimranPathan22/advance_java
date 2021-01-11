package com.zensar.bean;

public class Employee {
	
	private int EmployeeId;
	private String EmployeeName;
	private String designation;
	private int salary;
	private String gender;
	
	public Employee()
	{
		
	}
	public Employee(int employeeId, String employeeName, String designation, int salary, String gender) {
		super();
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		this.designation = designation;
		this.salary = salary;
		this.gender = gender;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", designation=" + designation
				+ ", salary=" + salary + ", gender=" + gender + "]";
	}
	
	

}

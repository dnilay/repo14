package org.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.example.demo.model.Employee;

public class App {
	private static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		
		App app=new App();
		int choice=0;
		do {
			System.out.println("1. create employee.");
			System.out.println("2.display all employees");
			System.out.println("0. Exit");
			System.out.print("Enter Your Choice: ");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("first name: ");
				String firstName=scanner.next();
				System.out.print("last name: ");
				String lastName=scanner.next();
				System.out.print("email: ");
				String email=scanner.next();
				Employee employee=new Employee();
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setEmail(email);
				Employee tempEmployee= app.createEmployee(employee);
				System.out.println(tempEmployee);
				break;
				
			case 2:
				List<Employee> employees=app.displayEmployees();
				Iterator<Employee> i=employees.iterator();
				while(i.hasNext())
				{
					System.out.println(i.next());
				}

				break;
				
			case 0: 
				System.out.println("bye!...");
				System.exit(0);
			default:
				break;
			}
			
		} while (choice!=0);
		
		

	}
	
	private List<Employee> displayEmployees()throws SQLException
	{
		List<Employee> list=new ArrayList<Employee>();
		Statement statement=getRemoteConnection().createStatement();
		ResultSet resultSet=statement.executeQuery("select first_name,last_name,email from employees");
		while(resultSet.next())
		{
			Employee employee=new Employee();
			employee.setFirstName(resultSet.getString("first_name"));
			employee.setLastName(resultSet.getString("last_name"));
			employee.setEmail(resultSet.getString("email"));
			list.add(employee);
		}
		return list;
	}

	private  Employee createEmployee(Employee employee) throws SQLException {
		PreparedStatement preparedStatement = getRemoteConnection()
				.prepareStatement("insert into employees(first_name,last_name,email) values(?,?,?)");
		preparedStatement.setString(1, employee.getFirstName());
		preparedStatement.setString(2, employee.getLastName());
		preparedStatement.setString(3, employee.getEmail());
		preparedStatement.executeUpdate();
		return employee;
	}

	private Connection getRemoteConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://database-1.cplwdutrpnxg.ap-southeast-1.rds.amazonaws.com:3306/hr", "admin",
				"password1234");

		return connection;
	}

}

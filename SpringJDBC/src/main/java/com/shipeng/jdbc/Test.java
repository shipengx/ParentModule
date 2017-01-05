package com.shipeng.jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shipeng.dto.Student;

public class Test {
	private DataSource dataSource;
	
	// DI setters
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	// get students
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from student");
			
			while (rs.next()) {
				students.add(new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return students;
	}
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Test test = (Test)context.getBean("test");
		
		List<Student> students = test.getStudents();
		for (Student st: students) {
			System.out.println(st);
		}
	}// end main
	
}



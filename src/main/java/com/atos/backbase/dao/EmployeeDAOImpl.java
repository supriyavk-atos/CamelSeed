package com.atos.backbase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.atos.backbase.model.PersonData;

public class EmployeeDAOImpl {
	

	
	private static final Logger log = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	private static Connection getDBConnection() {
		Properties props = new Properties();
		String  propertyFileLocation = "C:\\Projects\\WorkSpace\\backBasearchetypeProject\\webapps\\portalserver\\src\\main\\resources\\conf\\dbConfig.properties";
		FileInputStream fis = null;
		Connection con = null;
		try {
			fis = new FileInputStream(propertyFileLocation);
			props.load(fis);

			// load the Driver Class
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));

			// create the connection now
			con = DriverManager.getConnection(props.getProperty("DB_URL"),
					props.getProperty("DB_USERNAME"),
					props.getProperty("DB_PASSWORD"));
			
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static List<PersonData> getAllEmployeeDetails() {
		Connection conn = null;
		Statement stmt = null;
		List<PersonData> personDataList = new ArrayList<PersonData>();
		try {
			conn = getDBConnection();
			// STEP 4: Execute a query
			log.error("Creating statement...");
			stmt = conn.createStatement();
			String sql = "SELECT emp_id, first_name, user_name, email, phone_number FROM Employee";
			ResultSet rs = stmt.executeQuery(sql);
			log.error("after getting the result set from the database...");
			// STEP 5: Extract data from result set
			while (rs.next()) {
				PersonData personData = new PersonData();
				// Retrieve by column name
				int id = rs.getInt("emp_id");
				
				personData.setEmpId(id);
				personData.setFirstName(rs.getString("first_name"));
				personData.setUserName(rs.getString("user_name"));
				personData.setEmail(rs.getString("email"));
				personData.setPhoneNumber(rs.getString("phone_number"));
				
				log.error("after setting the data in the personData Result Set...");
				
				personDataList.add(personData);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			log.error("SQLException is occured...");
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		log.error("Everything is Done, Now returning the List!");
		return personDataList;
	}
	
}

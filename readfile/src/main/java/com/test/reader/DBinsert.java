package com.test.reader;

public class DBinsert {
	
	String sql = "insert into employee (name, city, phone) values (?, ?, ?)";
	Connection connection = new getConnection();
	PreparedStatement ps = connection.prepareStatement(sql);

	final int batchSize = 1000;
	int count = 0;

	for (Employee employee: employees) {

		ps.setString(1, employee.getName());
		ps.setString(2, employee.getCity());
		ps.setString(3, employee.getPhone());
		ps.addBatch();
		
		if(++count % batchSize == 0) {
			ps.executeBatch();
		}
	}
	ps.executeBatch(); import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// insert remaining records
	ps.close();
	connection.close();

	
	import java.util.List;

import pojo.Table1;
import pojo.Table2;

	public interface Table2DAO {
		public void insert(Table2 person);
	}

	
	Connection connection = null;
	public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost/hmkcode?user=root&password=");
 
        } catch (ClassNotFoundException e) {
 
            e.printStackTrace();
             
        } catch (SQLException e) {
             
            e.printStackTrace();
             
        }
        return connection;
    }
	

}

package dao;

import java.io.*;
import java.sql.*;
import java.util.*;

public class OracleConnection {
	public Connection getConnection() throws ClassNotFoundException,
	IOException, SQLException {
	final Properties prop = new Properties();
	final InputStream inputStream = OracleConnection.class.getClassLoader()
			.getResourceAsStream(
					"./Resources/db.properties");
	
	prop.load(inputStream);
	
//	System.out.println("url: "+prop.getProperty("url"));
//	System.out.println("user: "+prop.getProperty("user"));
	
	Class.forName(prop.getProperty("driver"));
	final Connection connection = DriverManager.getConnection(prop.getProperty("url"), 
			prop.getProperty("user"), prop.getProperty("password"));
	return connection;
	}
	
}

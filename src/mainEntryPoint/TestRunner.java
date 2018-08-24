package mainEntryPoint;

import java.io.IOException;
import java.sql.SQLException;

import dao.OracleConnection;
import dao.StudentDAO;
import models.Student;

public class TestRunner extends OracleConnection {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		OracleConnection oc = new  OracleConnection();
		 oc.getConnection();
		

		
	}

}

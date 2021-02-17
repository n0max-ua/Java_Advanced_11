package ua.lviv.lgs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	private static String USER_NAME = "admin";
	private static String USER_PASSWORD = "admin";
	private static String URL = "jdbc:mysql://localhost/magazin";

	public static Connection openConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

		return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
	}

}

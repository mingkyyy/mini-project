package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

	public static  Connection getConnection() {
		
		try {
			String dbURL = "jdbc:mysql://localhost:3306/ming?useUnicode=true&characterEncoding=utf8";
			String dbId = "root";
			String dbPw = "kmk62616261";
			Class.forName("org.mariadb.jdbc.Driver");
			return DriverManager.getConnection(dbURL,dbId,dbPw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
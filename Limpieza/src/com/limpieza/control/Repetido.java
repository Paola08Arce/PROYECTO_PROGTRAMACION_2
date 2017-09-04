package com.limpieza.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Repetido {

	private static Connection conn;

	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";

	private static final String DB_URL = "jdbc:mariadb://127.0.0.1/limpieza";

	public Repetido() {

		String USER = "root";
		String PASS = "";
		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Conectando a la base de datos...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static boolean verificar(String ins) throws SQLException {
		boolean algo = false;
		conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1/limpieza", "root", "");
		Statement s = conn.createStatement();
		s.executeUpdate(ins);
		ResultSet rs = s.executeQuery(ins);
		algo = rs.next();
		conn.close();
		return algo;
	}
}

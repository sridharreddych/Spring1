package com.stock.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


public class DBConnection {

	private static Logger log = LoggerFactory.getLogger(DBConnection.class);

	

	public static Connection getDbConnection() {
		Connection con = null;

		try {
			String driverName = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mysql";//10.117.75.124
			log.info(driverName);
			log.info(url);
			
			Class.forName(driverName);
			con = DriverManager.getConnection(url, "root", "root");
			log.info(con != null ? "connection established" : "connection failed");

		} catch (ClassNotFoundException cnfe) {
			log.error("There is no respective jars : " + cnfe.getMessage());
		} catch (SQLException se) {// Catching SQL Exception
			log.error("SQL Exception :" + se.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return con;
	}
	/*
	 * public static void main(String[] args) { Connection con = null; try { String
	 * driverName = "com.mysql.jdbc.Driver"; String url =
	 * "jdbc:mysql://localhost:3306/mysql"; Class.forName(driverName); con =
	 * DriverManager.getConnection(url, "root", "root"); System.out.println(con !=
	 * null ? "connection established" : "connection failed");
	 * 
	 * } catch (ClassNotFoundException cnfe) {
	 * System.out.println("There is no respective jars : " + cnfe.getMessage()); }
	 * catch (SQLException se) {// Catching SQL Exception
	 * System.out.println("SQL Exception :" + se.getMessage()); } catch (Exception
	 * e) { System.out.println(e); }
	 * 
	 * finally { try { con.close(); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } } }
	 */
}

package com.dbconnexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

	public Connection DbConnexion(){

		String url = "jdbc:mysql://localhost/lycee_java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String password="";

		try
		{
			Connection cnx = DriverManager.getConnection(url, user, password);
			return cnx;

		} catch (SQLException ee)
		{
			System.out.println("Une erreur est survenue lors de la connexion à la base de donn�es");
			ee.printStackTrace();
		}
		return null;
	}


}

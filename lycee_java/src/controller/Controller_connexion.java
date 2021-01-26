package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbconnexion.*;

public class Controller_connexion {
	
	public void connexion(String identifiant, String mdp) throws SQLException {
		
		Database db = new Database();
		Connection cnx = db.DbConnexion();
		String requete = "Select * from utilisateur where identifiant = "+identifiant+" and mdp = "+mdp;
		String role = "Admin";
		ResultSet resultat = db.Request(cnx, requete);
		if(resultat != null) {
			if(resultat.getString(role) == "Admin") {
				open
			}
			else {
				open
			}
		}
	}
}

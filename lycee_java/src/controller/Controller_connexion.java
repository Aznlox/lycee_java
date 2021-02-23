package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.widgets.Shell;

import com.dbconnexion.*;

import appli.Admin_Eleves;
import appli.Admin_menu;
import appli.Eleves;
import appli.Planning_prof;

public class Controller_connexion extends Global{
	
	public boolean Connexion(String identifiant, String mdp, Shell shell) throws SQLException {
		
		Database db = new Database();
		Connection cnx = db.DbConnexion();
		String requete = "Select * from utilisateur where identifiant = '"+identifiant+"' and mdp = '"+mdp+"'";
		String role = "role";
		ResultSet resultat = db.Request(cnx, requete);
		while(resultat.next()) {
			Globidentifiant = resultat.getString("identifiant");
			Globnom = resultat.getString("nom");
			if(resultat.getString(role).equals("Admin")) {
				try { //Connexion en tant qu'Administrateur
					shell.close();
					Admin_menu window_Admin = new Admin_menu();
					window_Admin.open();
					return false;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else { //Connexion en tant que professeur
				try {
					shell.close();
					Planning_prof window = new Planning_prof();
					window.open();
					return false;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		return true;
		
	}
}

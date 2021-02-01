package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.widgets.Shell;

import com.dbconnexion.*;

import appli.Admin_Eleves;
import appli.Eleves;

<<<<<<< Updated upstream
public class Controller_connexion
{

	public void connexion(String identifiant, String mdp) throws SQLException
	{

=======
public class Controller_connexion extends Global{
	
	public void Connexion(String identifiant, String mdp, Shell shell) throws SQLException {
		
>>>>>>> Stashed changes
		Database db = new Database();
		Connection cnx = db.DbConnexion();
		String requete = "Select * from utilisateur where identifiant = '"+identifiant+"' and mdp = '"+mdp+"'";
		String role = "role";
		ResultSet resultat = db.Request(cnx, requete);
<<<<<<< Updated upstream
		if(resultat != null)
		{
			if(resultat.getString(role) == "Admin")
			{
				try
				{
					//Connexion en tant qu'Administrateur
					Admin_Eleves window = new Admin_Eleves();
					window.open();
				}
				catch (Exception e)
				{
=======
		while(resultat.next()) {
			Globidentifiant = resultat.getString("identifiant");
			Globnom = resultat.getString("nom");
			if(resultat.getString(role).equals("Admin")) {
				try { //Connexion en tant qu'Administrateur
					shell.close();
					Admin_Eleves window_Admin = new Admin_Eleves();
					window_Admin.open();
					
				} catch (Exception e) {
>>>>>>> Stashed changes
					e.printStackTrace();
				}
			}
			else
			{
				 //Connexion en tant que professeur
				//Co prof
			}

		}
<<<<<<< Updated upstream
		else
		{
			 //Erreur identifiant et/ou mot de passe
=======
		//else { //Erreur identifiant et/ou mot de passe
>>>>>>> Stashed changes
			//erreur acces
		//}
	}
}

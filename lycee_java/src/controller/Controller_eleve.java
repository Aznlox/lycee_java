package controller;
import java.sql.Eleves;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.dbeleve.*;
import appli.motif;
import appli.Eleves;

public class Controller_eleve
{

	public void eleve(String identifiant, String mdp) throws SQLException
	{

		Database db = new Database();
		Connection cnx = db.Dbeleve();
		String requete = "Select * from utilisateur where identifiant = "+identifiant+" and mdp = "+mdp;
		String role = "Admin";
		ResultSet resultat = db.Request(cnx, requete);
		if(resultat != null)
		{
			if(resultat.getString(role) == "Admin")
			{
				try
				{
					//eleve en tant qu'Administrateur
					Admin_Eleves window = new Admin_Eleves();
					window.open();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				 //aller sur la page "motif"
			}

		}
		else
		{
			 //Erreur identifiant et/ou mot de passe
			//erreur acces
		}
	}
}

package controller;
import java.sql.Eleves;
import java.sql.ResultSet;
import com.dbeleve.*;
import appli.motif;
import appli.Eleves;
public class Controller_eleve
{

	public void eleve(String identifiant, String mdp)
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
					motif window = new motif();
					window.open(); //redirection vers notif
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

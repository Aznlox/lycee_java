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

	}

package controller;
import appli.motif;
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

package appli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.dbconnexion.Database;

import controller.Global;
import org.eclipse.wb.swt.SWTResourceManager;

public class Admin_ModifierCompte extends Global
{

	protected Shell shell;
	private Text textNom;
	private Text textPrenom;
	private Text textEmail;
	private Text textIdentifiant;
	private String nom;
	private String prenom;
	private String email;
	private String identifiant;
	private String mdp;
	private Text textMotdePasse;



	public void open() throws SQLException
	{
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}

	/**
	* Fondation du contenu de la fenetre
	* @throws SQLException
	* @wbp.parser.entryPoint
	*/
	protected void createContents() throws SQLException
	{
		shell = new Shell();
		shell.setSize(765, 559);
		shell.setText("Modifier professeur");

		Label lblNom = new Label(shell, SWT.NONE);
		lblNom.setBounds(165, 121, 81, 25);
		lblNom.setText("Nom");

		Label lblPrnom = new Label(shell, SWT.NONE);
		lblPrnom.setBounds(165, 178, 81, 25);
		lblPrnom.setText("Pr\u00E9nom");

		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(165, 231, 81, 25);
		lblEmail.setText("Email");

		Label lblIdentifiant = new Label(shell, SWT.NONE);
		lblIdentifiant.setBounds(165, 284, 81, 25);
		lblIdentifiant.setText("Identifiant");

		Label lblTitre = new Label(shell, SWT.NONE);
		lblTitre.setBounds(251, 34, 228, 25);
		lblTitre.setText("Modifier un professeur");

		textNom = new Text(shell, SWT.BORDER);
		textNom.setBounds(277, 121, 147, 31);

		textPrenom = new Text(shell, SWT.BORDER);
		textPrenom.setBounds(277, 176, 147, 31);

		textEmail = new Text(shell, SWT.BORDER);
		textEmail.setBounds(277, 231, 147, 31);

		textIdentifiant = new Text(shell, SWT.BORDER);
		textIdentifiant.setBounds(277, 287, 147, 31);
		
		textMotdePasse = new Text(shell, SWT.BORDER);
		textMotdePasse.setBounds(277, 348, 147, 31);

		Button btnValider = new Button(shell, SWT.NONE);
		btnValider.setBounds(297, 406, 105, 35);
		btnValider.setText("Valider");

		Button btnRetour = new Button(shell, SWT.NONE);
		btnRetour.setBounds(10, 10, 105, 35);
		btnRetour.setText("Retour");

		Database db = new Database();
		Connection cnx = db.DbConnexion();
		String requete = "Select nom, prenom, email, identifiant, mdp from utilisateur  where id ='"+Globideleve+"'";
		ResultSet resultat = db.Request(cnx, requete);
		while(resultat.next())
		{
			nom = resultat.getString("nom");
			prenom = resultat.getString("prenom");
			email = resultat.getString("email");
			identifiant = resultat.getString("identifiant");
			mdp = resultat.getString("mdp");
	
		}
		textNom.setText(nom);
		textPrenom.setText(prenom);
		textEmail.setText(email);
		textIdentifiant.setText(identifiant);
		textMotdePasse.setText(mdp);

		Label lblErreur = new Label(shell, SWT.NONE);
		lblErreur.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblErreur.setBounds(307, 415, 253, 25);
		lblErreur.setText("Veuiller remplir tous les champs");
		lblErreur.setVisible(false);

		Label lblSucces = new Label(shell, SWT.NONE);
		lblSucces.setVisible(false);
		lblSucces.setText("Modifications enregistr\u00E9es");
		lblSucces.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblSucces.setBounds(307, 415, 253, 25);
		lblSucces.setVisible(false);
				
		Label lblMotDePasse = new Label(shell, SWT.NONE);
		lblMotDePasse.setText("Mot de passe");
		lblMotDePasse.setBounds(165, 345, 81, 25);

		btnValider.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String requete = "Update utilisateur set nom ='"+textNom.getText()+"', prenom ='"+textPrenom.getText()+"', email ='"+textEmail.getText()+"', identifiant ='"+textIdentifiant.getText()+"', mdp ='"+textMotdePasse.getText()+"' where identifiant = '"+Globidentifiant+"'";
				boolean message = db.Prepare(cnx, requete);
				lblErreur.setVisible(message);
				lblSucces.setVisible(!message);
				requete = "Select nom, prenom, email, identifiant, mdp from utilisateur where identifiant = '"+Globidentifiant+"'";
				ResultSet resultat = db.Request(cnx, requete);
				try
				{
					while(resultat.next())
					{
						nom = resultat.getString("nom");
						prenom = resultat.getString("prenom");
						email = resultat.getString("email");
						identifiant = resultat.getString("identifiant");
						mdp = resultat.getString("mdp");
					}
				}
				catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textNom.setText(nom);
				textPrenom.setText(prenom);
				textEmail.setText(email);
				textIdentifiant.setText(identifiant);
				textMotdePasse.setText(mdp);
			}
		});

		btnRetour.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				shell.close();
				try
				{
					Globnom = nom;
					Liste_Prof window = new Liste_Prof();
					window.open();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});

	}
}

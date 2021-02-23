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
import org.eclipse.swt.widgets.Combo;

public class Modifier_eleve extends Global
{

	protected Shell shell;
	private Text Nom;
	private Text Prenom;
	private Text Classe;
	private String nom;
	private String prenom;
	private String email;
	private String matiere;



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
		shell.setText("Modifier son profil");

		Label lblNom = new Label(shell, SWT.NONE);
		lblNom.setBounds(165, 121, 81, 25);
		lblNom.setText("Eleve");

		Label lblPrnom = new Label(shell, SWT.NONE);
		lblPrnom.setBounds(165, 173, 81, 25);
		lblPrnom.setText("Nom");

		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(165, 231, 81, 25);
		lblEmail.setText("Prenom");

		Label lblMatire = new Label(shell, SWT.NONE);
		lblMatire.setBounds(165, 289, 81, 25);
		lblMatire.setText("Classe");

		Label lblTitre = new Label(shell, SWT.NONE);
		lblTitre.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblTitre.setBounds(266, 34, 228, 25);
		lblTitre.setText("Modifier un El\u00E8ve");

		Nom = new Text(shell, SWT.BORDER);
		Nom.setBounds(277, 176, 147, 31);

		Prenom = new Text(shell, SWT.BORDER);
		Prenom.setBounds(277, 231, 147, 31);

		Classe = new Text(shell, SWT.BORDER);
		Classe.setBounds(277, 287, 147, 31);

		Button btnValider = new Button(shell, SWT.NONE);
		btnValider.setBounds(298, 347, 105, 35);
		btnValider.setText("Modifier");

		Button btnRetour = new Button(shell, SWT.NONE);
		btnRetour.setBounds(10, 10, 105, 35);
		btnRetour.setText("Retour");

		Database db = new Database();
		Connection cnx = db.DbConnexion();
		String requete = "Select nom, prenom, id_classe from eleve";
		ResultSet resultat = db.Request(cnx, requete);
		while(resultat.next())
		{
			nom = resultat.getString("nom");
			prenom = resultat.getString("prenom");
			id_classe = resultat.getString("id_classe");
		}
		Nom.setText(prenom);
		Prenom.setText(email);
		Classe.setText(matiere);

		Label lblErreur = new Label(shell, SWT.NONE);
		lblErreur.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblErreur.setBounds(307, 415, 253, 25);
		lblErreur.setText("Veuiller remplir tous les champs");
		lblErreur.setVisible(false);

		Label lblSucces = new Label(shell, SWT.NONE);
		lblSucces.setVisible(false);
		lblSucces.setText("Modifications enregistr\u00E9s");
		lblSucces.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblSucces.setBounds(307, 415, 253, 25);
		lblSucces.setVisible(false);
		
		Combo Eleve = new Combo(shell, SWT.NONE);
		Eleve.setBounds(277, 120, 147, 25);

		btnValider.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String requete = "Update utilisateur set nom ='"+textNom.getText()+"', prenom ='"+Nom.getText()+"', email ='"+Prenom.getText()+"', matiere ='"+Classe.getText()+"' where identifiant = '"+Globidentifiant+"'";
				boolean message = db.Prepare(cnx, requete);
				lblErreur.setVisible(message);
				lblSucces.setVisible(!message);
				requete = "Select nom, prenom, email, matiere from utilisateur where identifiant = '"+Globidentifiant+"'";
				ResultSet resultat = db.Request(cnx, requete);
				try
				{
					while(resultat.next())
					{
						nom = resultat.getString("nom");
						prenom = resultat.getString("prenom");
						email = resultat.getString("email");
						matiere = resultat.getString("matiere");
					}
				}
				catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textNom.setText(nom);
				Nom.setText(prenom);
				Prenom.setText(email);
				Classe.setText(matiere);
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
					Planning_prof window = new Planning_prof();
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

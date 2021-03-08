package appli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.dbconnexion.Database;

import controller.Global;

import org.eclipse.swt.widgets.Combo;

public class Admin_GererCompte extends Global
{

	protected Shell shell;
	private Text textNom;
	private Text textPrenom;
	private Text textidentifiant;
	private Text textemail;
	private Text textmdp;
	private Text textmatiere;
	private Text textrole;
	private String nom;
	private String prenom;
	private String identifiant;
	private String email;
	private String mdp;
	private String matiere;
	private String role;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;



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
		shell.setText("Ajouter un Professeur");

		Label lblNom = new Label(shell, SWT.NONE);
		lblNom.setBounds(165, 138, 81, 25);
		lblNom.setText("Nom");

		Label lblPrnom = new Label(shell, SWT.NONE);
		lblPrnom.setBounds(165, 188, 81, 25);
		lblPrnom.setText("Pr\u00E9nom");

		Label lblTitre = new Label(shell, SWT.NONE);
		lblTitre.setBounds(270, 34, 228, 25);
		lblTitre.setText("Ajouter un professeur");

		textNom = new Text(shell, SWT.BORDER);
		textNom.setBounds(270, 135, 147, 31);

		textPrenom = new Text(shell, SWT.BORDER);
		textPrenom.setBounds(270, 185, 147, 31);

		Button btnValider = new Button(shell, SWT.NONE);
		btnValider.setBounds(554, 410, 105, 35);
		btnValider.setText("Valider");

		Button btnRetour = new Button(shell, SWT.NONE);
		btnRetour.setBounds(10, 10, 105, 35);
		btnRetour.setText("Retour");

		Label lblErreur = new Label(shell, SWT.NONE);
		lblErreur.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblErreur.setBounds(307, 415, 253, 25);
		lblErreur.setText("Veuiller remplir tous les champs");
		lblErreur.setVisible(false);

		Label lblSucces = new Label(shell, SWT.NONE);
		lblSucces.setText("Ajout r\u00E9ussi");
		lblSucces.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblSucces.setBounds(307, 415, 253, 25);
		lblSucces.setVisible(false);

		Label lblClasse = new Label(shell, SWT.NONE);
		lblClasse.setBounds(159, 234, 87, 25);
		lblClasse.setText("Identifiant");

		text = new Text(shell, SWT.BORDER);
		text.setBounds(270, 231, 147, 31);

		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setText("Email");
		lblEmail.setBounds(165, 284, 87, 25);

		Label lblMotDePasse = new Label(shell, SWT.NONE);
		lblMotDePasse.setText("MDP");
		lblMotDePasse.setBounds(165, 328, 81, 25);

		Label lblMatire = new Label(shell, SWT.NONE);
		lblMatire.setText("Mati\u00E8re");
		lblMatire.setBounds(165, 372, 81, 25);

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(270, 284, 147, 31);

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(270, 333, 147, 31);

		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(270, 372, 147, 31);

		Database db = new Database();
		Connection cnx = db.DbConnexion();

		btnValider.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String requete = "INSERT into utilisateur (nom, prenom, identifiant, email, mdp, matiere) Values('"+textNom.getString()+"','"+textPrenom.getString()+"','"+textidentifiant.getString()+"','"+textemail.getString()+"','"+textmdp.getString()+"','"+textmatiere.getString()+"','professeur')";
				boolean message = db.Prepare(cnx, requete);
				lblErreur.setVisible(message);
				lblSucces.setVisible(!message);
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
					Liste_Eleve window = new Liste_Eleve();
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

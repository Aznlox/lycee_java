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

import controller.Controller_connexion;
import controller.Global;
import org.eclipse.wb.swt.SWTResourceManager;

public class form extends Global
{

	protected Shell shell;
	private Text textNom;
	private Text textPrenom;
	private String nom;
	private String prenom;



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
		shell.setText("Ajouter une abscence");

		Label lblNom = new Label(shell, SWT.NONE);
		lblNom.setBounds(165, 121, 81, 25);
		lblNom.setText("Nom");


		Label lblTitre = new Label(shell, SWT.NONE);
		lblTitre.setBounds(251, 34, 228, 25);
		lblTitre.setText("Modifier son profil");

		textNom = new Text(shell, SWT.BORDER);
		textNom.setBounds(277, 121, 147, 31);


		Button btnValider = new Button(shell, SWT.NONE);
		btnValider.setBounds(307, 340, 105, 35);
		btnValider.setText("Valider");

		Button btnModifier = new Button(shell, SWT.NONE);
		btnModifier.setBounds(10, 10, 105, 35);
		btnModifier.setText("Retour");

		Database db = new Database();
		Connection cnx = db.DbConnexion();
		String requete = "Select nom  from vie_scolaire";
		ResultSet resultat = db.Request(cnx, requete);


		Label lblErreur = new Label(shell, SWT.NONE);
		lblErreur.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblErreur.setBounds(307, 415, 253, 25);
		lblErreur.setText("Veuiller remplir tous les champs");
		lblErreur.setVisible(false);

		btnValider.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String requete = "Update eleve set nom ='"+textNom.getText()+"'";
				boolean message = db.Prepare(cnx, requete);
				lblErreur.setVisible(message);
				requete = "Select * FROM eleve";
				ResultSet resultat = db.Request(cnx, requete);
				textNom.setText(nom);
				textPrenom.setText(prenom);

			}
		});


	}
}

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
import org.eclipse.swt.widgets.Combo;

public class form extends Global
{

	protected Shell shell;
	private Text Type;
	private String Nom;
	private String Date;
	private String Justification;



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

		Label lblNom = new Label(shell, SWT.NONE);
		lblNom.setBounds(200, 133, 56, 16);
		lblNom.setText("Nom");
		
		Nom = new Text(shell, SWT.BORDER);
		Nom.setBounds(289, 133, 156, 19);
		
		Label lblType = new Label(shell, SWT.NONE);
		lblType.setText("Type");
		lblType.setBounds(200, 177, 56, 16);
		
		Label lblDate = new Label(shell, SWT.NONE);
		lblDate.setText("Date");
		lblDate.setBounds(200, 224, 56, 16);
		
		Date = new Text(shell, SWT.BORDER);
		Date.setBounds(289, 224, 156, 19);
		
		String Type = new Combo(shell, SWT.NONE);
		Type.setBounds(289, 177, 156, 20);
		
		Label lblJustification = new Label(shell, SWT.NONE);
		lblJustification.setText("Justification");
		lblJustification.setBounds(200, 280, 72, 16);
		
		Justification = new Text(shell, SWT.BORDER);
		Justification.setBounds(289, 268, 156, 40);
		
		Button btnAjouter = new Button(shell, SWT.NONE);
		btnAjouter.setBounds(337, 343, 70, 21);
		btnAjouter.setText("Ajouter");
		
		Database db = new Database();
		Connection cnx = db.DbConnexion();
		String requete = "Select * from vie_scolaire";
		ResultSet resultat = db.Request(cnx, requete);
		while(resultat.next()) {
			Nom = resultat.getString("nom");
			Type = resultat.getString("type");
			Date = resultat.getString("date");
			Justification = resultat.getString("justification");
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		Nom.setText(Nom);
		Type.setText(Type);
		Date.setText(date);
		Justification.setText(justification);
		


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
	)};
}

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

	protected Shell shelleleve;
	private Text textNom;
	private Text textPrenom;
	private String nom;
	private String prenom;
	private String email;


	public void open() throws SQLException
	{
		Display display = Display.getDefault();
		createContents();
		shelleleve.open();
		shelleleve.layout();
		while (!shelleleve.isDisposed())
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
		shelleleve = new Shell();
		shelleleve.setSize(765, 559);
		shelleleve.setText("Modifier son profil");

		Label lblTitre = new Label(shelleleve, SWT.NONE);
		lblTitre.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblTitre.setBounds(266, 34, 228, 25);
		lblTitre.setText("Modifier un El\u00E8ve");

		Label lblNom = new Label(shelleleve, SWT.NONE);
		lblNom.setBounds(165, 123, 81, 25);
		lblNom.setText("Nom");

		Label lblPrenom = new Label(shelleleve, SWT.NONE);
		lblPrenom.setBounds(165, 173, 81, 25);
		lblPrenom.setText("Pr\u00E9nom");

		Label lblClasse = new Label(shelleleve, SWT.NONE);
		lblClasse.setBounds(165, 226, 81, 25);
		lblClasse.setText("Classe");

		textNom = new Text(shelleleve, SWT.BORDER);
		textNom.setBounds(277, 120, 147, 31);

		textPrenom = new Text(shelleleve, SWT.BORDER);
		textPrenom.setBounds(277, 170, 147, 31);

		Combo comboClasse = new Combo(shelleleve, SWT.READ_ONLY);
		comboClasse.setBounds(277, 223, 147, 33);

		Button btnValider = new Button(shelleleve, SWT.NONE);
		btnValider.setBounds(298, 347, 105, 35);
		btnValider.setText("Modifier");

		Button btnRetour = new Button(shelleleve, SWT.NONE);
		btnRetour.setBounds(10, 10, 105, 35);
		btnRetour.setText("Retour");

		Database db = new Database();
		Connection cnx = db.DbConnexion();

		String requete = "Select * from classe";
		ResultSet resultat = db.Request(cnx, requete);
		while(resultat.next()) {
			comboClasse.add(resultat.getString("libelle"));
		}
		requete = "Select nom, prenom, id_classe from eleve where id ='"+Globideleve+"'";
		resultat = db.Request(cnx, requete);
		while(resultat.next())
		{
			nom = resultat.getString("nom");
			prenom = resultat.getString("prenom");

		}
		textNom.setText(nom);
		textPrenom.setText(prenom);
		//comboClasse.select(resultat.getInt("id_classe")-1);


		Label lblErreur = new Label(shelleleve, SWT.NONE);
		lblErreur.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblErreur.setBounds(227, 415, 253, 25);
		lblErreur.setText("Veuiller remplir tous les champs");
		lblErreur.setVisible(false);

		Label lblSucces = new Label(shelleleve, SWT.NONE);
		lblSucces.setVisible(false);
		lblSucces.setText("Modifications enregistr\u00E9es");
		lblSucces.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblSucces.setBounds(227, 415, 253, 25);
		lblSucces.setVisible(false);

		btnValider.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String requete = "Update eleve set nom ='"+textNom.getText()+"', prenom ='"+textPrenom.getText()+"' where id = '"+Globideleve+"'";
				boolean message = db.Prepare(cnx, requete);
				lblErreur.setVisible(message);
				lblSucces.setVisible(!message);
				requete = "Select nom, prenom from eleve where id = '"+Globideleve+"'";
				ResultSet resultat = db.Request(cnx, requete);
				try
				{
					while(resultat.next())
					{
						nom = resultat.getString("nom");
						prenom = resultat.getString("prenom");

					}
				}
				catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				textNom.setText(nom);
				textPrenom.setText(prenom);

			}
		});

		btnRetour.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				shelleleve.close();
				Globideleve = null;
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

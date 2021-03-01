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

public class Admin_AjoutEleve extends Global {

	protected Shell shell;
	private Text textNom;
	private Text textPrenom;
	private String nom;
	private String prenom;
	private String classe;



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
		shell.setText("Ajouter un élève");

		Label lblNom = new Label(shell, SWT.NONE);
		lblNom.setBounds(165, 121, 81, 25);
		lblNom.setText("Nom");

		Label lblPrnom = new Label(shell, SWT.NONE);
		lblPrnom.setBounds(165, 173, 81, 25);
		lblPrnom.setText("Pr\u00E9nom");

		Label lblTitre = new Label(shell, SWT.NONE);
		lblTitre.setBounds(270, 34, 228, 25);
		lblTitre.setText("Ajouter un \u00E9l\u00E8ve");

		textNom = new Text(shell, SWT.BORDER);
		textNom.setBounds(277, 121, 147, 31);

		textPrenom = new Text(shell, SWT.BORDER);
		textPrenom.setBounds(277, 176, 147, 31);

		Button btnValider = new Button(shell, SWT.NONE);
		btnValider.setBounds(277, 334, 105, 35);
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
		lblSucces.setVisible(false);
		lblSucces.setText("Ajout r\u00E9ussi");
		lblSucces.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblSucces.setBounds(307, 415, 253, 25);
		lblSucces.setVisible(false);
		
		Label lblClasse = new Label(shell, SWT.NONE);
		lblClasse.setBounds(165, 231, 81, 25);
		lblClasse.setText("Classe");
		
		Combo comboClasse = new Combo(shell, SWT.READ_ONLY);
		comboClasse.setBounds(277, 223, 147, 33);
		
		Database db = new Database();
		Connection cnx = db.DbConnexion();
		String requete = "Select * from classe";
		ResultSet resultat = db.Request(cnx, requete);
		ArrayList<Integer> classeList = new  ArrayList<Integer>();
		while(resultat.next()) {
			
			comboClasse.add(resultat.getString("libelle"));
			classeList.add(resultat.getInt("id"));
		}
		comboClasse.select(0);

		btnValider.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String requete = "INSERT into eleve (nom, prenom, id_classe) Values('"+textNom.getText()+"','"+textPrenom.getText()+"',"+classeList.get(comboClasse.getSelectionIndex())+")";
				boolean resultat = db.Prepare(cnx, requete);
				lblSucces.setVisible(!resultat);
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

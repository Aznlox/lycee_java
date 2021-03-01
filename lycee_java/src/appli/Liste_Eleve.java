package appli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Menu;
import com.dbconnexion.*;

import controller.Global;
import org.eclipse.swt.widgets.Combo;

public class Liste_Eleve extends Global
{

	protected Shell shlListeEleve;
	private Table table;
	Database db = new Database();
	Connection cnx = db.DbConnexion();




	/**
	* Ouverture de la fenetre
	 * @throws SQLException 
	*/
	public void open() throws SQLException
	{
		Display display = Display.getDefault();
		createContents();
		shlListeEleve.open();
		shlListeEleve.layout();
		while (!shlListeEleve.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}


	/**
	* @throws SQLException 
	 * @wbp.parser.entryPoint
	*/
	protected void createContents() throws SQLException
	{

		shlListeEleve = new Shell();
		shlListeEleve.setSize(785, 542);
		shlListeEleve.setText("Liste des El\u00E8ves");

		Composite composite = new Composite(shlListeEleve, SWT.NONE);
		composite.setBounds(363, 131, 361, 266);


		Label textNom = new Label(composite, SWT.NONE);
		textNom.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		textNom.setBounds(160, 26, 180, 35);

		Label textPrenom = new Label(composite, SWT.NONE);
		textPrenom.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		textPrenom.setBounds(160, 73, 180, 35);

		Label lblNom = new Label(composite, SWT.NONE);
		lblNom.setText("Nom");
		lblNom.setBounds(62, 29, 67, 25);

		Label lblPrenom = new Label(composite, SWT.NONE);
		lblPrenom.setText("Prenom");
		lblPrenom.setBounds(62, 77, 67, 35);
		
		Label lblError = new Label(shlListeEleve, SWT.NONE);
		lblError.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblError.setBounds(263, 410, 385, 25);
		lblError.setText("Veuillez selectionner un \u00E9l\u00E8ve en double cliquant");
		lblError.setVisible(false);

		Label listeeleves = new Label(shlListeEleve, SWT.NONE);
		listeeleves.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		listeeleves.setBounds(46, 91, 191, 29);
		listeeleves.setText("Liste des \u00E9l\u00E8ves");

		table = new Table(shlListeEleve, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(26, 126, 218, 283);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn libelleNomEleve = new TableColumn(table, SWT.NONE);
		libelleNomEleve.setWidth(100);
		libelleNomEleve.setText("Nom");
		
		TableColumn libellePrenomEleve = new TableColumn(table, SWT.NONE);
		libellePrenomEleve.setWidth(100);
		libellePrenomEleve.setText("Pr\u00E9nom");
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setResizable(false);
		tblclmnId.setText("id");

		
		Button btnModifEleve = new Button(shlListeEleve, SWT.NONE);
		btnModifEleve.setBounds(214, 441, 186, 35);
		btnModifEleve.setText("Modifier \u00E9l\u00E8ve");
		btnModifEleve.setVisible(Globadmin);
		btnModifEleve.setEnabled(false);
		btnModifEleve.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				shlListeEleve.close();
				try
				{
					Modifier_eleve window = new Modifier_eleve();
					window.open();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			
			}
		});
		
		Combo comboClasse = new Combo(shlListeEleve, SWT.READ_ONLY);
		comboClasse.setBounds(16, 52, 211, 33);
		
		//Bouton ajouter une evenement vie scolaire
		Button AjouterVieSco = new Button(shlListeEleve, SWT.NONE);
		AjouterVieSco.setBounds(424, 441, 309, 35);
		AjouterVieSco.setText("Ajouter un \u00E9v\u00E8nement de vie scolaire");
		AjouterVieSco.setEnabled(false);
		AjouterVieSco.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				try
				{
					form window = new form();
					window.open();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		Label lblClasse_1 = new Label(shlListeEleve, SWT.NONE);
		lblClasse_1.setBounds(16, 21, 81, 25);
		lblClasse_1.setText("Classe :");
		
		if(Globadmin) {
			String requete = "Select * from classe";
			ResultSet resultat = db.Request(cnx, requete);
			while(resultat.next()) {
				comboClasse.add(resultat.getString("libelle"));
			}
			comboClasse.select(0);
		}
		else {
			String requete = "Select * from planning inner join utilisateur on utilisateur.id = id_professeur inner join classe on planning.id_classe = classe.id where identifiant = '"+Globidentifiant+"' group by planning.id_classe";
			ResultSet resultat = db.Request(cnx, requete);
			while(resultat.next()) {
				comboClasse.add(resultat.getString("libelle"));
			}
			comboClasse.select(0);
		}
		
		Button btnValider = new Button(shlListeEleve, SWT.NONE);
		btnValider.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.clearAll();
				String sql = "SELECT * FROM eleve inner join classe on id_classe = classe.id where libelle = '"+comboClasse.getItem(comboClasse.getSelectionIndex())+"'";
				ResultSet res = db.Request(cnx, sql);

				try
				{
					int i = 0;
					while(res.next())
					{
						String id = Integer.toString(res.getInt("id"));
						String nom = res.getString("nom");
						String prenom = res.getString("prenom");
						TableItem item = new TableItem(table, SWT.NONE , i);
					    item.setText(0, nom);
					    item.setText(1, prenom);
					    item.setText(2, id);
					    i++;

					}
				}
				catch (SQLException e2)
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		table.addListener(SWT.DefaultSelection, new Listener() {
		      public void handleEvent(Event e) {
		        TableItem[] selection = table.getSelection();
		        for (int i = 0; i < selection.length; i++) {
			        Globideleve = selection[i].getText(2);
			        textNom.setText(selection[i].getText(0));
			        textPrenom.setText(selection[i].getText(1));
			        AjouterVieSco.setEnabled(true);
			        btnModifEleve.setEnabled(true);
		        }
		      }
		});
		btnValider.setBounds(233, 50, 105, 35);
		btnValider.setText("Valider");
		
		

	
			btnModifEleve.addSelectionListener(new SelectionAdapter()
			{
				@Override
				public void widgetSelected(SelectionEvent e)
				{
					shlListeEleve.close();
					try
					{
						form form = new form();
						form.open();
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}
				}
			});

	}
}

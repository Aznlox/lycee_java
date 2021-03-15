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

public class Liste_Prof extends Global
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
		shlListeEleve.setSize(802, 599);
		shlListeEleve.setText("Liste des professeurs");

		Composite composite = new Composite(shlListeEleve, SWT.BORDER);
		composite.setBounds(357, 167, 361, 266);


		Label textNom = new Label(composite, SWT.NONE);
		textNom.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		textNom.setBounds(160, 29, 180, 35);

		Label textPrenom = new Label(composite, SWT.NONE);
		textPrenom.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		textPrenom.setBounds(160, 77, 180, 35);

		Label lblNom = new Label(composite, SWT.NONE);
		lblNom.setText("Nom");
		lblNom.setBounds(62, 29, 67, 35);

		Label lblPrenom = new Label(composite, SWT.NONE);
		lblPrenom.setText("Prenom");
		lblPrenom.setBounds(62, 77, 67, 35);

		Label lblError = new Label(shlListeEleve, SWT.NONE);
		lblError.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblError.setBounds(257, 446, 385, 25);
		lblError.setText("Veuillez selectionner un \u00E9l\u00E8ve en double cliquant");
		lblError.setVisible(false);

		Label listeeleves = new Label(shlListeEleve, SWT.NONE);
		listeeleves.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		listeeleves.setBounds(40, 127, 191, 29);
		listeeleves.setText("Liste des utilisateurs");

		Label lblClasse_1 = new Label(shlListeEleve, SWT.NONE);
		lblClasse_1.setBounds(10, 57, 81, 25);
		lblClasse_1.setText("Classe :");

		table = new Table(shlListeEleve, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(20, 162, 218, 283);
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


		Button btnRetour = new Button(shlListeEleve, SWT.NONE);
		btnRetour.setBounds(10, 10, 105, 35);
		btnRetour.setText("Retour");
		btnRetour.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				shlListeEleve.close();
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


		Button btnModifEleve = new Button(shlListeEleve, SWT.NONE);
		btnModifEleve.setBounds(208, 477, 186, 35);
		btnModifEleve.setText("Modifier un professeur");
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
					Admin_ModifierCompte window = new Admin_ModifierCompte();
					window.open();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}

			}
		});

		//Bouton ajouter une evenement vie scolaire
		Button AjouterVieSco = new Button(shlListeEleve, SWT.NONE);
		AjouterVieSco.setBounds(418, 477, 309, 35);
		AjouterVieSco.setText("Ouvrir le menu");
		AjouterVieSco.setEnabled(false);
		AjouterVieSco.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				try
				{
					Admin_Menu window = new Admin_Menu();
					window.open();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});


		Button btnValider = new Button(shlListeEleve, SWT.NONE);
		btnValider.setBounds(20, 86, 211, 35);
		btnValider.setText("Afficher les professeurs");

		Button btnAjoutereleve = new Button(shlListeEleve, SWT.NONE);
		btnAjoutereleve.setBounds(532, 86, 186, 35);
		btnAjoutereleve.setText("Ajouter un Professeur");

		Button btnSuppEleve = new Button(shlListeEleve, SWT.NONE);
		btnSuppEleve.setBounds(357, 86, 169, 35);
		btnSuppEleve.setText("Retirer un Professeur");
		btnSuppEleve.setEnabled(false);

		btnValider.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Globideleve = null;
				AjouterVieSco.setEnabled(false);
		        btnModifEleve.setEnabled(false);
		        btnSuppEleve.setEnabled(false);
				table.clearAll();
				String sql = "SELECT * FROM utilisateur";
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
		table.addListener(SWT.DefaultSelection, new Listener()
		{
		      public void handleEvent(Event e)
					{
		        TableItem[] selection = table.getSelection();
		        for (int i = 0; i < selection.length; i++)
						{
			        Globideleve = selection[i].getText(2);
			        textNom.setText(selection[i].getText(0));
			        textPrenom.setText(selection[i].getText(1));
			        AjouterVieSco.setEnabled(true);
			        btnModifEleve.setEnabled(true);
			        btnSuppEleve.setEnabled(true);
		        }
		      }
		});

		btnSuppEleve.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String requete = "Delete from eleve where id ='"+Globideleve+"'";
				boolean message = db.Prepare(cnx, requete);

				Globideleve = null;
				AjouterVieSco.setEnabled(false);
		        btnModifEleve.setEnabled(false);
		        btnSuppEleve.setEnabled(false);
				table.clearAll();
				String sql = "SELECT * FROM utilisateur ";
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

		btnAjoutereleve.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				shlListeEleve.close();
				try
				{
					Admin_GererCompte window = new Admin_GererCompte();
					window.open();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});




		btnModifEleve.addSelectionListener(new SelectionAdapter()
			{
				@Override
				public void widgetSelected(SelectionEvent e)
				{
					shlListeEleve.close();
					try
					{
						Admin_ModifierCompte modif = new Admin_ModifierCompte();
						modif.open();
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}
				}
			});

	}
}

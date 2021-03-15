package appli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.dbconnexion.Database;

public class Admin_SupprPlanning {

	protected Shell shell;
	private Table table;
	protected String planning;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Admin_SupprPlanning window = new Admin_SupprPlanning();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		Database db = new Database();
		Connection cnx = db.DbConnexion();
		shell = new Shell();
		shell.setSize(825, 587);
		shell.setText("SWT Application");
		
		Label lblAjoutErreur = new Label(shell, SWT.NONE);
		lblAjoutErreur.setVisible(false);
		lblAjoutErreur.setText("Veuiller remplir le champs");
		lblAjoutErreur.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblAjoutErreur.setBounds(16, 461, 217, 25);

		Label lblAjoutSucces = new Label(shell, SWT.NONE);
		lblAjoutSucces.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblAjoutSucces.setBounds(16, 461, 102, 25);
		lblAjoutSucces.setText("Ajout r\u00E9ussi");
		lblAjoutSucces.setVisible(false);

		Label lblClasse = new Label(shell, SWT.NONE);
		lblClasse.setBounds(16, 21, 81, 25);
		lblClasse.setText("Classe :");

		Combo comboClasse = new Combo(shell, SWT.READ_ONLY);
		comboClasse.setBounds(16, 52, 211, 33);

		String requete = "Select * from classe where undeletable = 0";
		ResultSet resultat = db.Request(cnx, requete);
		ArrayList<Integer> classeList = new  ArrayList<Integer>();
		try {
			while(resultat.next())
			{

				comboClasse.add(resultat.getString("libelle"));
				classeList.add(resultat.getInt("id"));
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		comboClasse.addSelectionListener(new SelectionAdapter()
		  {
		    @Override
		    public void widgetSelected(final SelectionEvent event)
		    {
		    	AjouterPlanning.setEnabled(true);
		    	selectClasse = comboClasse.getSelectionIndex();
		    	selectProf = comboProf.getSelectionIndex();
		    	selectJour = jour;
		    	lblVue.setText(comboClasse.getItem(selectClasse)+" | "+comboProf.getItem(selectProf)+" | "+nomJour+" | "+comboHeure.getItem(comboHeure.getSelectionIndex()));
		    }
		  });
		

		Label lblProf = new Label(shell, SWT.NONE);
		lblProf.setBounds(16, 104, 105, 25);
		lblProf.setText("Professeur :");
		
		Combo comboProf = new Combo(shell, SWT.READ_ONLY);
		comboProf.setBounds(16, 135, 211, 33);
		requete = "Select * from utilisateur where role = 'professeur'";
		resultat = db.Request(cnx, requete);
		ArrayList<Integer> profList = new  ArrayList<Integer>();
		try {
			while(resultat.next())
			{
				comboProf.add(resultat.getString("nom"));
				profList.add(resultat.getInt("id"));
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(366, 52, 413, 283);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn libelleClasse = new TableColumn(table, SWT.NONE);
		libelleClasse.setWidth(100);
		libelleClasse.setText("Classe");

		TableColumn libelleNomProf = new TableColumn(table, SWT.NONE);
		libelleNomProf.setWidth(100);
		libelleNomProf.setText("Nom");
		
		TableColumn libelleJour = new TableColumn(table, SWT.NONE);
		libelleJour.setWidth(100);
		libelleJour.setText("Jour");
		
		TableColumn libelleHeure = new TableColumn(table, SWT.NONE);
		libelleHeure.setWidth(100);
		libelleHeure.setText("Heure");
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setResizable(false);
		tblclmnId.setText("id");
		
		table.addListener(SWT.DefaultSelection, new Listener() {
		      public void handleEvent(Event e) {
		        TableItem[] selection = table.getSelection();
		        for (int i = 0; i < selection.length; i++) {
			        textClasse.setText(selection[i].getText(0));
			        textNom.setText(selection[i].getText(1));
			        textJour.setText(selection[i].getText(2));
			        textHeure.setText(selection[i].getText(3));
			        planning = (selection[i].getText(4));
			        btnSupp.setEnabled(true);
		        }
		      }
		});
		
		btnValider.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.removeAll();
				String sql = "SELECT * FROM planning inner join classe on id_classe = classe.id, inner join utilisateur on id_professeur = utilisateur.id inner join jour on id_jour = jour.id inner join heure on id_heure = heure.id where id_classe = '"+classeList.get(comboClasse.getSelectionIndex())+"'";
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

	}

}

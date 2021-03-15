package appli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.dbconnexion.Database;

import controller.Global;
import org.eclipse.swt.widgets.Combo;

public class Admin_Planning extends Global
{

	protected Shell shell;
	private Table tableMardi;
	private Table tableMercredi;
	private Table tableLundi;
	private Table tableJeudi;
	private Table tableVendredi;


	/**
	* @wbp.parser.entryPoint
	*/
	public void open() throws Exception
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


	protected void createContents() throws SQLException
	{
		shell = new Shell();
		shell.setSize(1066, 551);
		shell.setText("Planning");
		shell.setLayout(new org.eclipse.swt.layout.FormLayout());

		tableMardi = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_tableMardi = new FormData();
		tableMardi.setLayoutData(fd_tableMardi);
		tableMardi.setHeaderVisible(true);
		tableMardi.setLinesVisible(true);

		tableMercredi = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_tableMardi.right = new FormAttachment(tableMercredi, -6);
		FormData fd_tableMercredi = new FormData();
		fd_tableMercredi.bottom = new FormAttachment(tableMardi, 0, SWT.BOTTOM);
		fd_tableMercredi.left = new FormAttachment(0, 542);
		tableMercredi.setLayoutData(fd_tableMercredi);
		tableMercredi.setHeaderVisible(true);
		tableMercredi.setLinesVisible(true);

		tableLundi = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_tableMardi.left = new FormAttachment(tableLundi, 6);
		fd_tableMardi.bottom = new FormAttachment(tableLundi, 0, SWT.BOTTOM);
		FormData fd_tableLundi = new FormData();
		fd_tableLundi.right = new FormAttachment(100, -650);
		fd_tableLundi.bottom = new FormAttachment(100, -31);
		tableLundi.setLayoutData(fd_tableLundi);
		tableLundi.setHeaderVisible(true);
		tableLundi.setLinesVisible(true);

		tableJeudi = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_tableMercredi.right = new FormAttachment(100, -366);
		FormData fd_tableJeudi = new FormData();
		fd_tableJeudi.left = new FormAttachment(tableMercredi, 6);
		fd_tableJeudi.bottom = new FormAttachment(tableMardi, 0, SWT.BOTTOM);
		tableJeudi.setLayoutData(fd_tableJeudi);
		tableJeudi.setHeaderVisible(true);
		tableJeudi.setLinesVisible(true);

		tableVendredi = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_tableJeudi.right = new FormAttachment(tableVendredi, -6);
		FormData fd_tableVendredi = new FormData();
		fd_tableVendredi.bottom = new FormAttachment(tableMardi, 0, SWT.BOTTOM);
		fd_tableVendredi.left = new FormAttachment(0, 826);
		fd_tableVendredi.right = new FormAttachment(100, -82);
		tableVendredi.setLayoutData(fd_tableVendredi);
		tableVendredi.setHeaderVisible(true);
		tableVendredi.setLinesVisible(true);

		Label lblh = new Label(shell, SWT.NONE);
		fd_tableLundi.left = new FormAttachment(0, 258);
		FormData fd_lblh = new FormData();
		fd_lblh.right = new FormAttachment(tableLundi, -6);
		lblh.setLayoutData(fd_lblh);
		lblh.setText("8h");

		Label lblh_1 = new Label(shell, SWT.NONE);
		fd_lblh.bottom = new FormAttachment(100, -342);
		FormData fd_lblh_1 = new FormData();
		fd_lblh_1.top = new FormAttachment(lblh);
		fd_lblh_1.right = new FormAttachment(tableLundi, -6);
		lblh_1.setLayoutData(fd_lblh_1);
		lblh_1.setText("9h");

		Label lblh_2 = new Label(shell, SWT.NONE);
		FormData fd_lblh_2 = new FormData();
		fd_lblh_2.top = new FormAttachment(lblh_1, 5);
		fd_lblh_2.right = new FormAttachment(tableLundi, -6);
		lblh_2.setLayoutData(fd_lblh_2);
		lblh_2.setText("10h");

		Label lblh_3 = new Label(shell, SWT.NONE);
		FormData fd_lblh_3 = new FormData();
		fd_lblh_3.top = new FormAttachment(lblh_2, 6);
		fd_lblh_3.right = new FormAttachment(tableLundi, -6);
		lblh_3.setLayoutData(fd_lblh_3);
		lblh_3.setText("11h");

		Label lblh_4 = new Label(shell, SWT.NONE);
		FormData fd_lblh_4 = new FormData();
		fd_lblh_4.top = new FormAttachment(lblh_2, 32);
		fd_lblh_4.right = new FormAttachment(tableLundi, -6);
		lblh_4.setLayoutData(fd_lblh_4);
		lblh_4.setText("12h");

		Label lblh_5 = new Label(shell, SWT.NONE);
		FormData fd_lblh_5 = new FormData();
		fd_lblh_5.right = new FormAttachment(tableLundi, -6);
		lblh_5.setLayoutData(fd_lblh_5);
		lblh_5.setText("14h");

		Label lblh_6 = new Label(shell, SWT.NONE);
		FormData fd_lblh_6 = new FormData();
		fd_lblh_6.top = new FormAttachment(lblh_5, 2);
		fd_lblh_6.right = new FormAttachment(tableLundi, -6);
		lblh_6.setLayoutData(fd_lblh_6);
		lblh_6.setText("15h");
		
				Label lblh_9 = new Label(shell, SWT.NONE);
				fd_lblh_5.top = new FormAttachment(lblh_9, 6);
				FormData fd_lblh_9 = new FormData();
				fd_lblh_9.top = new FormAttachment(lblh_4, 2);
				fd_lblh_9.right = new FormAttachment(tableLundi, -6);
				lblh_9.setLayoutData(fd_lblh_9);
				lblh_9.setText("13h");

		Label lblh_7 = new Label(shell, SWT.NONE);
		fd_lblh_6.bottom = new FormAttachment(lblh_7, -6);
		FormData fd_lblh_7 = new FormData();
		fd_lblh_7.right = new FormAttachment(tableLundi, -6);
		lblh_7.setLayoutData(fd_lblh_7);
		lblh_7.setText("16h");

		Label lblh_8 = new Label(shell, SWT.NONE);
		fd_lblh_7.bottom = new FormAttachment(lblh_8, -6);
		FormData fd_lblh_8 = new FormData();
		fd_lblh_8.top = new FormAttachment(0, 387);
		fd_lblh_8.right = new FormAttachment(tableLundi, -6);
		lblh_8.setLayoutData(fd_lblh_8);
		lblh_8.setText("17h");

		Label lblLundi = new Label(shell, SWT.NONE);
		fd_tableLundi.top = new FormAttachment(lblLundi, 10);

		TableItem tableItem_1_1 = new TableItem(tableLundi, SWT.NONE);

		TableItem tableItem_1_2 = new TableItem(tableLundi, SWT.NONE);

		TableItem tableItem_1_3 = new TableItem(tableLundi, SWT.NONE);

		TableItem tableItem_1_4 = new TableItem(tableLundi, SWT.NONE);

		TableItem tableItem_1_5 = new TableItem(tableLundi, SWT.NONE);

		TableItem tableItem_1_pause = new TableItem(tableLundi, SWT.NONE);
		tableItem_1_pause.setText("Pause               ");

		TableItem tableItem_1_6 = new TableItem(tableLundi, SWT.NONE);

		TableItem tableItem_1_7 = new TableItem(tableLundi, SWT.NONE);

		TableItem tableItem_1_8 = new TableItem(tableLundi, SWT.NONE);

		TableItem tableItem_1_9 = new TableItem(tableLundi, SWT.NONE);
		lblLundi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblLundi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		FormData fd_lblLundi = new FormData();
		fd_lblLundi.bottom = new FormAttachment(100, -400);

		fd_lblLundi.left = new FormAttachment(0, 297);
		lblLundi.setLayoutData(fd_lblLundi);
		lblLundi.setText("Lundi");

		Label lblMardi = new Label(shell, SWT.NONE);
		fd_tableMardi.top = new FormAttachment(lblMardi, 10);

		TableItem tableItem_2_1 = new TableItem(tableMardi, 0);

		TableItem tableItem_2_2 = new TableItem(tableMardi, 0);

		TableItem tableItem_2_3 = new TableItem(tableMardi, 0);

		TableItem tableItem_2_4 = new TableItem(tableMardi, 0);

		TableItem tableItem_2_5 = new TableItem(tableMardi, 0);

		TableItem tableItem_2_pause = new TableItem(tableMardi, 0);
		tableItem_2_pause.setText("Pause               ");

		TableItem tableItem_2_6 = new TableItem(tableMardi, 0);

		TableItem tableItem_2_7 = new TableItem(tableMardi, 0);

		TableItem tableItem_2_8 = new TableItem(tableMardi, 0);

		TableItem tableItem_2_9 = new TableItem(tableMardi, 0);
		lblMardi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblMardi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		FormData fd_lblMardi = new FormData();
		fd_lblMardi.top = new FormAttachment(lblLundi, 0, SWT.TOP);
		lblMardi.setLayoutData(fd_lblMardi);
		lblMardi.setText("Mardi");

		Label lblMercredi = new Label(shell, SWT.NONE);
		fd_lblMardi.right = new FormAttachment(100, -550);
		fd_tableMercredi.top = new FormAttachment(lblMercredi, 10);

		TableItem tableItem_3_1 = new TableItem(tableMercredi, 0);

		TableItem tableItem_3_2 = new TableItem(tableMercredi, 0);

		TableItem tableItem_3_3 = new TableItem(tableMercredi, 0);

		TableItem tableItem_3_4 = new TableItem(tableMercredi, 0);

		TableItem tableItem_3_5 = new TableItem(tableMercredi, 0);

		TableItem tableItem_3_pause = new TableItem(tableMercredi, 0);
		tableItem_3_pause.setText("Pause               ");

		TableItem tableItem_3_6 = new TableItem(tableMercredi, 0);

		TableItem tableItem_3_7 = new TableItem(tableMercredi, 0);

		TableItem tableItem_3_8 = new TableItem(tableMercredi, 0);

		TableItem tableItem_3_9 = new TableItem(tableMercredi, 0);
		lblMercredi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblMercredi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		FormData fd_lblMercredi = new FormData();
		fd_lblMercredi.top = new FormAttachment(lblLundi, 0, SWT.TOP);
		fd_lblMercredi.left = new FormAttachment(lblMardi, 76);
		lblMercredi.setLayoutData(fd_lblMercredi);
		lblMercredi.setText("Mercredi");

		Label lblJeudi = new Label(shell, SWT.NONE);
		fd_tableJeudi.top = new FormAttachment(lblJeudi, 10);

		TableItem tableItem_4_1 = new TableItem(tableJeudi, 0);

		TableItem tableItem_4_2 = new TableItem(tableJeudi, 0);

		TableItem tableItem_4_3 = new TableItem(tableJeudi, 0);

		TableItem tableItem_4_4 = new TableItem(tableJeudi, 0);

		TableItem tableItem_4_5 = new TableItem(tableJeudi, 0);

		TableItem tableItem_4_pause = new TableItem(tableJeudi, 0);
		tableItem_4_pause.setText("Pause               ");

		TableItem tableItem_4_6 = new TableItem(tableJeudi, 0);

		TableItem tableItem_4_7 = new TableItem(tableJeudi, 0);

		TableItem tableItem_4_8 = new TableItem(tableJeudi, 0);

		TableItem tableItem_4_9 = new TableItem(tableJeudi, 0);
		lblJeudi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblJeudi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		FormData fd_lblJeudi = new FormData();
		fd_lblJeudi.top = new FormAttachment(lblLundi, 0, SWT.TOP);
		lblJeudi.setLayoutData(fd_lblJeudi);
		lblJeudi.setText("Jeudi");

		Label lblVendredi = new Label(shell, SWT.NONE);
		fd_tableVendredi.top = new FormAttachment(lblVendredi, 10);

		TableItem tableItem_5_1 = new TableItem(tableVendredi, 0);

		TableItem tableItem_5_2 = new TableItem(tableVendredi, 0);

		TableItem tableItem_5_3 = new TableItem(tableVendredi, 0);

		TableItem tableItem_5_4 = new TableItem(tableVendredi, 0);

		TableItem tableItem_5_5 = new TableItem(tableVendredi, 0);

		TableItem tableItem_5_pause = new TableItem(tableVendredi, 0);
		tableItem_5_pause.setText("Pause               ");

		TableItem tableItem_5_6 = new TableItem(tableVendredi, 0);

		TableItem tableItem_5_7 = new TableItem(tableVendredi, 0);

		TableItem tableItem_5_8 = new TableItem(tableVendredi, 0);

		TableItem tableItem_5_9 = new TableItem(tableVendredi, 0);
		fd_lblJeudi.right = new FormAttachment(lblVendredi, -77);
		lblVendredi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblVendredi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		FormData fd_lblVendredi = new FormData();
		fd_lblVendredi.left = new FormAttachment(0, 853);
		fd_lblVendredi.top = new FormAttachment(lblLundi, 0, SWT.TOP);
		lblVendredi.setLayoutData(fd_lblVendredi);
		lblVendredi.setText("Vendredi");
		ArrayList<ArrayList<TableItem>> planning = new ArrayList<ArrayList<TableItem>>();
		ArrayList<TableItem> planning_lundi = new ArrayList<TableItem>();
		planning_lundi.add(tableItem_1_1);
		planning_lundi.add(tableItem_1_2);
		planning_lundi.add(tableItem_1_3);
		planning_lundi.add(tableItem_1_4);
		planning_lundi.add(tableItem_1_5);
		planning_lundi.add(tableItem_1_6);
		planning_lundi.add(tableItem_1_7);
		planning_lundi.add(tableItem_1_8);
		planning_lundi.add(tableItem_1_9);
		ArrayList<TableItem> planning_mardi = new ArrayList<TableItem>();
		planning_mardi.add(tableItem_2_1);
		planning_mardi.add(tableItem_2_2);
		planning_mardi.add(tableItem_2_3);
		planning_mardi.add(tableItem_2_4);
		planning_mardi.add(tableItem_2_5);
		planning_mardi.add(tableItem_2_6);
		planning_mardi.add(tableItem_2_7);
		planning_mardi.add(tableItem_2_8);
		planning_mardi.add(tableItem_2_9);
		ArrayList<TableItem> planning_mercredi = new ArrayList<TableItem>();
		planning_mercredi.add(tableItem_3_1);
		planning_mercredi.add(tableItem_3_2);
		planning_mercredi.add(tableItem_3_3);
		planning_mercredi.add(tableItem_3_4);
		planning_mercredi.add(tableItem_3_5);
		planning_mercredi.add(tableItem_3_6);
		planning_mercredi.add(tableItem_3_7);
		planning_mercredi.add(tableItem_3_8);
		planning_mercredi.add(tableItem_3_9);
		ArrayList<TableItem> planning_jeudi = new ArrayList<TableItem>();
		planning_jeudi.add(tableItem_4_1);
		planning_jeudi.add(tableItem_4_2);
		planning_jeudi.add(tableItem_4_3);
		planning_jeudi.add(tableItem_4_4);
		planning_jeudi.add(tableItem_4_5);
		planning_jeudi.add(tableItem_4_6);
		planning_jeudi.add(tableItem_4_7);
		planning_jeudi.add(tableItem_4_8);
		planning_jeudi.add(tableItem_4_9);
		ArrayList<TableItem> planning_vendredi = new ArrayList<TableItem>();
		planning_vendredi.add(tableItem_5_1);
		planning_vendredi.add(tableItem_5_2);
		planning_vendredi.add(tableItem_5_3);
		planning_vendredi.add(tableItem_5_4);
		planning_vendredi.add(tableItem_5_5);
		planning_vendredi.add(tableItem_5_6);
		planning_vendredi.add(tableItem_5_7);
		planning_vendredi.add(tableItem_5_8);
		planning_vendredi.add(tableItem_5_9);
		
		Database db = new Database();
		Connection cnx = db.DbConnexion();
		
		Combo comboProf = new Combo(shell, SWT.READ_ONLY);
		FormData fd_comboProf = new FormData();
		fd_comboProf.right = new FormAttachment(0, 213);
		fd_comboProf.top = new FormAttachment(0, 10);
		fd_comboProf.left = new FormAttachment(0, 25);
		comboProf.setLayoutData(fd_comboProf);
		ArrayList<Integer> profList = new  ArrayList<Integer>();
		String requete = "Select * from utilisateur where role = 'professeur'";
		ResultSet resultat = db.Request(cnx, requete);
		while(resultat.next()) {
			comboProf.add(resultat.getString("nom"));
			profList.add(resultat.getInt("id"));
		}
		comboProf.select(0);
		
		Button btnOkProf = new Button(shell, SWT.NONE);
		FormData fd_btnOkProf = new FormData();
		fd_btnOkProf.top = new FormAttachment(0, 10);
		fd_btnOkProf.left = new FormAttachment(comboProf, 19);
		fd_btnOkProf.bottom = new FormAttachment(0, 43);
		btnOkProf.setLayoutData(fd_btnOkProf);
		btnOkProf.setText("Selectionner");
		btnOkProf.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) {
				for(ArrayList<TableItem> jour : planning) {
					for(TableItem heure : jour) {
						heure.setText("");
					}
				}
				String requete = "Select * from planning inner join classe on id_classe = classe.id where id_professeur = '"+profList.get(comboProf.getSelectionIndex())+"'";
				ResultSet resultat = db.Request(cnx, requete);
				try {
					while(resultat.next())
					{
						int jour = resultat.getInt("id_jour") - 1;
						int heure = resultat.getInt("id_heure") - 1;
						String classe = resultat.getString("libelle");
						planning.get(jour).get(heure).setText(classe);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		Combo comboClasse = new Combo(shell, SWT.READ_ONLY);
		FormData fd_comboClasse = new FormData();
		fd_comboClasse.left = new FormAttachment(btnOkProf, 143);
		fd_comboClasse.top = new FormAttachment(0, 10);
		comboClasse.setLayoutData(fd_comboClasse);
		ArrayList<Integer> classeList = new  ArrayList<Integer>();
		requete = "Select * from classe where undeletable = 0";
		resultat = db.Request(cnx, requete);
		while(resultat.next()) {
			comboClasse.add(resultat.getString("libelle"));
			classeList.add(resultat.getInt("id"));
		}
		comboClasse.select(0);
		
		Button btnOkClasse = new Button(shell, SWT.NONE);
		fd_comboClasse.right = new FormAttachment(100, -376);
		FormData fd_btnOkClasse = new FormData();
		fd_btnOkClasse.bottom = new FormAttachment(comboProf, -1, SWT.BOTTOM);
		fd_btnOkClasse.top = new FormAttachment(comboProf, -1, SWT.TOP);
		fd_btnOkClasse.left = new FormAttachment(tableJeudi, 0, SWT.LEFT);
		btnOkClasse.setLayoutData(fd_btnOkClasse);
		btnOkClasse.setText("Selectionner");
		btnOkClasse.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) {
				for(ArrayList<TableItem> jour : planning) {
					for(TableItem heure : jour) {
						heure.setText("");
					}
				}
				String requete = "Select * from planning inner join utilisateur on id_professeur = utilisateur.id where id_classe = '"+classeList.get(comboClasse.getSelectionIndex())+"'";
				ResultSet resultat = db.Request(cnx, requete);
				try {
					while(resultat.next())
					{
						int jour = resultat.getInt("id_jour") - 1;
						int heure = resultat.getInt("id_heure") - 1;
						String classe = resultat.getString("nom");
						planning.get(jour).get(heure).setText(classe);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		Button btnAjouter = new Button(shell, SWT.NONE);
		FormData fd_btnAjouter = new FormData();
		fd_btnAjouter.top = new FormAttachment(lblh_3, -5, SWT.TOP);
		fd_btnAjouter.right = new FormAttachment(lblh, -34);
		btnAjouter.setLayoutData(fd_btnAjouter);
		btnAjouter.setText("Ajouter un \u00E9l\u00E9ment");
		
		Button btnSupprimer = new Button(shell, SWT.NONE);
		fd_btnAjouter.left = new FormAttachment(btnSupprimer, 0, SWT.LEFT);
		FormData fd_btnSupprimer = new FormData();
		fd_btnSupprimer.right = new FormAttachment(lblh_4, -24);
		fd_btnSupprimer.left = new FormAttachment(0, 10);
		fd_btnSupprimer.bottom = new FormAttachment(lblh_9, 0, SWT.BOTTOM);
		btnSupprimer.setLayoutData(fd_btnSupprimer);
		btnSupprimer.setText("Supprimer un \u00E9l\u00E9ment");

		planning.add(planning_lundi);
		planning.add(planning_mardi);
		planning.add(planning_mercredi);
		planning.add(planning_jeudi);
		planning.add(planning_vendredi);
		
		

	}
}

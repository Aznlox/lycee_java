package appli;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.dbconnexion.Database;

import controller.Global;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.custom.CBanner;
import org.eclipse.swt.widgets.Combo;

public class Planning_prof extends Global
{

	protected Shell shell;
	private Button btnClasse;
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
		shell.setText("SWT Application");
		shell.setLayout(new org.eclipse.swt.layout.FormLayout());

		btnClasse = new Button(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_btnClasse = new org.eclipse.swt.layout.FormData();
		fd_btnClasse.right = new FormAttachment(0, 91);
		btnClasse.setLayoutData(fd_btnClasse);
		btnClasse.setText("Acc\u00E9der");

		Label lblBonjour = new Label(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_lblBonjour = new org.eclipse.swt.layout.FormData();
		fd_lblBonjour.right = new FormAttachment(0, 449);
		fd_lblBonjour.top = new org.eclipse.swt.layout.FormAttachment(0, 13);
		fd_lblBonjour.left = new org.eclipse.swt.layout.FormAttachment(0, 380);
		lblBonjour.setLayoutData(fd_lblBonjour);
		lblBonjour.setText("Bonjour");

		Label lblVosClasses = new Label(shell, SWT.NONE);
		fd_btnClasse.left = new FormAttachment(lblVosClasses, 0, SWT.LEFT);
		org.eclipse.swt.layout.FormData fd_lblVosClasses = new org.eclipse.swt.layout.FormData();
		fd_lblVosClasses.right = new org.eclipse.swt.layout.FormAttachment(0, 115);
		fd_lblVosClasses.top = new org.eclipse.swt.layout.FormAttachment(0, 124);
		fd_lblVosClasses.left = new org.eclipse.swt.layout.FormAttachment(0, 10);
		lblVosClasses.setLayoutData(fd_lblVosClasses);
		lblVosClasses.setText("Vos Classes:");

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
		fd_btnClasse.bottom = new FormAttachment(lblh_4, 0, SWT.BOTTOM);
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

		Label lblNom = new Label(shell, SWT.NONE);
		FormData fd_lblNom = new FormData();
		fd_lblNom.bottom = new FormAttachment(lblBonjour, 0, SWT.BOTTOM);
		fd_lblNom.left = new FormAttachment(lblBonjour, 6);
		lblNom.setLayoutData(fd_lblNom);
		lblNom.setText(Globnom);
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

		Label lblh_9 = new Label(shell, SWT.NONE);
		fd_lblh_5.top = new FormAttachment(lblh_9, 6);
		FormData fd_lblh_9 = new FormData();
		fd_lblh_9.top = new FormAttachment(lblh_4, 2);
		fd_lblh_9.right = new FormAttachment(tableLundi, -6);
		lblh_9.setLayoutData(fd_lblh_9);
		lblh_9.setText("13h");
		
		Combo comboClasse = new Combo(shell, SWT.NONE);
		FormData fd_comboClasse = new FormData();
		fd_comboClasse.right = new FormAttachment(0, 166);
		fd_comboClasse.top = new FormAttachment(lblVosClasses, 21);
		fd_comboClasse.left = new FormAttachment(0, 11);
		comboClasse.setLayoutData(fd_comboClasse);
		
		Database db = new Database();
		Connection cnx = db.DbConnexion();
		String requete = "Select * from planning inner join utilisateur on utilisateur.id = id_professeur inner join classe on planning.id_classe = classe.id where identifiant = '"+Globidentifiant+"' group by planning.id_classe";
		ResultSet resultat = db.Request(cnx, requete);
		while(resultat.next()) {
			comboClasse.add(resultat.getString("libelle"));
		}
		comboClasse.select(0);
		
		btnClasse.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				shell.close();
				try
				{
					Modifier_prof modif_prof = new Modifier_prof();
					modif_prof.open();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		Button btnModifier = new Button(shell, SWT.NONE);
		FormData fd_btnModifier = new FormData();
		fd_btnModifier.left = new FormAttachment(0, 10);
		fd_btnModifier.bottom = new FormAttachment(tableMardi, 0, SWT.BOTTOM);
		btnModifier.setLayoutData(fd_btnModifier);
		btnModifier.setText("Modifier votre profil");

		planning.add(planning_lundi);
		planning.add(planning_mardi);
		planning.add(planning_mercredi);
		planning.add(planning_jeudi);
		planning.add(planning_vendredi);

		
		requete = "Select * from utilisateur inner join planning on utilisateur.id = id_professeur inner join grille_horaire on id_grille = grille_horaire.id inner join classe on planning.id_classe = classe.id where identifiant = '"+Globidentifiant+"'";
		resultat = db.Request(cnx, requete);
		while(resultat.next())
		{
			int jour = resultat.getInt("id_jour") - 1;
			int heure = resultat.getInt("id_heure") - 1;
			String classe = resultat.getString("libelle");
			planning.get(jour).get(heure).setText(classe);

		}

		btnModifier.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				shell.close();
				try
				{
					Modifier_prof modif_prof = new Modifier_prof();
					modif_prof.open();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});

	}
}

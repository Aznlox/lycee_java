package appli;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import java.sql.Connection;
import java.sql.ResultSet;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.DateTime;
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

public class Planning_prof extends Global
{

	protected Shell shell;
	private Button btnBtsSlam;
	private Button btnTerminaleStid;
	private Table tableMardi;
	private Table tableMercredi;
	private Table tableLundi;
	private Table tableJeudi;
	private Table tableVendredi;


	public static void main(String[] args) {
		try {
			Planning_prof window = new Planning_prof();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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


	protected void createContents() {
		shell = new Shell();
		shell.setSize(1066, 551);
		shell.setText("SWT Application");
		shell.setLayout(new org.eclipse.swt.layout.FormLayout());
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_btnNewButton = new org.eclipse.swt.layout.FormData();
		fd_btnNewButton.right = new org.eclipse.swt.layout.FormAttachment(0, 115);
		fd_btnNewButton.top = new org.eclipse.swt.layout.FormAttachment(0, 216);
		fd_btnNewButton.left = new org.eclipse.swt.layout.FormAttachment(0, 10);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setText("BTS SLAM 1");
		
		btnBtsSlam = new Button(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_btnBtsSlam = new org.eclipse.swt.layout.FormData();
		fd_btnBtsSlam.right = new org.eclipse.swt.layout.FormAttachment(0, 115);
		fd_btnBtsSlam.top = new org.eclipse.swt.layout.FormAttachment(0, 264);
		fd_btnBtsSlam.left = new org.eclipse.swt.layout.FormAttachment(0, 10);
		btnBtsSlam.setLayoutData(fd_btnBtsSlam);
		btnBtsSlam.setText("BTS SLAM 2");
		
		btnTerminaleStid = new Button(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_btnTerminaleStid = new org.eclipse.swt.layout.FormData();
		fd_btnTerminaleStid.right = new org.eclipse.swt.layout.FormAttachment(0, 141);
		fd_btnTerminaleStid.top = new org.eclipse.swt.layout.FormAttachment(0, 305);
		fd_btnTerminaleStid.left = new org.eclipse.swt.layout.FormAttachment(0, 10);
		btnTerminaleStid.setLayoutData(fd_btnTerminaleStid);
		btnTerminaleStid.setText("Terminale STI2D");
		
		Label lblBonjour = new Label(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_lblBonjour = new org.eclipse.swt.layout.FormData();
		fd_lblBonjour.right = new FormAttachment(0, 449);
		fd_lblBonjour.top = new org.eclipse.swt.layout.FormAttachment(0, 13);
		fd_lblBonjour.left = new org.eclipse.swt.layout.FormAttachment(0, 380);
		lblBonjour.setLayoutData(fd_lblBonjour);
		lblBonjour.setText("Bonjour");
		
		Label lblVosClasses = new Label(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_lblVosClasses = new org.eclipse.swt.layout.FormData();
		fd_lblVosClasses.right = new org.eclipse.swt.layout.FormAttachment(0, 115);
		fd_lblVosClasses.top = new org.eclipse.swt.layout.FormAttachment(0, 124);
		fd_lblVosClasses.left = new org.eclipse.swt.layout.FormAttachment(0, 10);
		lblVosClasses.setLayoutData(fd_lblVosClasses);
		lblVosClasses.setText("Vos Classes:");
		
		tableMardi = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_tableMardi = new FormData();
		fd_tableMardi.bottom = new FormAttachment(100, -41);
		tableMardi.setLayoutData(fd_tableMardi);
		tableMardi.setHeaderVisible(true);
		tableMardi.setLinesVisible(true);
		
		tableMercredi = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_tableMardi.right = new FormAttachment(tableMercredi, -6);
		FormData fd_tableMercredi = new FormData();
		fd_tableMercredi.bottom = new FormAttachment(100, -41);
		fd_tableMercredi.left = new FormAttachment(0, 542);
		tableMercredi.setLayoutData(fd_tableMercredi);
		tableMercredi.setHeaderVisible(true);
		tableMercredi.setLinesVisible(true);
		
		tableLundi = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_tableMardi.left = new FormAttachment(0, 400);
		FormData fd_tableLundi = new FormData();
		fd_tableLundi.bottom = new FormAttachment(100, -41);
		fd_tableLundi.right = new FormAttachment(tableMardi, -6);
		fd_tableLundi.left = new FormAttachment(btnTerminaleStid, 117);
		tableLundi.setLayoutData(fd_tableLundi);
		tableLundi.setHeaderVisible(true);
		tableLundi.setLinesVisible(true);
		
		tableJeudi = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_tableMercredi.right = new FormAttachment(100, -366);
		FormData fd_tableJeudi = new FormData();
		fd_tableJeudi.left = new FormAttachment(tableMercredi, 6);
		fd_tableJeudi.bottom = new FormAttachment(tableMardi, 0, SWT.BOTTOM);
		fd_tableJeudi.top = new FormAttachment(tableMardi, 0, SWT.TOP);
		tableJeudi.setLayoutData(fd_tableJeudi);
		tableJeudi.setHeaderVisible(true);
		tableJeudi.setLinesVisible(true);
		
		tableVendredi = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_tableJeudi.right = new FormAttachment(100, -224);
		FormData fd_tableVendredi = new FormData();
		fd_tableVendredi.top = new FormAttachment(tableMardi, 0, SWT.TOP);
		fd_tableVendredi.left = new FormAttachment(tableJeudi, 6);
		fd_tableVendredi.bottom = new FormAttachment(100, -41);
		fd_tableVendredi.right = new FormAttachment(100, -82);
		tableVendredi.setLayoutData(fd_tableVendredi);
		tableVendredi.setHeaderVisible(true);
		tableVendredi.setLinesVisible(true);
		
		Label lblh = new Label(shell, SWT.NONE);
		FormData fd_lblh = new FormData();
		fd_lblh.right = new FormAttachment(tableLundi, -6);
		lblh.setLayoutData(fd_lblh);
		lblh.setText("8h");
		
		Label lblh_1 = new Label(shell, SWT.NONE);
		fd_lblh.bottom = new FormAttachment(lblh_1, -8);
		FormData fd_lblh_1 = new FormData();
		fd_lblh_1.right = new FormAttachment(tableLundi, -6);
		lblh_1.setLayoutData(fd_lblh_1);
		lblh_1.setText("9h");
		
		Label lblh_2 = new Label(shell, SWT.NONE);
		fd_lblh_1.bottom = new FormAttachment(lblh_2, -6);
		FormData fd_lblh_2 = new FormData();
		fd_lblh_2.right = new FormAttachment(tableLundi, -6);
		fd_lblh_2.top = new FormAttachment(btnNewButton, 0, SWT.TOP);
		lblh_2.setLayoutData(fd_lblh_2);
		lblh_2.setText("10h");
		
		Label lblh_3 = new Label(shell, SWT.NONE);
		FormData fd_lblh_3 = new FormData();
		fd_lblh_3.right = new FormAttachment(tableLundi, -6);
		fd_lblh_3.top = new FormAttachment(lblh_2, 6);
		lblh_3.setLayoutData(fd_lblh_3);
		lblh_3.setText("11h");
		
		Label lblh_4 = new Label(shell, SWT.NONE);
		FormData fd_lblh_4 = new FormData();
		fd_lblh_4.right = new FormAttachment(tableLundi, -7);
		fd_lblh_4.bottom = new FormAttachment(btnBtsSlam, 0, SWT.BOTTOM);
		lblh_4.setLayoutData(fd_lblh_4);
		lblh_4.setText("12h");
		
		Label lblh_5 = new Label(shell, SWT.NONE);
		FormData fd_lblh_5 = new FormData();
		fd_lblh_5.left = new FormAttachment(lblh_2, 0, SWT.LEFT);
		lblh_5.setLayoutData(fd_lblh_5);
		lblh_5.setText("14h");
		
		Label lblh_6 = new Label(shell, SWT.NONE);
		fd_lblh_5.bottom = new FormAttachment(lblh_6, -6);
		FormData fd_lblh_6 = new FormData();
		fd_lblh_6.left = new FormAttachment(lblh_2, 0, SWT.LEFT);
		lblh_6.setLayoutData(fd_lblh_6);
		lblh_6.setText("15h");
		
		Label lblh_7 = new Label(shell, SWT.NONE);
		fd_lblh_6.bottom = new FormAttachment(lblh_7, -6);
		FormData fd_lblh_7 = new FormData();
		fd_lblh_7.right = new FormAttachment(tableLundi, -6);
		fd_lblh_7.top = new FormAttachment(0, 386);
		lblh_7.setLayoutData(fd_lblh_7);
		lblh_7.setText("16h");
		
		Label lblh_8 = new Label(shell, SWT.NONE);
		FormData fd_lblh_8 = new FormData();
		fd_lblh_8.right = new FormAttachment(tableLundi, -6);
		fd_lblh_8.top = new FormAttachment(lblh_7, 6);
		lblh_8.setLayoutData(fd_lblh_8);
		lblh_8.setText("17h");
		
		Label lblLundi = new Label(shell, SWT.NONE);
		fd_tableLundi.top = new FormAttachment(lblLundi, 10);
		lblLundi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblLundi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		FormData fd_lblLundi = new FormData();
		fd_lblLundi.bottom = new FormAttachment(100, -400);
		
		fd_lblLundi.left = new FormAttachment(0, 297);
		lblLundi.setLayoutData(fd_lblLundi);
		lblLundi.setText("Lundi");
		
		Label lblMardi = new Label(shell, SWT.NONE);
		fd_tableMardi.top = new FormAttachment(lblMardi, 10);
		lblMardi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblMardi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		FormData fd_lblMardi = new FormData();
		fd_lblMardi.top = new FormAttachment(lblLundi, 0, SWT.TOP);
		lblMardi.setLayoutData(fd_lblMardi);
		lblMardi.setText("Mardi");
		
		Label lblMercredi = new Label(shell, SWT.NONE);
		fd_lblMardi.right = new FormAttachment(100, -550);
		fd_tableMercredi.top = new FormAttachment(lblMercredi, 10);
		lblMercredi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblMercredi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		FormData fd_lblMercredi = new FormData();
		fd_lblMercredi.top = new FormAttachment(lblLundi, 0, SWT.TOP);
		fd_lblMercredi.left = new FormAttachment(lblMardi, 76);
		lblMercredi.setLayoutData(fd_lblMercredi);
		lblMercredi.setText("Mercredi");
		
		Label lblJeudi = new Label(shell, SWT.NONE);
		lblJeudi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblJeudi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		FormData fd_lblJeudi = new FormData();
		fd_lblJeudi.top = new FormAttachment(lblLundi, 0, SWT.TOP);
		lblJeudi.setLayoutData(fd_lblJeudi);
		lblJeudi.setText("Jeudi");
		
		Label lblVendredi = new Label(shell, SWT.NONE);
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
		
		Database db = new Database();
		Connection cnx = db.DbConnexion();
		String requete = "Select * from utilisateur inner join planning on utilisateur.id = id_professeur inner join grille_horaire on id_grille = grille_horaire.id where identifiant = "+Globidentifiant;
		ResultSet resultat = db.Request(cnx, requete);
		while(resultat.next()) {
			
		}

	}
}

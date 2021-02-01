package appli;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.ProgressBar;

public class motif
{

	protected Shell shell;
	private Table table;


	public static void main(String[] args)
	{
		try
		{
			motif window = new motif();
			window.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public void open()
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

	protected void createContents()
	{
		shell = new Shell();
		shell.setSize(988, 530);
		shell.setText("SWT Application");

		Label lblAjouterUnMotif = new Label(shell, SWT.NONE);
		lblAjouterUnMotif.setFont(SWTResourceManager.getFont("Comic Sans MS", 14, SWT.NORMAL));
		lblAjouterUnMotif.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblAjouterUnMotif.setBounds(10, 10, 228, 50);
		lblAjouterUnMotif.setText("Ajouter un motif");

		Label lblAjouterUnMotif_1 = new Label(shell, SWT.NONE);
		lblAjouterUnMotif_1.setFont(SWTResourceManager.getFont("Comic Sans MS", 12, SWT.NORMAL));
		lblAjouterUnMotif_1.setBounds(352, 53, 203, 33);
		lblAjouterUnMotif_1.setText("Ajouter un motif");

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(274, 164, 381, 119);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn.setResizable(false);
		tblclmnNewColumn.setWidth(199);
		tblclmnNewColumn.setText("               El\u00E8ve");

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(182);
		tblclmnNewColumn_1.setText("     NAKHIL Amine");

		TableItem Type = new TableItem(table, SWT.NONE);
		Type.setText("              Type");

		TableItem Commentaire = new TableItem(table, SWT.NONE);
		Commentaire.setText("         Commentaire");

		Button btnValider = new Button(shell, SWT.NONE);
		btnValider.setBounds(429, 404, 105, 35);
		btnValider.setText("Valider");

		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"Maladie", "Exclusionaisons perssos"});
		combo.setBounds(475, 192, 180, 33);
		combo.setText("Maladie\r\n");

		ProgressBar progressBar = new ProgressBar(shell, SWT.NONE);
		progressBar.setBounds(-46, 356, 260, 26);

	}
}package appli;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.ProgressBar;

public class kleves
{

	protected Shell shell;
	private Table table;
	private Table table_1;
	private Table table_2;
	private Table table_3;


	public static void main(String[] args)
	{
		try
		{
			Eleves window = new Eleves();
			window.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public void open()
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


	protected void createContents()
	{
		shell = new Shell();
		shell.setSize(646, 376);
		shell.setText("SWT Application");

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.setText("Accueil");

		new MenuItem(menu, SWT.SEPARATOR);

		Label Classe = new Label(shell, SWT.NONE);
		Classe.setBounds(10, 59, 40, 16);
		Classe.setText("Classe :");

		Label lblBonjour_1 = new Label(shell, SWT.NONE);
		lblBonjour_1.setText("Bonjour ");
		lblBonjour_1.setBounds(271, 10, 46, 16);

		Label nomProfesseur = new Label(shell, SWT.NONE);
		nomProfesseur.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		nomProfesseur.setText("Bernard");
		nomProfesseur.setBounds(317, 10, 56, 16);

		Label libelleClasse = new Label(shell, SWT.NONE);
		libelleClasse.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		libelleClasse.setBounds(56, 59, 56, 16);
		libelleClasse.setText("SLAM 2");

		Label Cours = new Label(shell, SWT.NONE);
		Cours.setText("Cours :");
		Cours.setBounds(10, 79, 40, 16);

		Label lblInformatique = new Label(shell, SWT.NONE);
		lblInformatique.setText("Informatique");
		lblInformatique.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblInformatique.setBounds(56, 79, 91, 16);

		Label HorairesPlanning = new Label(shell, SWT.NONE);
		HorairesPlanning.setText("Horaires :");
		HorairesPlanning.setBounds(10, 101, 56, 16);

		Label idPlanning = new Label(shell, SWT.NONE);
		idPlanning.setText("13h - 15h");
		idPlanning.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		idPlanning.setBounds(66, 101, 91, 16);

		Button btnAjouterUneAbsence = new Button(shell, SWT.NONE);
		btnAjouterUneAbsence.setBounds(23, 180, 116, 21);
		btnAjouterUneAbsence.setText("Ajouter un retard");

		Button btnAjouterUneAbsence_1 = new Button(shell, SWT.NONE);
		btnAjouterUneAbsence_1.setText("Ajouter une absence");
		btnAjouterUneAbsence_1.setBounds(23, 150, 116, 21);

		Button btnAjouterUneSanction = new Button(shell, SWT.NONE);
		btnAjouterUneSanction.setText("Ajouter une sanction");
		btnAjouterUneSanction.setBounds(23, 213, 116, 21);

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(173, 59, 103, 225);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn eleve = new TableColumn(table, SWT.NONE);
		eleve.setWidth(100);
		eleve.setText("Eleve");

		TableItem idEleve = new TableItem(table, SWT.NONE);
		idEleve.setContentType("text/APPLICATION_ATOM_XML");
		idEleve.setText("Quentin Lignani");

		TableItem idEleve2 = new TableItem(table, SWT.NONE);
		idEleve.setContentType("text/APPLICATION_ATOM_XML");

		idEleve2.setText("Loic GUO");

		TableItem idEleve3 = new TableItem(table, SWT.NONE);
		idEleve3.setText("Amine Nakhil");

		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setBounds(390, 59, 103, 225);

		TableColumn Retard = new TableColumn(table_1, SWT.NONE);
		Retard.setWidth(100);
		Retard.setText("Retard");

		table_2 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setLinesVisible(true);
		table_2.setHeaderVisible(true);
		table_2.setBounds(285, 59, 103, 225);

		TableColumn Absence = new TableColumn(table_2, SWT.NONE);
		Absence.setWidth(100);
		Absence.setText("Absence");

		table_3 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_3.setLinesVisible(true);
		table_3.setHeaderVisible(true);
		table_3.setBounds(495, 59, 103, 225);

		TableColumn Sanction = new TableColumn(table_3, SWT.NONE);
		Sanction.setWidth(100);
		Sanction.setText("Sanction");

	}
}
package appli;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.ProgressBar;

public class kleves
{

	protected Shell shell;
	private Table table;
	private Table table_1;
	private Table table_2;
	private Table table_3;


	public static void main(String[] args)
	{
		try
		{
			Eleves window = new Eleves();
			window.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public void open()
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


	protected void createContents()
	{
		shell = new Shell();
		shell.setSize(646, 376);
		shell.setText("SWT Application");

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.setText("Accueil");

		new MenuItem(menu, SWT.SEPARATOR);

		Label Classe = new Label(shell, SWT.NONE);
		Classe.setBounds(10, 59, 40, 16);
		Classe.setText("Classe :");

		Label lblBonjour_1 = new Label(shell, SWT.NONE);
		lblBonjour_1.setText("Bonjour ");
		lblBonjour_1.setBounds(271, 10, 46, 16);

		Label nomProfesseur = new Label(shell, SWT.NONE);
		nomProfesseur.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		nomProfesseur.setText("Bernard");
		nomProfesseur.setBounds(317, 10, 56, 16);

		Label libelleClasse = new Label(shell, SWT.NONE);
		libelleClasse.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		libelleClasse.setBounds(56, 59, 56, 16);
		libelleClasse.setText("SLAM 2");

		Label Cours = new Label(shell, SWT.NONE);
		Cours.setText("Cours :");
		Cours.setBounds(10, 79, 40, 16);

		Label lblInformatique = new Label(shell, SWT.NONE);
		lblInformatique.setText("Informatique");
		lblInformatique.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblInformatique.setBounds(56, 79, 91, 16);

		Label HorairesPlanning = new Label(shell, SWT.NONE);
		HorairesPlanning.setText("Horaires :");
		HorairesPlanning.setBounds(10, 101, 56, 16);

		Label idPlanning = new Label(shell, SWT.NONE);
		idPlanning.setText("13h - 15h");
		idPlanning.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		idPlanning.setBounds(66, 101, 91, 16);

		Button btnAjouterUneAbsence = new Button(shell, SWT.NONE);
		btnAjouterUneAbsence.setBounds(23, 180, 116, 21);
		btnAjouterUneAbsence.setText("Ajouter un retard");

		Button btnAjouterUneAbsence_1 = new Button(shell, SWT.NONE);
		btnAjouterUneAbsence_1.setText("Ajouter une absence");
		btnAjouterUneAbsence_1.setBounds(23, 150, 116, 21);

		Button btnAjouterUneSanction = new Button(shell, SWT.NONE);
		btnAjouterUneSanction.setText("Ajouter une sanction");
		btnAjouterUneSanction.setBounds(23, 213, 116, 21);

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(173, 59, 103, 225);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn eleve = new TableColumn(table, SWT.NONE);
		eleve.setWidth(100);
		eleve.setText("Eleve");

		TableItem idEleve = new TableItem(table, SWT.NONE);
		idEleve.setContentType("text/APPLICATION_ATOM_XML");
		idEleve.setText("Quentin Lignani");

		TableItem idEleve2 = new TableItem(table, SWT.NONE);
		idEleve.setContentType("text/APPLICATION_ATOM_XML");

		idEleve2.setText("Loic GUO");

		TableItem idEleve3 = new TableItem(table, SWT.NONE);
		idEleve3.setText("Amine Nakhil");

		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setBounds(390, 59, 103, 225);

		TableColumn Retard = new TableColumn(table_1, SWT.NONE);
		Retard.setWidth(100);
		Retard.setText("Retard");

		table_2 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setLinesVisible(true);
		table_2.setHeaderVisible(true);
		table_2.setBounds(285, 59, 103, 225);

		TableColumn Absence = new TableColumn(table_2, SWT.NONE);
		Absence.setWidth(100);
		Absence.setText("Absence");

		table_3 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_3.setLinesVisible(true);
		table_3.setHeaderVisible(true);
		table_3.setBounds(495, 59, 103, 225);

		TableColumn Sanction = new TableColumn(table_3, SWT.NONE);
		Sanction.setWidth(100);
		Sanction.setText("Sanction");

	}
}

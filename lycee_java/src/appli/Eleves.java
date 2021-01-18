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

public class Eleves {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Eleves window = new Eleves();
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
		
		Label sexe = new Label(shell, SWT.NONE);
		sexe.setBounds(285, 10, 56, 16);
		sexe.setText("Monsieur");
		
		Label lblBonjour_1 = new Label(shell, SWT.NONE);
		lblBonjour_1.setText("Bonjour ");
		lblBonjour_1.setBounds(238, 10, 46, 16);
		
		Label nomProfesseur = new Label(shell, SWT.NONE);
		nomProfesseur.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		nomProfesseur.setText("Bernard");
		nomProfesseur.setBounds(341, 10, 56, 16);
		
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
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(169, 56, 408, 237);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn libelleEleves = new TableColumn(table, SWT.CENTER);
		libelleEleves.setWidth(100);
		libelleEleves.setText("El\u00E8ves");
		
		TableColumn libelleAbsence = new TableColumn(table, SWT.CENTER);
		libelleAbsence.setWidth(100);
		libelleAbsence.setText("Absence");
		
		TableColumn libelleRetard = new TableColumn(table, SWT.CENTER);
		libelleRetard.setWidth(100);
		libelleRetard.setText("Retard");
		
		TableColumn libelleSanction = new TableColumn(table, SWT.CENTER);
		libelleSanction.setWidth(100);
		libelleSanction.setText("Sanction");
		
		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		
		TableItem idAbsence1 = new TableItem(table, SWT.NONE);
		idAbsence1.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		idAbsence1.setText(new String[] {"LIGNANI Quentin", "X"});
		
		TableItem idAbsence2 = new TableItem(table, 0);
		idAbsence2.setText(new String[] {"GUIO Lo\u00EFc", "", "X"});
		idAbsence2.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		
		TableItem idAbsence3 = new TableItem(table, 0);
		idAbsence3.setText(new String[] {"NAKHIL Amine", "", "", "X"});
		idAbsence3.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		
		Button btnAjouterUneAbsence = new Button(shell, SWT.NONE);
		btnAjouterUneAbsence.setBounds(23, 180, 116, 21);
		btnAjouterUneAbsence.setText("Ajouter un retard");
		
		Button btnAjouterUneAbsence_1 = new Button(shell, SWT.NONE);
		btnAjouterUneAbsence_1.setText("Ajouter une absence");
		btnAjouterUneAbsence_1.setBounds(23, 150, 116, 21);
		
		Button btnAjouterUneSanction = new Button(shell, SWT.NONE);
		btnAjouterUneSanction.setText("Ajouter une sanction");
		btnAjouterUneSanction.setBounds(23, 213, 116, 21);

	}
}

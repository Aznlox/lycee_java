package appli;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;

public class Admin_menu {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
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
		shell.setSize(366, 449);
		shell.setText("SWT Application");
		
		Button btnAjouterProf = new Button(shell, SWT.NONE);
		btnAjouterProf.setBounds(80, 71, 184, 35);
		btnAjouterProf.setText("Ajouter un professeur");
		
		Label lblMenu = new Label(shell, SWT.NONE);
		lblMenu.setBounds(150, 21, 81, 25);
		lblMenu.setText("Menu");
		
		Button btnAjouterUneClasse = new Button(shell, SWT.NONE);
		btnAjouterUneClasse.setText("Ajouter une classe");
		btnAjouterUneClasse.setBounds(80, 126, 184, 35);
		
		Button btnAjouterDeslves = new Button(shell, SWT.NONE);
		btnAjouterDeslves.setText("Ajouter des \u00E9l\u00E8ves");
		btnAjouterDeslves.setBounds(80, 182, 184, 35);
		
		Button btnModifierLePlanning = new Button(shell, SWT.NONE);
		btnModifierLePlanning.setBounds(80, 237, 184, 35);
		btnModifierLePlanning.setText("Modifier le planning");
		
		Button btnGestionVieScolaire = new Button(shell, SWT.NONE);
		btnGestionVieScolaire.setBounds(80, 293, 184, 35);
		btnGestionVieScolaire.setText("Gestion vie scolaire");

	}
}

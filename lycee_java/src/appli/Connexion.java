package appli;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import controller.Controller_connexion;

public class Connexion {

	protected Shell shell;
	private Text textIdentifiant;
	private Text textMotdePasse;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Connexion window = new Connexion();
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
		shell.setSize(494, 331);
		shell.setText("SWT Application");
		//Identifiant 
		textIdentifiant = new Text(shell, SWT.BORDER);
		textIdentifiant.setBounds(145, 103, 215, 19);
		
		textMotdePasse = new Text(shell, SWT.BORDER);
		textMotdePasse.setBounds(145, 144, 215, 19);
		
		Button btnJeMinscris = new Button(shell, SWT.NONE);
		btnJeMinscris.setFont(SWTResourceManager.getFont("Segoe Print", 9, SWT.BOLD));
		
		btnJeMinscris.setBounds(195, 184, 119, 21);
		btnJeMinscris.setText("Je me connecte");
		
		Label lblF = new Label(shell, SWT.NONE);
		lblF.setAlignment(SWT.CENTER);
		lblF.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblF.setBounds(179, 63, 135, 16);
		lblF.setText("Connexion");
		
		Label Identifiant = new Label(shell, SWT.NONE);
		Identifiant.setBounds(83, 103, 56, 16);
		Identifiant.setText("Identifiant");
		
		Label MotdePasse = new Label(shell, SWT.NONE);
		MotdePasse.setBounds(67, 144, 72, 16);
		MotdePasse.setText("Mot de passe");
		
		btnJeMinscris.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Controller_connexion connexion = new Controller_connexion();
					connexion.Connexion(textIdentifiant.getText(), textMotdePasse.getText(), shell);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});

	}
}

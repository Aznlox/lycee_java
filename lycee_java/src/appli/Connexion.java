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

public class Connexion
{

	protected Shell shell;
	private Text textIdentifiant;
	private Text textMotdePasse;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			Connexion window = new Connexion();
			window.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents()
	{
		shell = new Shell();
		shell.setSize(494, 331);
		shell.setText("SWT Application");
		//Identifiant
		textIdentifiant = new Text(shell, SWT.BORDER);
		textIdentifiant.setBounds(145, 103, 215, 35);

		textMotdePasse = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		textMotdePasse.setBounds(145, 144, 215, 34);

		Button btnJeMinscris = new Button(shell, SWT.NONE);
		btnJeMinscris.setFont(SWTResourceManager.getFont("Segoe Print", 9, SWT.BOLD));

		btnJeMinscris.setBounds(179, 184, 151, 35);
		btnJeMinscris.setText("Je me connecte");

		Label lblF = new Label(shell, SWT.NONE);
		lblF.setAlignment(SWT.CENTER);
		lblF.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblF.setBounds(179, 63, 135, 34);
		lblF.setText("Connexion");

		Label Identifiant = new Label(shell, SWT.NONE);
		Identifiant.setBounds(41, 103, 91, 35);
		Identifiant.setText("Identifiant");

		Label MotdePasse = new Label(shell, SWT.NONE);
		MotdePasse.setBounds(20, 144, 119, 34);
		MotdePasse.setText("Mot de passe");
		
		Label lblErreur = new Label(shell, SWT.NONE);
		lblErreur.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblErreur.setBounds(68, 225, 345, 25);
		lblErreur.setText("Erreur dans l'identifiant ou le mot de passe");
		lblErreur.setVisible(false);

		btnJeMinscris.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Controller_connexion connexion = new Controller_connexion();
					boolean message = connexion.Connexion(textIdentifiant.getText(), textMotdePasse.getText(), shell);

					lblErreur.setVisible(message);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		});

	}
}

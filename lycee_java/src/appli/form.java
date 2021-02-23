package appli;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Tree;

import com.dbconnexion.Database;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.browser.Browser;
import org.eclipse.wb.swt.SWTResourceManager;

public class form { //Classe
//Variables
	protected Shell Form;
	private Text Justification;
	private String nom;
	private String type;
	private String date;
	private String justification;

	/**
	 * Launch the application.
	 * @param args
	 */


	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		Form.open();
		Form.layout();
		while (!Form.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		Form = new Shell();
		Form.setSize(583, 642);
		Form.setText("Ajouter");
		
		Justification = new Text(Form, SWT.BORDER | SWT.V_SCROLL);
		Justification.setBounds(161, 223, 200, 69);
		Justification.setText(justification);
		
		Button btnNewButton = new Button(Form, SWT.NONE);
		btnNewButton.setBounds(161, 310, 200, 35);
		btnNewButton.setText("Ajouter");
		
		
		
		Combo Type = new Combo(Form, SWT.NONE);
		Type.setToolTipText("");
		Type.setItems(new String[] {"Retard", "Absence", "Sanction"});
		Type.setBounds(161, 131, 200, 33);
		Type.select(0);
		
		Label lblNom = new Label(Form, SWT.NONE);
		lblNom.setBounds(99, 82, 56, 16);
		lblNom.setText("nom");
		
		Label lblType = new Label(Form, SWT.NONE);
		lblType.setBounds(99, 131, 56, 16);
		lblType.setText("type");
		
		Label lblDate = new Label(Form, SWT.NONE);
		lblDate.setBounds(99, 178, 56, 16);
		lblDate.setText("date");
		
		Label lblJustification = new Label(Form, SWT.NONE);
		lblJustification.setBounds(92, 223, 63, 16);
		lblJustification.setText("justification");
		
		DateTime Date = new DateTime(Form, SWT.BORDER);
		Date.setBounds(162, 178, 81, 21);
		lblDate.setText(date);
		
		Combo Nom = new Combo(Form, SWT.NONE);
		Nom.setBounds(161, 81, 200, 20);
		lblNom.setText(nom);
		
		Database db = new Database();
		Connection cnx = db.DbConnexion();
		

		Justification.setText(justification);
		
		Label lblAjouterUneAbsencesanctionretard = new Label(Form, SWT.NONE);
		lblAjouterUneAbsencesanctionretard.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblAjouterUneAbsencesanctionretard.setBounds(148, 24, 266, 16);
		lblAjouterUneAbsencesanctionretard.setText("Ajouter une Absence/Sanction/Retard");

		btnNewButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
			
				String request = "INSERT INTO vie_scolaire (id_eleve, type, date, justification) VALUES ()";
				
			}
		});

	}
}

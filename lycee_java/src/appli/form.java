package appli;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.browser.Browser;

public class form { //Classe
//Variables
	protected Shell Form;
	private Text Nom;
	private Text Justification;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			form window = new form();
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
		
		Nom = new Text(Form, SWT.BORDER);
		Nom.setBounds(161, 72, 200, 31);
		
		Justification = new Text(Form, SWT.BORDER | SWT.V_SCROLL);
		Justification.setBounds(161, 223, 200, 69);
		
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
		lblNom.setText("Nom");
		
		Label lblType = new Label(Form, SWT.NONE);
		lblType.setBounds(99, 131, 56, 16);
		lblType.setText("Type");
		
		Label lblDate = new Label(Form, SWT.NONE);
		lblDate.setBounds(99, 178, 56, 16);
		lblDate.setText("Date");
		
		Label lblJustification = new Label(Form, SWT.NONE);
		lblJustification.setBounds(92, 223, 63, 16);
		lblJustification.setText("Justification");
		
		DateTime Date = new DateTime(Form, SWT.BORDER);
		Date.setBounds(162, 178, 81, 21);

	}
}

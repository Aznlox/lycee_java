package appli;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;

public class Admin_Eleves {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Admin_Eleves window = new Admin_Eleves();
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
		shell.setSize(600, 371);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(370, 57, 207, 243);
		
		Label libelleEleve = new Label(composite, SWT.NONE);
		libelleEleve.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		libelleEleve.setBounds(74, 52, 75, 20);
		libelleEleve.setText("LOIC GUO");
		
		Label libelleClasse = new Label(composite, SWT.NONE);
		libelleClasse.setText("SLAM 2");
		libelleClasse.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		libelleClasse.setBounds(84, 78, 65, 20);
		
		Label AbsenceEleve = new Label(composite, SWT.NONE);
		AbsenceEleve.setText("1");
		AbsenceEleve.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		AbsenceEleve.setBounds(104, 108, 65, 20);
		
		Label RetardEleve = new Label(composite, SWT.NONE);
		RetardEleve.setText("178");
		RetardEleve.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		RetardEleve.setBounds(104, 134, 65, 20);
		
		Label Absences = new Label(composite, SWT.NONE);
		Absences.setText("Absences");
		Absences.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		Absences.setBounds(33, 108, 65, 20);
		
		Label Retards = new Label(composite, SWT.NONE);
		Retards.setText("Retards");
		Retards.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		Retards.setBounds(33, 134, 65, 20);

	}
}

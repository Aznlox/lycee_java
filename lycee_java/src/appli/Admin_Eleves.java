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
		
		Label lblLoicGuo = new Label(composite, SWT.NONE);
		lblLoicGuo.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblLoicGuo.setBounds(70, 80, 75, 20);
		lblLoicGuo.setText("LOIC GUO");
		
		Label lblSlam = new Label(composite, SWT.NONE);
		lblSlam.setText("SLAM 2");
		lblSlam.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSlam.setBounds(80, 106, 65, 20);

	}
}

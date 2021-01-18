package ;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
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

public class index {

	protected Shell shell;
	private Button btnBtsSlam;
	private Button btnTerminaleStid;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			test window = new test();
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
		shell.setSize(912, 511);
		shell.setText("SWT Application");
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(713, 23, 125, 33);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 216, 105, 35);
		btnNewButton.setText("BTS SLAM 1");
		
		btnBtsSlam = new Button(shell, SWT.NONE);
		btnBtsSlam.setBounds(10, 264, 105, 35);
		btnBtsSlam.setText("BTS SLAM 2");
		
		btnTerminaleStid = new Button(shell, SWT.NONE);
		btnTerminaleStid.setBounds(10, 305, 131, 35);
		btnTerminaleStid.setText("Terminale STI2D");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		table.setBounds(157, 124, 696, 278);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnLundi = new TableColumn(table, SWT.NONE);
		tblclmnLundi.setWidth(108);
		tblclmnLundi.setText("Lundi");
		
		TableColumn tblclmnMardi = new TableColumn(table, SWT.NONE);
		tblclmnMardi.setWidth(158);
		tblclmnMardi.setText("Mardi");
		
		TableColumn tblclmnMercredi = new TableColumn(table, SWT.NONE);
		tblclmnMercredi.setWidth(160);
		tblclmnMercredi.setText("Mercredi");
		
		TableColumn tblclmnJeudi = new TableColumn(table, SWT.NONE);
		tblclmnJeudi.setWidth(159);
		tblclmnJeudi.setText("Jeudi");
		
		TableColumn tblclmnVendredi = new TableColumn(table, SWT.NONE);
		tblclmnVendredi.setWidth(100);
		tblclmnVendredi.setText("Vendredi");
		
		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		
		Label lblBonjourBernard = new Label(shell, SWT.NONE);
		lblBonjourBernard.setBounds(380, 13, 131, 25);
		lblBonjourBernard.setText("Bonjour Bernard");
		
		Label lblPlanning = new Label(shell, SWT.NONE);
		lblPlanning.setBounds(10, 13, 81, 25);
		lblPlanning.setText("Planning");
		
		Label lblVosClasses = new Label(shell, SWT.NONE);
		lblVosClasses.setBounds(10, 124, 105, 25);
		lblVosClasses.setText("Vos Classes:");
		
		Label lblInformatique = new Label(shell, SWT.NONE);
		lblInformatique.setAlignment(SWT.CENTER);
		lblInformatique.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblInformatique.setBounds(157, 187, 112, 64);
		lblInformatique.setText("Informatique Slam 2");
		
		Button btnInformatiqueSlam = new Button(shell, SWT.NONE);
		btnInformatiqueSlam.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		btnInformatiqueSlam.setBounds(426, 275, 160, 83);
		btnInformatiqueSlam.setText("PPE SLAM1");
		
		Button btnAlgoSlam = new Button(shell, SWT.NONE);
		btnAlgoSlam.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		btnAlgoSlam.setText("Algo SLAM 2");
		btnAlgoSlam.setBounds(157, 187, 112, 64);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(426, 182, 160, 64);
		btnNewButton_1.setText("Enseignement sp\u00E9");

	}
}

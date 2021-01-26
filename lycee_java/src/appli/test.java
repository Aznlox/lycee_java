package appli;

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
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.custom.CBanner;

public class test 
{

	protected Shell shell;
	private Button btnBtsSlam;
	private Button btnTerminaleStid;
	private Table table_2;
	private Table table_3;
	private Table table;
	private Table table_1;
	private Table table_4;


	public static void main(String[] args) {
		try {
			test window = new test();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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


	protected void createContents() {
		shell = new Shell();
		shell.setSize(1066, 551);
		shell.setText("SWT Application");
		shell.setLayout(new org.eclipse.swt.layout.FormLayout());
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		org.eclipse.swt.layout.FormData fd_dateTime = new org.eclipse.swt.layout.FormData();
		fd_dateTime.top = new FormAttachment(0, 10);
		fd_dateTime.right = new FormAttachment(100, -10);
		dateTime.setLayoutData(fd_dateTime);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_btnNewButton = new org.eclipse.swt.layout.FormData();
		fd_btnNewButton.right = new org.eclipse.swt.layout.FormAttachment(0, 115);
		fd_btnNewButton.top = new org.eclipse.swt.layout.FormAttachment(0, 216);
		fd_btnNewButton.left = new org.eclipse.swt.layout.FormAttachment(0, 10);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setText("BTS SLAM 1");
		
		btnBtsSlam = new Button(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_btnBtsSlam = new org.eclipse.swt.layout.FormData();
		fd_btnBtsSlam.right = new org.eclipse.swt.layout.FormAttachment(0, 115);
		fd_btnBtsSlam.top = new org.eclipse.swt.layout.FormAttachment(0, 264);
		fd_btnBtsSlam.left = new org.eclipse.swt.layout.FormAttachment(0, 10);
		btnBtsSlam.setLayoutData(fd_btnBtsSlam);
		btnBtsSlam.setText("BTS SLAM 2");
		
		btnTerminaleStid = new Button(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_btnTerminaleStid = new org.eclipse.swt.layout.FormData();
		fd_btnTerminaleStid.right = new org.eclipse.swt.layout.FormAttachment(0, 141);
		fd_btnTerminaleStid.top = new org.eclipse.swt.layout.FormAttachment(0, 305);
		fd_btnTerminaleStid.left = new org.eclipse.swt.layout.FormAttachment(0, 10);
		btnTerminaleStid.setLayoutData(fd_btnTerminaleStid);
		btnTerminaleStid.setText("Terminale STI2D");
		
		Label lblBonjourBernard = new Label(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_lblBonjourBernard = new org.eclipse.swt.layout.FormData();
		fd_lblBonjourBernard.right = new org.eclipse.swt.layout.FormAttachment(0, 511);
		fd_lblBonjourBernard.top = new org.eclipse.swt.layout.FormAttachment(0, 13);
		fd_lblBonjourBernard.left = new org.eclipse.swt.layout.FormAttachment(0, 380);
		lblBonjourBernard.setLayoutData(fd_lblBonjourBernard);
		lblBonjourBernard.setText("Bonjour Bernard");
		
		Label lblVosClasses = new Label(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_lblVosClasses = new org.eclipse.swt.layout.FormData();
		fd_lblVosClasses.right = new org.eclipse.swt.layout.FormAttachment(0, 115);
		fd_lblVosClasses.top = new org.eclipse.swt.layout.FormAttachment(0, 124);
		fd_lblVosClasses.left = new org.eclipse.swt.layout.FormAttachment(0, 10);
		lblVosClasses.setLayoutData(fd_lblVosClasses);
		lblVosClasses.setText("Vos Classes:");
		
		Label label_3 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		org.eclipse.swt.layout.FormData fd_label_3 = new org.eclipse.swt.layout.FormData();
		fd_label_3.bottom = new org.eclipse.swt.layout.FormAttachment(0, 402);
		fd_label_3.right = new org.eclipse.swt.layout.FormAttachment(0, 723);
		fd_label_3.top = new org.eclipse.swt.layout.FormAttachment(0, 82);
		fd_label_3.left = new org.eclipse.swt.layout.FormAttachment(0, 723);
		label_3.setLayoutData(fd_label_3);
		
		table_2 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_table_2 = new FormData();
		fd_table_2.bottom = new FormAttachment(100, -39);
		table_2.setLayoutData(fd_table_2);
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);
		fd_table_2.right = new FormAttachment(100, -508);
		
		table_3 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_table_3 = new FormData();
		fd_table_3.bottom = new FormAttachment(100, -41);
		fd_table_3.left = new FormAttachment(table_2, 6);
		table_3.setLayoutData(fd_table_3);
		table_3.setHeaderVisible(true);
		table_3.setLinesVisible(true);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_table_2.left = new FormAttachment(table, 6);
		FormData fd_table = new FormData();
		fd_table.top = new FormAttachment(lblBonjourBernard, 67);
		fd_table.bottom = new FormAttachment(100, -41);
		fd_table.left = new FormAttachment(btnTerminaleStid, 117);
		fd_table.right = new FormAttachment(100, -650);
		table.setLayoutData(fd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_table_3.right = new FormAttachment(table_1, -6);
		FormData fd_table_1 = new FormData();
		fd_table_1.left = new FormAttachment(label_3, -26, SWT.LEFT);
		fd_table_1.top = new FormAttachment(0, 107);
		fd_table_1.bottom = new FormAttachment(100, -45);
		table_1.setLayoutData(fd_table_1);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		table_4 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_table_1.right = new FormAttachment(table_4, -6);
		FormData fd_table_4 = new FormData();
		fd_table_4.right = new FormAttachment(100, -69);
		fd_table_4.left = new FormAttachment(0, 839);
		fd_table_4.top = new FormAttachment(dateTime, 64);
		fd_table_4.bottom = new FormAttachment(100, -39);
		table_4.setLayoutData(fd_table_4);
		table_4.setHeaderVisible(true);
		table_4.setLinesVisible(true);
		
		Label lblh = new Label(shell, SWT.NONE);
		FormData fd_lblh = new FormData();
		fd_lblh.right = new FormAttachment(table, -6);
		lblh.setLayoutData(fd_lblh);
		lblh.setText("8h");
		
		Label lblh_1 = new Label(shell, SWT.NONE);
		fd_lblh.bottom = new FormAttachment(lblh_1, -8);
		FormData fd_lblh_1 = new FormData();
		fd_lblh_1.right = new FormAttachment(table, -6);
		lblh_1.setLayoutData(fd_lblh_1);
		lblh_1.setText("9h");
		
		Label lblh_2 = new Label(shell, SWT.NONE);
		fd_lblh_1.bottom = new FormAttachment(lblh_2, -6);
		FormData fd_lblh_2 = new FormData();
		fd_lblh_2.top = new FormAttachment(btnNewButton, 0, SWT.TOP);
		fd_lblh_2.right = new FormAttachment(table, -6);
		lblh_2.setLayoutData(fd_lblh_2);
		lblh_2.setText("10h");
		
		Label lblh_3 = new Label(shell, SWT.NONE);
		FormData fd_lblh_3 = new FormData();
		fd_lblh_3.top = new FormAttachment(lblh_2, 6);
		fd_lblh_3.right = new FormAttachment(table, -6);
		lblh_3.setLayoutData(fd_lblh_3);
		lblh_3.setText("11h");
		
		Label lblh_4 = new Label(shell, SWT.NONE);
		FormData fd_lblh_4 = new FormData();
		fd_lblh_4.bottom = new FormAttachment(btnBtsSlam, 0, SWT.BOTTOM);
		fd_lblh_4.right = new FormAttachment(table, -7);
		lblh_4.setLayoutData(fd_lblh_4);
		lblh_4.setText("12h");
		
		Label lblh_5 = new Label(shell, SWT.NONE);
		FormData fd_lblh_5 = new FormData();
		fd_lblh_5.left = new FormAttachment(lblh_2, 0, SWT.LEFT);
		lblh_5.setLayoutData(fd_lblh_5);
		lblh_5.setText("14h");
		
		Label lblh_6 = new Label(shell, SWT.NONE);
		fd_lblh_5.bottom = new FormAttachment(lblh_6, -6);
		FormData fd_lblh_6 = new FormData();
		fd_lblh_6.left = new FormAttachment(lblh_2, 0, SWT.LEFT);
		lblh_6.setLayoutData(fd_lblh_6);
		lblh_6.setText("15h");
		
		Label lblh_7 = new Label(shell, SWT.NONE);
		fd_lblh_6.bottom = new FormAttachment(lblh_7, -6);
		FormData fd_lblh_7 = new FormData();
		fd_lblh_7.top = new FormAttachment(0, 386);
		fd_lblh_7.right = new FormAttachment(table, -6);
		lblh_7.setLayoutData(fd_lblh_7);
		lblh_7.setText("16h");
		
		Label lblh_8 = new Label(shell, SWT.NONE);
		FormData fd_lblh_8 = new FormData();
		fd_lblh_8.top = new FormAttachment(lblh_7, 6);
		fd_lblh_8.right = new FormAttachment(table, -6);
		lblh_8.setLayoutData(fd_lblh_8);
		lblh_8.setText("17h");
		
		Label lblLundi = new Label(shell, SWT.NONE);
		lblLundi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblLundi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		FormData fd_lblLundi = new FormData();
		fd_lblLundi.bottom = new FormAttachment(table, -10);
		
		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		fd_lblLundi.left = new FormAttachment(0, 297);
		lblLundi.setLayoutData(fd_lblLundi);
		lblLundi.setText("Lundi");
		
		Label lblMardi = new Label(shell, SWT.NONE);
		lblMardi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		fd_table_2.top = new FormAttachment(lblMardi, 6);
		lblMardi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		FormData fd_lblMardi = new FormData();
		fd_lblMardi.bottom = new FormAttachment(100, -396);
		fd_lblMardi.left = new FormAttachment(lblLundi, 105);
		lblMardi.setLayoutData(fd_lblMardi);
		lblMardi.setText("Mardi");
		
		Label lblMercredi = new Label(shell, SWT.NONE);
		lblMercredi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblMercredi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		fd_table_3.top = new FormAttachment(lblMercredi, 10);
		FormData fd_lblMercredi = new FormData();
		fd_lblMercredi.top = new FormAttachment(lblLundi, 0, SWT.TOP);
		fd_lblMercredi.right = new FormAttachment(label_3, -78);
		lblMercredi.setLayoutData(fd_lblMercredi);
		lblMercredi.setText("Mercredi");
		
		Label lblJeudi = new Label(shell, SWT.NONE);
		lblJeudi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblJeudi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		FormData fd_lblJeudi = new FormData();
		fd_lblJeudi.top = new FormAttachment(lblLundi, 0, SWT.TOP);
		fd_lblJeudi.left = new FormAttachment(label_3, 18);
		lblJeudi.setLayoutData(fd_lblJeudi);
		lblJeudi.setText("Jeudi");
		
		Label lblVendredi = new Label(shell, SWT.NONE);
		lblVendredi.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblVendredi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		FormData fd_lblVendredi = new FormData();
		fd_lblVendredi.top = new FormAttachment(lblLundi, 0, SWT.TOP);
		fd_lblVendredi.left = new FormAttachment(lblJeudi, 77);
		lblVendredi.setLayoutData(fd_lblVendredi);
		lblVendredi.setText("Vendredi");
		
		CBanner banner = new CBanner(shell, SWT.NONE);
		FormData fd_banner = new FormData();
		fd_banner.bottom = new FormAttachment(100);
		fd_banner.right = new FormAttachment(table_2);
		banner.setLayoutData(fd_banner);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new FormData());

	}
}

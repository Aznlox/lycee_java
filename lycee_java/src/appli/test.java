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
		
		Label lblPlanning = new Label(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_lblPlanning = new org.eclipse.swt.layout.FormData();
		fd_lblPlanning.right = new org.eclipse.swt.layout.FormAttachment(0, 91);
		fd_lblPlanning.top = new org.eclipse.swt.layout.FormAttachment(0, 13);
		fd_lblPlanning.left = new org.eclipse.swt.layout.FormAttachment(0, 10);
		lblPlanning.setLayoutData(fd_lblPlanning);
		lblPlanning.setText("Planning");
		
		Label lblVosClasses = new Label(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_lblVosClasses = new org.eclipse.swt.layout.FormData();
		fd_lblVosClasses.right = new org.eclipse.swt.layout.FormAttachment(0, 115);
		fd_lblVosClasses.top = new org.eclipse.swt.layout.FormAttachment(0, 124);
		fd_lblVosClasses.left = new org.eclipse.swt.layout.FormAttachment(0, 10);
		lblVosClasses.setLayoutData(fd_lblVosClasses);
		lblVosClasses.setText("Vos Classes:");
		
		Button btnAlgoSlam = new Button(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_btnAlgoSlam = new org.eclipse.swt.layout.FormData();
		fd_btnAlgoSlam.top = new FormAttachment(0, 35);
		fd_btnAlgoSlam.bottom = new FormAttachment(lblVosClasses, -25);
		fd_btnAlgoSlam.left = new FormAttachment(lblPlanning, 22);
		fd_btnAlgoSlam.right = new FormAttachment(0, 225);
		btnAlgoSlam.setLayoutData(fd_btnAlgoSlam);
		btnAlgoSlam.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		btnAlgoSlam.setText("Algo SLAM 2");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_btnNewButton_1 = new org.eclipse.swt.layout.FormData();
		fd_btnNewButton_1.left = new FormAttachment(lblBonjourBernard, 6);
		fd_btnNewButton_1.bottom = new FormAttachment(0, 101);
		fd_btnNewButton_1.right = new FormAttachment(0, 653);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_1.setText("Enseignement");
		
		Label label_3 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		org.eclipse.swt.layout.FormData fd_label_3 = new org.eclipse.swt.layout.FormData();
		fd_label_3.bottom = new org.eclipse.swt.layout.FormAttachment(0, 402);
		fd_label_3.right = new org.eclipse.swt.layout.FormAttachment(0, 723);
		fd_label_3.top = new org.eclipse.swt.layout.FormAttachment(0, 82);
		fd_label_3.left = new org.eclipse.swt.layout.FormAttachment(0, 723);
		label_3.setLayoutData(fd_label_3);
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		fd_btnNewButton_1.top = new FormAttachment(btnNewButton_2, -7, SWT.TOP);
		org.eclipse.swt.layout.FormData fd_btnNewButton_2 = new org.eclipse.swt.layout.FormData();
		fd_btnNewButton_2.top = new FormAttachment(lblBonjourBernard, 0, SWT.TOP);
		fd_btnNewButton_2.right = new FormAttachment(lblBonjourBernard, -17);
		fd_btnNewButton_2.bottom = new FormAttachment(0, 93);
		fd_btnNewButton_2.left = new FormAttachment(0, 258);
		btnNewButton_2.setLayoutData(fd_btnNewButton_2);
		btnNewButton_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_2.setText("PPE SLAM2");
		
		Button btnInformatiqueSlam = new Button(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_btnInformatiqueSlam = new org.eclipse.swt.layout.FormData();
		fd_btnInformatiqueSlam.bottom = new FormAttachment(100, -10);
		fd_btnInformatiqueSlam.left = new FormAttachment(btnNewButton, 0, SWT.LEFT);
		fd_btnInformatiqueSlam.right = new FormAttachment(0, 119);
		fd_btnInformatiqueSlam.top = new FormAttachment(0, 360);
		btnInformatiqueSlam.setLayoutData(fd_btnInformatiqueSlam);
		btnInformatiqueSlam.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		btnInformatiqueSlam.setText("PPE SLAM1");
		
		table_2 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_table_2 = new FormData();
		fd_table_2.top = new FormAttachment(btnNewButton_1, 6);
		fd_table_2.bottom = new FormAttachment(100, -39);
		table_2.setLayoutData(fd_table_2);
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);
		fd_table_2.right = new FormAttachment(100, -508);
		
		table_3 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_table_3 = new FormData();
		fd_table_3.left = new FormAttachment(table_2, 6);
		fd_table_3.top = new FormAttachment(dateTime, 62);
		fd_table_3.bottom = new FormAttachment(100, -41);
		fd_table_3.right = new FormAttachment(100, -366);
		table_3.setLayoutData(fd_table_3);
		table_3.setHeaderVisible(true);
		table_3.setLinesVisible(true);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_table_2.left = new FormAttachment(table, 6);
		FormData fd_table = new FormData();
		fd_table.left = new FormAttachment(btnTerminaleStid, 117);
		fd_table.right = new FormAttachment(100, -650);
		fd_table.bottom = new FormAttachment(100, -41);
		fd_table.top = new FormAttachment(btnNewButton_2, 12);
		table.setLayoutData(fd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_table_1 = new FormData();
		fd_table_1.right = new FormAttachment(table_3, 155, SWT.RIGHT);
		fd_table_1.left = new FormAttachment(label_3, -26, SWT.LEFT);
		fd_table_1.bottom = new FormAttachment(table_2, 343);
		fd_table_1.top = new FormAttachment(table_2, 0, SWT.TOP);
		table_1.setLayoutData(fd_table_1);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		table_4 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_table_4 = new FormData();
		fd_table_4.right = new FormAttachment(table_1, 142, SWT.RIGHT);
		fd_table_4.top = new FormAttachment(table_2, 0, SWT.TOP);
		fd_table_4.bottom = new FormAttachment(table_1, 0, SWT.BOTTOM);
		fd_table_4.left = new FormAttachment(table_1, 6);
		table_4.setLayoutData(fd_table_4);
		table_4.setHeaderVisible(true);
		table_4.setLinesVisible(true);
		
		Label lblh = new Label(shell, SWT.NONE);
		FormData fd_lblh = new FormData();
		fd_lblh.top = new FormAttachment(btnAlgoSlam, 52);
		fd_lblh.right = new FormAttachment(table, -8);
		lblh.setLayoutData(fd_lblh);
		lblh.setText("8h");
		
		Label lblh_1 = new Label(shell, SWT.NONE);
		FormData fd_lblh_1 = new FormData();
		fd_lblh_1.top = new FormAttachment(lblh, 6);
		fd_lblh_1.right = new FormAttachment(table, -6);
		lblh_1.setLayoutData(fd_lblh_1);
		lblh_1.setText("9h");
		
		Label lblh_2 = new Label(shell, SWT.NONE);
		FormData fd_lblh_2 = new FormData();
		fd_lblh_2.top = new FormAttachment(btnNewButton, 0, SWT.TOP);
		fd_lblh_2.right = new FormAttachment(table, -11);
		lblh_2.setLayoutData(fd_lblh_2);
		lblh_2.setText("10h");

	}
}

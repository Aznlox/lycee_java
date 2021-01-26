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
	private Table table;


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
		shell.setSize(912, 511);
		shell.setText("SWT Application");
		shell.setLayout(new org.eclipse.swt.layout.FormLayout());
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		org.eclipse.swt.layout.FormData fd_dateTime = new org.eclipse.swt.layout.FormData();
		fd_dateTime.top = new org.eclipse.swt.layout.FormAttachment(0, 23);
		fd_dateTime.left = new org.eclipse.swt.layout.FormAttachment(0, 713);
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
		fd_btnAlgoSlam.bottom = new org.eclipse.swt.layout.FormAttachment(0, 184);
		fd_btnAlgoSlam.right = new org.eclipse.swt.layout.FormAttachment(0, 838);
		fd_btnAlgoSlam.top = new org.eclipse.swt.layout.FormAttachment(0, 120);
		fd_btnAlgoSlam.left = new org.eclipse.swt.layout.FormAttachment(0, 726);
		btnAlgoSlam.setLayoutData(fd_btnAlgoSlam);
		btnAlgoSlam.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		btnAlgoSlam.setText("Algo SLAM 2");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_btnNewButton_1 = new org.eclipse.swt.layout.FormData();
		fd_btnNewButton_1.bottom = new org.eclipse.swt.layout.FormAttachment(0, 429);
		fd_btnNewButton_1.right = new org.eclipse.swt.layout.FormAttachment(0, 867);
		fd_btnNewButton_1.top = new org.eclipse.swt.layout.FormAttachment(0, 334);
		fd_btnNewButton_1.left = new org.eclipse.swt.layout.FormAttachment(0, 731);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_1.setText("Enseignement");
		
		Label lblMardi = new Label(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_lblMardi = new org.eclipse.swt.layout.FormData();
		fd_lblMardi.right = new org.eclipse.swt.layout.FormAttachment(0, 368);
		fd_lblMardi.top = new org.eclipse.swt.layout.FormAttachment(0, 13);
		fd_lblMardi.left = new org.eclipse.swt.layout.FormAttachment(0, 287);
		lblMardi.setLayoutData(fd_lblMardi);
		lblMardi.setText("Mardi");
		
		Label lblMercredi = new Label(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_lblMercredi = new org.eclipse.swt.layout.FormData();
		fd_lblMercredi.right = new org.eclipse.swt.layout.FormAttachment(0, 492);
		fd_lblMercredi.top = new org.eclipse.swt.layout.FormAttachment(0, 44);
		fd_lblMercredi.left = new org.eclipse.swt.layout.FormAttachment(0, 411);
		lblMercredi.setLayoutData(fd_lblMercredi);
		lblMercredi.setText("Mercredi");
		
		Label lblJeudi = new Label(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_lblJeudi = new org.eclipse.swt.layout.FormData();
		fd_lblJeudi.right = new org.eclipse.swt.layout.FormAttachment(0, 640);
		fd_lblJeudi.top = new org.eclipse.swt.layout.FormAttachment(0, 93);
		fd_lblJeudi.left = new org.eclipse.swt.layout.FormAttachment(0, 559);
		lblJeudi.setLayoutData(fd_lblJeudi);
		lblJeudi.setText("Jeudi");
		
		Label lblVendredi = new Label(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_lblVendredi = new org.eclipse.swt.layout.FormData();
		fd_lblVendredi.right = new org.eclipse.swt.layout.FormAttachment(0, 766);
		fd_lblVendredi.top = new org.eclipse.swt.layout.FormAttachment(0, 93);
		fd_lblVendredi.left = new org.eclipse.swt.layout.FormAttachment(0, 685);
		lblVendredi.setLayoutData(fd_lblVendredi);
		lblVendredi.setText("Vendredi");
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		org.eclipse.swt.layout.FormData fd_label_2 = new org.eclipse.swt.layout.FormData();
		fd_label_2.bottom = new org.eclipse.swt.layout.FormAttachment(0, 402);
		fd_label_2.right = new org.eclipse.swt.layout.FormAttachment(0, 522);
		fd_label_2.top = new org.eclipse.swt.layout.FormAttachment(0, 93);
		fd_label_2.left = new org.eclipse.swt.layout.FormAttachment(0, 513);
		label_2.setLayoutData(fd_label_2);
		
		Label label_3 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		org.eclipse.swt.layout.FormData fd_label_3 = new org.eclipse.swt.layout.FormData();
		fd_label_3.bottom = new org.eclipse.swt.layout.FormAttachment(0, 402);
		fd_label_3.right = new org.eclipse.swt.layout.FormAttachment(0, 723);
		fd_label_3.top = new org.eclipse.swt.layout.FormAttachment(0, 82);
		fd_label_3.left = new org.eclipse.swt.layout.FormAttachment(0, 723);
		label_3.setLayoutData(fd_label_3);
		
		Label label_4 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		org.eclipse.swt.layout.FormData fd_label_4 = new org.eclipse.swt.layout.FormData();
		fd_label_4.bottom = new org.eclipse.swt.layout.FormAttachment(0, 402);
		fd_label_4.top = new org.eclipse.swt.layout.FormAttachment(0, 93);
		fd_label_4.left = new org.eclipse.swt.layout.FormAttachment(0, 660);
		label_4.setLayoutData(fd_label_4);
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		org.eclipse.swt.layout.FormData fd_btnNewButton_2 = new org.eclipse.swt.layout.FormData();
		fd_btnNewButton_2.bottom = new org.eclipse.swt.layout.FormAttachment(0, 211);
		fd_btnNewButton_2.right = new org.eclipse.swt.layout.FormAttachment(0, 766);
		fd_btnNewButton_2.top = new org.eclipse.swt.layout.FormAttachment(0, 131);
		fd_btnNewButton_2.left = new org.eclipse.swt.layout.FormAttachment(0, 661);
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
		fd_btnInformatiqueSlam.bottom = new org.eclipse.swt.layout.FormAttachment(0, 365);
		fd_btnInformatiqueSlam.right = new org.eclipse.swt.layout.FormAttachment(0, 637);
		fd_btnInformatiqueSlam.top = new org.eclipse.swt.layout.FormAttachment(0, 280);
		fd_btnInformatiqueSlam.left = new org.eclipse.swt.layout.FormAttachment(0, 528);
		btnInformatiqueSlam.setLayoutData(fd_btnInformatiqueSlam);
		btnInformatiqueSlam.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		btnInformatiqueSlam.setText("PPE SLAM1");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new TableColumnLayout());
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(lblMardi, 67);
		fd_composite.bottom = new FormAttachment(100, -41);
		fd_composite.right = new FormAttachment(100, -552);
		fd_composite.left = new FormAttachment(btnTerminaleStid, 63);
		composite.setLayoutData(fd_composite);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

	}
}

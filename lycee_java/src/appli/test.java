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
		
		Label lblBonjourBernard = new Label(shell, SWT.NONE);
		lblBonjourBernard.setBounds(380, 13, 131, 25);
		lblBonjourBernard.setText("Bonjour Bernard");
		
		Label lblPlanning = new Label(shell, SWT.NONE);
		lblPlanning.setBounds(10, 13, 81, 25);
		lblPlanning.setText("Planning");
		
		Label lblVosClasses = new Label(shell, SWT.NONE);
		lblVosClasses.setBounds(10, 124, 105, 25);
		lblVosClasses.setText("Vos Classes:");
		
		Button btnAlgoSlam = new Button(shell, SWT.NONE);
		btnAlgoSlam.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		btnAlgoSlam.setText("Algo SLAM 2");
		btnAlgoSlam.setBounds(726, 120, 112, 64);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_1.setBounds(731, 334, 136, 95);
		btnNewButton_1.setText("Enseignement");
		
		Label lblMardi = new Label(shell, SWT.NONE);
		lblMardi.setBounds(287, 13, 81, 25);
		lblMardi.setText("Mardi");
		
		Label lblMercredi = new Label(shell, SWT.NONE);
		lblMercredi.setBounds(411, 44, 81, 25);
		lblMercredi.setText("Mercredi");
		
		Label lblJeudi = new Label(shell, SWT.NONE);
		lblJeudi.setBounds(559, 93, 81, 25);
		lblJeudi.setText("Jeudi");
		
		Label lblVendredi = new Label(shell, SWT.NONE);
		lblVendredi.setBounds(685, 93, 81, 25);
		lblVendredi.setText("Vendredi");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(267, 93, 2, 309);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_2.setBounds(513, 93, 9, 309);
		
		Label label_3 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_3.setBounds(723, 82, -9, 320);
		
		Label label_4 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_4.setBounds(660, 93, 2, 309);
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_2.setBounds(661, 131, 105, 80);
		btnNewButton_2.setText("PPE SLAM2");
		
		Button btnInformatiqueSlam = new Button(shell, SWT.NONE);
		btnInformatiqueSlam.setBounds(158, 155, 109, 85);
		btnInformatiqueSlam.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		btnInformatiqueSlam.setText("PPE SLAM1");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(195, 159, 180, 260);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

	}
}

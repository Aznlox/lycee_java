package appli;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.ProgressBar;

public class motif
{

	protected Shell shell;
	private Table table;


	public static void main(String[] args)
	{
		try
		{
			motif window = new motif();
			window.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


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

	protected void createContents()
	{
		shell = new Shell();
		shell.setSize(988, 530);
		shell.setText("Motif");

		Label lblAjouterUnMotif = new Label(shell, SWT.NONE);
		lblAjouterUnMotif.setFont(SWTResourceManager.getFont("Comic Sans MS", 14, SWT.NORMAL));
		lblAjouterUnMotif.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblAjouterUnMotif.setBounds(10, 10, 228, 50);
		lblAjouterUnMotif.setText("Ajouter un motif");

		Label lblAjouterUnMotif_1 = new Label(shell, SWT.NONE);
		lblAjouterUnMotif_1.setFont(SWTResourceManager.getFont("Comic Sans MS", 12, SWT.NORMAL));
		lblAjouterUnMotif_1.setBounds(352, 53, 203, 33);
		lblAjouterUnMotif_1.setText("Ajouter un motif");

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(274, 164, 381, 119);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn.setResizable(false);
		tblclmnNewColumn.setWidth(199);
		tblclmnNewColumn.setText("               El\u00E8ve");

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(182);
		tblclmnNewColumn_1.setText("     NAKHIL Amine");

		TableItem Type = new TableItem(table, SWT.NONE);
		Type.setText("              Type");

		TableItem Commentaire = new TableItem(table, SWT.NONE);
		Commentaire.setText("         Commentaire");

		Button btnValider = new Button(shell, SWT.NONE);
		btnValider.setBounds(429, 404, 105, 35);
		btnValider.setText("Valider");

		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"Maladie", "Exclusionaisons perssos"});
		combo.setBounds(475, 192, 180, 33);
		combo.setText("Maladie\r\n");

		ProgressBar progressBar = new ProgressBar(shell, SWT.NONE);
		progressBar.setBounds(-46, 356, 260, 26);

	}
}

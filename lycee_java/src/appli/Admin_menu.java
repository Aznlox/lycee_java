package appli;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import controller.Global;

public class Admin_menu extends Global{

	protected Shell shlMenuAdmin;

	/**
	 * Launch the application.
	 * @param args
	 */
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMenuAdmin.open();
		shlMenuAdmin.layout();
		while (!shlMenuAdmin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMenuAdmin = new Shell();
		shlMenuAdmin.setSize(366, 449);

		shlMenuAdmin.setText("Menu Admin");
		
		Label lblMenu = new Label(shlMenuAdmin, SWT.NONE);
		lblMenu.setBounds(150, 21, 81, 25);
		lblMenu.setText("Menu");
		
		Button btnProf = new Button(shlMenuAdmin, SWT.NONE);
		btnProf.setBounds(80, 71, 184, 35);
		btnProf.setText("Gestion utilisateurs");
		
		Button btnClasse = new Button(shlMenuAdmin, SWT.NONE);
		btnClasse.setText("Gestion classes");
		btnClasse.setBounds(80, 126, 184, 35);
		
		Button btnEleve = new Button(shlMenuAdmin, SWT.NONE);
		btnEleve.setText("Gestion \u00E9l\u00E8ves");
		btnEleve.setBounds(80, 182, 184, 35);
		
		Button btnPlanning = new Button(shlMenuAdmin, SWT.NONE);
		btnPlanning.setBounds(80, 237, 184, 35);
		btnPlanning.setText("Modifier le planning");
		
		Button btnVieSco = new Button(shlMenuAdmin, SWT.NONE);
		btnVieSco.setBounds(80, 293, 184, 35);
		btnVieSco.setText("Gestion vie scolaire");
		btnVieSco.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				try
				{
					Liste_Eleve window = new Liste_Eleve();
					window.open();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});

	}
}

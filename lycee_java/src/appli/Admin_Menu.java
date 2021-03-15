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
import org.eclipse.wb.swt.SWTResourceManager;

public class Admin_Menu extends Global
{

	protected Shell shlMenuAdmin;

	/**
	* Launch the application.
	* @param args
	*/
	/**
	* Ouvrir la fenetre.
	* @wbp.parser.entryPoint
	*/
	public void open()
	{
		Display display = Display.getDefault();
		createContents();
		shlMenuAdmin.open();
		shlMenuAdmin.layout();
		while (!shlMenuAdmin.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}

	/**
	* fondation du contenu de la fenetre.
	*/
	protected void createContents()
	{
		shlMenuAdmin = new Shell();
		shlMenuAdmin.setSize(366, 401);

		shlMenuAdmin.setText("Menu Admin");

		Label lblMenu = new Label(shlMenuAdmin, SWT.NONE);
		lblMenu.setBounds(150, 21, 81, 25);
		lblMenu.setText("Menu");

		Button btnProf = new Button(shlMenuAdmin, SWT.NONE);
		btnProf.setBounds(80, 71, 184, 35);
		btnProf.setText("Gestion utilisateurs");
		btnProf.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				try
				{
					Liste_Utilisateurs window = new Liste_Utilisateurs();
					window.open();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});


		Button btnClasse = new Button(shlMenuAdmin, SWT.NONE);
		btnClasse.setText("Gestion classes");
		btnClasse.setBounds(80, 126, 184, 35);
		btnClasse.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				try
				{
					Admin_Classe window = new Admin_Classe();
					window.open();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});


		Button btnEleve = new Button(shlMenuAdmin, SWT.NONE);
		btnEleve.setBounds(80, 183, 184, 35);
		btnEleve.setText("Gestion Eleve");
		btnEleve.addSelectionListener(new SelectionAdapter()
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

		Button btnPlanning = new Button(shlMenuAdmin, SWT.NONE);
		btnPlanning.setBounds(80, 237, 184, 35);
		btnPlanning.setText("Modifier le planning");

		Button btnDconnexion = new Button(shlMenuAdmin, SWT.NONE);
		btnDconnexion.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnDconnexion.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				shlMenuAdmin.close();
				try
				{
					Connexion window = new Connexion();
					window.open();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnDconnexion.setBounds(114, 300, 116, 35);
		btnDconnexion.setText("D\u00E9connexion");
		btnPlanning.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				try
				{
					Admin_Planning window = new Admin_Planning();
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

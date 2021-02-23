package appli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Menu;
import com.dbconnexion.*;

public class temporaire
{

	protected Shell shell;
	private Table table;
	public static void main(String[] args)
	{


		try
		{
			Connexion window = new Connexion();
			window.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}


	/**
	* Open the window.
	*/
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




	/**
	* @wbp.parser.entryPoint
	*/
	protected void createContents()
	{

		shell = new Shell();
		shell.setSize(686, 419);
		shell.setText("admin");

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(232, 57, 345, 243);


		Label Nom_Eleve = new Label(composite, SWT.NONE);
		Nom_Eleve.setText("Nom");
		Nom_Eleve.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		Nom_Eleve.setBounds(189, 100, 65, 20);

		Label Prenom_Eleve = new Label(composite, SWT.NONE);
		Prenom_Eleve.setText("Prenom");
		Prenom_Eleve.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		Prenom_Eleve.setBounds(189, 125, 65, 20);

		Label lblNom = new Label(composite, SWT.NONE);
		lblNom.setText("Nom");
		lblNom.setBounds(62, 100, 56, 16);

		Label lblPrenom = new Label(composite, SWT.NONE);
		lblPrenom.setText("Prenom");
		lblPrenom.setBounds(62, 125, 56, 16);

		Label listeeleves = new Label(shell, SWT.NONE);
		listeeleves.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		listeeleves.setBounds(27, 22, 153, 33);
		listeeleves.setText("Liste des \u00E9l\u00E8ves");

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(55, 57, 102, 243);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn libelleNomEleve = new TableColumn(table, SWT.NONE);
		libelleNomEleve.setWidth(100);
		libelleNomEleve.setText("Nom");

		TableItem tableItem_1 = new TableItem(table, SWT.NONE);
		tableItem_1.setText("test");

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		Button btnAjouterUneAbsence = new Button(shell, SWT.NONE);
		btnAjouterUneAbsence.setBounds(434, 22, 186, 29);
		btnAjouterUneAbsence.setText("Modifier votre profil");




		Database db = new Database();
		Connection cnx = db.DbConnexion();

		String sql = "SELECT * FROM eleve";
		ResultSet res = db.Request(cnx, sql);


		//�tape 5: extraire les donn�es
		try
		{
			while(res.next())
			{
				//R�cup�rer par nom de colonne

				String nom = res.getString("nom");
				String prenom = res.getString("prenom");


				Nom_Eleve.setText(nom);
				Prenom_Eleve.setText(prenom);
				tableItem_1.setText(nom);


				//�tape 6: fermez l'objet de connexion

			}
			btnAjouterUneAbsence.addSelectionListener(new SelectionAdapter()
			{
				@Override
				public void widgetSelected(SelectionEvent e)
				{
					shell.close();
					try
					{
						form form = new form();
						form.open();
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}
				}
			});

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





	}

}

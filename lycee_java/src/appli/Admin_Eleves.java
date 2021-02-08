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

public class Admin_Eleves
{

	protected Shell shell;
	private Table table;


	public static void main(String[] args)
	{
		try
		{
			Admin_Eleves window = new Admin_Eleves();
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
	
	


	protected void createContents()
	{
		Database db = new Database();
	    Connection cnx = db.DbConnexion();
	    
	    String sql = "SELECT type FROM vie_scolaire";
	    ResultSet res = db.Request(cnx, sql);


	    //étape 5: extraire les données
	    try 
	    {
	        while(res.next())
	        {
	            //Récupérer par nom de colonne
	            String type = res.getString("type");
	        
			
			   
			 //étape 6: fermez l'objet de connexion
				shell = new Shell();
				shell.setSize(600, 371);
				shell.setText("SWT Application");

				Composite composite = new Composite(shell, SWT.NONE);
				composite.setBounds(232, 57, 345, 243);

				Label Nom_Eleve = new Label(composite, SWT.NONE);
				Nom_Eleve.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
				Nom_Eleve.setBounds(137, 51, 75, 20);
				Nom_Eleve.setText("LOIC GUO");

				Label libelleClasse = new Label(composite, SWT.NONE);
				libelleClasse.setText("SLAM 2");
				libelleClasse.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
				libelleClasse.setBounds(147, 77, 65, 20);

				Label AbsenceEleve = new Label(composite, SWT.NONE);
				AbsenceEleve.setText(type);
				AbsenceEleve.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
				AbsenceEleve.setBounds(167, 107, 65, 20);

				Label RetardEleve = new Label(composite, SWT.NONE);
				RetardEleve.setText("1");
				RetardEleve.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
				RetardEleve.setBounds(167, 133, 65, 20);

				Label Absences = new Label(composite, SWT.NONE);
				Absences.setText("Absences");
				Absences.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
				Absences.setBounds(96, 107, 65, 20);

				Label Retards = new Label(composite, SWT.NONE);
				Retards.setText("Retards");
				Retards.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
				Retards.setBounds(96, 133, 65, 20);

				Label Sanctions = new Label(composite, SWT.NONE);
				Sanctions.setText("Sanctions");
				Sanctions.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
				Sanctions.setBounds(96, 158, 65, 20);

				Label SanctionEleve = new Label(composite, SWT.NONE);
				SanctionEleve.setText("1");
				SanctionEleve.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
				SanctionEleve.setBounds(167, 158, 65, 20);

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

				TableItem NomEleve = new TableItem(table, SWT.NONE);
				NomEleve.setText("GUO");

				Menu menu = new Menu(shell, SWT.BAR);
				shell.setMenuBar(menu);

			}
		} 
	    catch (SQLException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  
	    



	}
	
}
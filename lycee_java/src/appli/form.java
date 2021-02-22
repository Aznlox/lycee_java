package appli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
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

public class form
{

	protected Shell shell;
	private Text justification;


	public static void main(String[] args)
	{
		try
		{
			form window = new form();
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
		shell.setText("SWT Application");

		Label lblAjouterUnMotif_1 = new Label(shell, SWT.NONE);
		lblAjouterUnMotif_1.setFont(SWTResourceManager.getFont("Comic Sans MS", 12, SWT.NORMAL));
		lblAjouterUnMotif_1.setBounds(352, 53, 203, 33);
		lblAjouterUnMotif_1.setText("Ajouter un motif");
		
		Label lblNomEleve = new Label(shell, SWT.NONE);
		lblNomEleve.setBounds(307, 137, 64, 16);
		lblNomEleve.setText("Nom Eleve");
		
		Label lblType = new Label(shell, SWT.NONE);
		lblType.setText("type");
		lblType.setBounds(307, 177, 64, 16);
		
		Combo nomEleve = new Combo(shell, SWT.NONE);
		nomEleve.setBounds(383, 136, 138, 20);

		
		Combo type = new Combo(shell, SWT.NONE);
		type.setItems(new String[] {});
		type.setBounds(383, 176, 138, 20);
		type.setText("Type");
		
		justification = new Text(shell, SWT.BORDER);
		justification.setBounds(383, 222, 138, 33);
		
		Label lblMotif = new Label(shell, SWT.NONE);
		lblMotif.setText("Justification");
		lblMotif.setBounds(307, 225, 70, 16);
		
		Button btnValider = new Button(shell, SWT.NONE);
		btnValider.setBounds(418, 275, 70, 21);
		btnValider.setText("Valider");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		Database db = new Database();
	    Connection cnx = db.DbConnexion();
	    
	    String sql = "SELECT * FROM vie_scolaire";
	    ResultSet res = db.Request(cnx, sql);


	    //étape 5: extraire les données
	    try {
	        while(res.next()){
	            //Récupérer par nom de colonne
	   
	            type.add(res.getString("type"));


			 //étape 6: fermez l'objet de connexion
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  
	    



	}
	
}



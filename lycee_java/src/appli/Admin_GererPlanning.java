package appli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

import com.dbconnexion.Database;

public class Admin_GererPlanning {

	protected Shell shlPlanning;

	/**
	 * Launch the application.
	 * @param args
	 */

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlPlanning.open();
		shlPlanning.layout();
		while (!shlPlanning.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		Database db = new Database();
		Connection cnx = db.DbConnexion();
		shlPlanning = new Shell();
		shlPlanning.setSize(513, 573);
		shlPlanning.setText("Planning");

		Label lblErreur = new Label(shlPlanning, SWT.NONE);
		lblErreur.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblErreur.setBounds(16, 228, 253, 25);
		lblErreur.setText("Veuiller selectionner une classe");
		lblErreur.setVisible(false);

		Label lblSucces = new Label(shlPlanning, SWT.NONE);
		lblSucces.setText("Modification r\u00E9ussi");
		lblSucces.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblSucces.setBounds(16, 228, 253, 25);
		lblSucces.setVisible(false);

		Label lblAjoutErreur = new Label(shlPlanning, SWT.NONE);
		lblAjoutErreur.setVisible(false);
		lblAjoutErreur.setText("Veuiller remplir le champs");
		lblAjoutErreur.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblAjoutErreur.setBounds(210, 445, 217, 25);

		Label lblAjoutSucces = new Label(shlPlanning, SWT.NONE);
		lblAjoutSucces.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblAjoutSucces.setBounds(210, 445, 102, 25);
		lblAjoutSucces.setText("Ajout r\u00E9ussi");
		lblAjoutSucces.setVisible(false);

		Label lblClasse = new Label(shlPlanning, SWT.NONE);
		lblClasse.setBounds(16, 45, 81, 25);
		lblClasse.setText("Classe :");

		Combo comboClasse = new Combo(shlPlanning, SWT.READ_ONLY);
		comboClasse.setBounds(16, 76, 211, 33);
		comboClasse.select(0);

		String requete = "Select * from classe where undeletable = 0";
		ResultSet resultat = db.Request(cnx, requete);
		ArrayList<Integer> classeList = new  ArrayList<Integer>();
		while(resultat.next())
		{

			comboClasse.add(resultat.getString("libelle"));
			classeList.add(resultat.getInt("id"));
		}

		Label lblModLibelle = new Label(shlPlanning, SWT.NONE);
		lblModLibelle.setBounds(16, 143, 81, 25);
		lblModLibelle.setText("Libell\u00E9 :");

		textModClasse = new Text(shlPlanning, SWT.BORDER);
		textModClasse.setBounds(103, 116, 186, 31);


		Button btnModValider = new Button(shlPlanning, SWT.NONE);
		btnModValider.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(comboClasse.getSelectionIndex() > -1) {
					String requete = "Update classe set libelle ='"+textModClasse.getText()+"' where id ='"+classeList.get(comboClasse.getSelectionIndex())+"'";
					boolean message = db.Prepare(cnx, requete);
					comboClasse.removeAll();
					classeList.clear();
					requete = "Select * from classe where undeletable = 0";
					ResultSet resultat = db.Request(cnx, requete);
					try {
						while(resultat.next()) {
							comboClasse.add(resultat.getString("libelle"));
							classeList.add(resultat.getInt("id"));
						}
						lblSucces.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					lblErreur.setText("Veuiller remplir le champs");
					lblErreur.setVisible(true);
					lblSucces.setVisible(false);
				}
			}

		});

		btnModValider.setBounds(16, 187, 105, 35);
		btnModValider.setText("Valider");


		Button btnSupprimer = new Button(shlPlanning, SWT.NONE);
		btnSupprimer.setBounds(157, 187, 105, 35);
		btnSupprimer.setText("Supprimer");
		btnSupprimer.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(comboClasse.getSelectionIndex() > -1) {
					if(textModClasse.getText() != null && !textModClasse.getText().trim().isEmpty()) {
						String requete = "Delete from classe where id ='"+classeList.get(comboClasse.getSelectionIndex())+"'";
						boolean message = db.Prepare(cnx, requete);
						requete = "Update eleve set id_classe = 1 where id_classe ='"+classeList.get(comboClasse.getSelectionIndex())+"'";
						message = db.Prepare(cnx, requete);
						comboClasse.removeAll();
						classeList.clear();
						requete = "Select * from classe where undeletable = 0";
						ResultSet resultat = db.Request(cnx, requete);
						try {
							while(resultat.next()) {

								comboClasse.add(resultat.getString("libelle"));
								classeList.add(resultat.getInt("id"));
							}
							lblSucces.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else {
						lblErreur.setText("Veuiller remplir le champs");
						lblErreur.setVisible(true);
						lblSucces.setVisible(false);
					}
				}
				else {
					lblErreur.setText("Veuiller selectionner une classe");
					lblErreur.setVisible(true);
					lblSucces.setVisible(false);
				}
			}
		});

		Label lblLAddlibelle = new Label(shlPlanning, SWT.NONE);
		lblLAddlibelle.setText("Libell\u00E9 :");
		lblLAddlibelle.setBounds(16, 393, 81, 25);

		textAddClasse = new Text(shlPlanning, SWT.BORDER);
		textAddClasse.setBounds(103, 366, 186, 31);

		Button AjouterClasse = new Button(shlPlanning, SWT.NONE);
		AjouterClasse.setBounds(10, 440, 162, 35);
		AjouterClasse.setText("Ajouter une classe");

		Button btnOk = new Button(shlPlanning, SWT.NONE);
		btnOk.setBounds(249, 76, 150, 35);
		btnOk.setText("Selectionner");
		btnOk.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				if(comboClasse.getSelectionIndex() > -1) {
					textModClasse.setText(comboClasse.getItem(comboClasse.getSelectionIndex()));
					lblErreur.setVisible(false);
					lblSucces.setVisible(false);
					lblAjoutSucces.setVisible(false);
				}
				else {
					lblErreur.setVisible(true);
					lblSucces.setVisible(false);
				}

			}
		});

		AjouterClasse.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				if(textAddClasse.getText() != null && !textAddClasse.getText().trim().isEmpty()) {
					comboClasse.removeAll();
					classeList.clear();
					String requete = "INSERT into classe (libelle) Values('"+textAddClasse.getText()+"')";
					boolean message = db.Prepare(cnx, requete);

					requete = "Select * from classe where undeletable = 0";
					ResultSet resultat = db.Request(cnx, requete);
					try {
						while(resultat.next()) {
							comboClasse.add(resultat.getString("libelle"));
							classeList.add(resultat.getInt("id"));
						}
						lblAjoutSucces.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					lblAjoutErreur.setVisible(true);
					lblAjoutSucces.setVisible(false);
				}

			}
		});


	}

}

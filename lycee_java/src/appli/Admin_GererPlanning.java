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
	protected String nomJour;
	protected int jour;
	protected int selectClasse;
	protected int selectProf;
	protected int selectJour;

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
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		Database db = new Database();
		Connection cnx = db.DbConnexion();
		shlPlanning = new Shell();
		shlPlanning.setSize(375, 563);
		shlPlanning.setText("Planning");

		Label lblAjoutErreur = new Label(shlPlanning, SWT.NONE);
		lblAjoutErreur.setVisible(false);
		lblAjoutErreur.setText("Veuiller remplir le champs");
		lblAjoutErreur.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblAjoutErreur.setBounds(16, 461, 217, 25);

		Label lblAjoutSucces = new Label(shlPlanning, SWT.NONE);
		lblAjoutSucces.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblAjoutSucces.setBounds(16, 461, 102, 25);
		lblAjoutSucces.setText("Ajout r\u00E9ussi");
		lblAjoutSucces.setVisible(false);

		Label lblClasse = new Label(shlPlanning, SWT.NONE);
		lblClasse.setBounds(16, 21, 81, 25);
		lblClasse.setText("Classe :");

		Combo comboClasse = new Combo(shlPlanning, SWT.READ_ONLY);
		comboClasse.setBounds(16, 52, 211, 33);
		comboClasse.select(0);

		String requete = "Select * from classe where undeletable = 0";
		ResultSet resultat = db.Request(cnx, requete);
		ArrayList<Integer> classeList = new  ArrayList<Integer>();
		try {
			while(resultat.next())
			{

				comboClasse.add(resultat.getString("libelle"));
				classeList.add(resultat.getInt("id"));
			}
			comboClasse.select(0);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		Label lblProf = new Label(shlPlanning, SWT.NONE);
		lblProf.setBounds(16, 104, 105, 25);
		lblProf.setText("Professeur :");
		
		Combo comboProf = new Combo(shlPlanning, SWT.READ_ONLY);
		comboProf.setBounds(16, 135, 211, 33);
		requete = "Select * from utilisateur where role = 'professeur'";
		resultat = db.Request(cnx, requete);
		ArrayList<Integer> profList = new  ArrayList<Integer>();
		try {
			while(resultat.next())
			{
				comboProf.add(resultat.getString("nom"));
				profList.add(resultat.getInt("id"));
			}
			comboProf.select(0);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Label lblVue = new Label(shlPlanning, SWT.NONE);
		lblVue.setBounds(10, 377, 327, 25);
		
		Combo comboHeure = new Combo(shlPlanning, SWT.READ_ONLY);
		comboHeure.setEnabled(false);
		comboHeure.setBounds(16, 298, 104, 33);
		
		
		ArrayList<Integer> heureList = new  ArrayList<Integer>();
		
		Label lblAjout = new Label(shlPlanning, SWT.NONE);
		lblAjout.setText("Ajout :");
		lblAjout.setBounds(16, 346, 81, 25);
		
		
		Button btnLundi = new Button(shlPlanning, SWT.RADIO);
		btnLundi.setBounds(16, 214, 81, 25);
		btnLundi.setText("Lundi");
		btnLundi.addSelectionListener(new SelectionAdapter()  {
			 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                    comboHeure.removeAll();
                    heureList.clear();
                    comboHeure.setEnabled(true);
                    jour = 1;
                    nomJour = "Lundi";
                    String requete = "SELECT DISTINCT heure.id, libelle FROM planning inner join heure where heure.id not in (SELECT id_heure FROM planning where id_professeur = "+profList.get(comboProf.getSelectionIndex())+" AND id_jour = "+jour+" or id_classe = "+classeList.get(comboClasse.getSelectionIndex())+" AND id_jour = "+jour+")";
            		ResultSet resultat = db.Request(cnx, requete);
            		try {
						while(resultat.next())
						{
							comboHeure.add(resultat.getString("libelle"));
							heureList.add(resultat.getInt("heure.id"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }
             
        });
		
		Button btnMardi = new Button(shlPlanning, SWT.RADIO);
		btnMardi.setBounds(103, 214, 81, 25);
		btnMardi.setText("Mardi");
		btnMardi.addSelectionListener(new SelectionAdapter()  {
			 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                    comboHeure.removeAll();
                    heureList.clear();
                    comboHeure.setEnabled(true);
                    jour = 2;
                    nomJour = "Mardi";
                    String requete = "SELECT DISTINCT heure.id, libelle FROM planning inner join heure where heure.id not in (SELECT id_heure FROM planning where id_professeur = "+profList.get(comboProf.getSelectionIndex())+" AND id_jour = "+jour+" or id_classe = "+classeList.get(comboClasse.getSelectionIndex())+" AND id_jour = "+jour+")";
            		ResultSet resultat = db.Request(cnx, requete);
            		try {
						while(resultat.next())
						{
							comboHeure.add(resultat.getString("libelle"));
							heureList.add(resultat.getInt("heure.id"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }
             
        });
		
		Button btnMercredi = new Button(shlPlanning, SWT.RADIO);
		btnMercredi.setBounds(190, 214, 105, 25);
		btnMercredi.setText("Mercredi");
		btnMercredi.addSelectionListener(new SelectionAdapter()  {
			 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                    comboHeure.removeAll();
                    heureList.clear();
                    comboHeure.setEnabled(true);
                    jour = 3;
                    nomJour = "Mercreci";
                    String requete = "SELECT DISTINCT heure.id, libelle FROM planning inner join heure where heure.id not in (SELECT id_heure FROM planning where id_professeur = "+profList.get(comboProf.getSelectionIndex())+" AND id_jour = "+jour+" or id_classe = "+classeList.get(comboClasse.getSelectionIndex())+" AND id_jour = "+jour+")";
            		ResultSet resultat = db.Request(cnx, requete);
            		try {
						while(resultat.next())
						{
							comboHeure.add(resultat.getString("libelle"));
							heureList.add(resultat.getInt("heure.id"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }
             
        });
		
		Button btnJeudi = new Button(shlPlanning, SWT.RADIO);
		btnJeudi.setBounds(16, 260, 76, 25);
		btnJeudi.setText("Jeudi");
		btnJeudi.addSelectionListener(new SelectionAdapter()  {
			 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                    comboHeure.removeAll();
                    heureList.clear();
                    comboHeure.setEnabled(true);
                    jour = 4;
                    nomJour = "Jeudi";
                    String requete = "SELECT DISTINCT heure.id, libelle FROM planning inner join heure where heure.id not in (SELECT id_heure FROM planning where id_professeur = "+profList.get(comboProf.getSelectionIndex())+" AND id_jour = "+jour+" or id_classe = "+classeList.get(comboClasse.getSelectionIndex())+" AND id_jour = "+jour+")";
            		ResultSet resultat = db.Request(cnx, requete);
            		try {
						while(resultat.next())
						{
							comboHeure.add(resultat.getString("libelle"));
							heureList.add(resultat.getInt("heure.id"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }
             
        });
		
		Button btnVendredi = new Button(shlPlanning, SWT.RADIO);
		btnVendredi.setBounds(103, 260, 105, 25);
		btnVendredi.setText("Vendredi");
		btnVendredi.addSelectionListener(new SelectionAdapter()  {
			 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                    comboHeure.removeAll();
                    heureList.clear();
                    comboHeure.setEnabled(true);
                    jour = 5;
                    nomJour = "Vendredi";
                    String requete = "SELECT DISTINCT heure.id, libelle FROM planning inner join heure where heure.id not in (SELECT id_heure FROM planning where id_professeur = "+profList.get(comboProf.getSelectionIndex())+" AND id_jour = "+jour+" or id_classe = "+classeList.get(comboClasse.getSelectionIndex())+" AND id_jour = "+jour+")";
            		ResultSet resultat = db.Request(cnx, requete);
            		try {
						while(resultat.next())
						{
							comboHeure.add(resultat.getString("libelle"));
							heureList.add(resultat.getInt("heure.id"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }
             
        });
		
		Button AjouterPlanning = new Button(shlPlanning, SWT.NONE);
		AjouterPlanning.setEnabled(false);
		AjouterPlanning.setBounds(16, 408, 174, 35);
		AjouterPlanning.setText("Ajouter un planning");
		
		comboHeure.addSelectionListener(new SelectionAdapter()
		  {
		    @Override
		    public void widgetSelected(final SelectionEvent event)
		    {
		    	lblAjoutSucces.setVisible(false);
		    	AjouterPlanning.setEnabled(true);
		    	selectClasse = comboClasse.getSelectionIndex();
		    	selectProf = comboProf.getSelectionIndex();
		    	selectJour = jour;
		    	lblVue.setText(comboClasse.getItem(selectClasse)+" | "+comboProf.getItem(selectProf)+" | "+nomJour+" | "+comboHeure.getItem(comboHeure.getSelectionIndex()));
		    }
		  });
		

				
		AjouterPlanning.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
					String requete = "INSERT into planning (id_jour, id_heure, id_classe, id_professeur) Values("+selectJour+", "+heureList.get(comboHeure.getSelectionIndex())+", "+classeList.get(selectClasse)+", "+profList.get(selectProf)+")";
					boolean message = db.Prepare(cnx, requete);
					AjouterPlanning.setEnabled(false);
					comboHeure.setEnabled(false);
					lblAjoutSucces.setVisible(true);
			}				
		});

	}
}

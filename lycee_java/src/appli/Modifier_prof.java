package appli;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import controller.Global;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class Modifier_prof extends Global
{

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;


	public static void main(String[] args)
	{
		try
		{
			Modifier_prof window = new Modifier_prof();
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

	/**
	* Create contents of the window.
	*/
	protected void createContents()
	{
		shell = new Shell();
		shell.setSize(765, 559);
		shell.setText("SWT Application");
		
		Label lblNom = new Label(shell, SWT.NONE);
		lblNom.setBounds(165, 121, 81, 25);
		lblNom.setText("Nom");
		
		Label lblPrnom = new Label(shell, SWT.NONE);
		lblPrnom.setBounds(165, 173, 81, 25);
		lblPrnom.setText("Pr\u00E9nom");
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(165, 231, 81, 25);
		lblEmail.setText("Email");
		
		Label lblMatire = new Label(shell, SWT.NONE);
		lblMatire.setBounds(165, 290, 81, 25);
		lblMatire.setText("Mati\u00E8re");
		
		Label lblModifierSonProfil = new Label(shell, SWT.NONE);
		lblModifierSonProfil.setBounds(251, 34, 228, 25);
		lblModifierSonProfil.setText("Modifier son profil");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(307, 115, 80, 31);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(307, 167, 80, 31);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(307, 225, 80, 31);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(307, 284, 80, 31);
		
		Button btnValider = new Button(shell, SWT.NONE);
		btnValider.setBounds(295, 391, 105, 35);
		btnValider.setText("Valider");
		
		Button btnRetour = new Button(shell, SWT.NONE);
		btnRetour.setBounds(10, 10, 105, 35);
		btnRetour.setText("Retour");

	}
}

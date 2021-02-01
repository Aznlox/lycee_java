package appli;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import controller.Global;

public class Modifier_prof extends Global
{

	protected Shell shell;


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
		shell.setSize(650, 452);
		shell.setText("SWT Application");

	}

}

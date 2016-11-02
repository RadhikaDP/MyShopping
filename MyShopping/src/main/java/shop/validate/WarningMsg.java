package shop.validate;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class WarningMsg {
	
	public static void showDialog(String msg){
	JOptionPane optionPane = new JOptionPane(msg,JOptionPane.WARNING_MESSAGE);
	JDialog dialog = optionPane.createDialog("Warning!");
	dialog.setAlwaysOnTop(true); // to show top of all other application
	dialog.setVisible(true);
	}
}

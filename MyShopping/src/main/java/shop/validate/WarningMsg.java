package shop.validate;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class WarningMsg {
	
	public static void showDialog(String msg){
	JOptionPane optionPane = new JOptionPane(msg,JOptionPane.PLAIN_MESSAGE);
	JDialog dialog = optionPane.createDialog("Message!");
	dialog.setAlwaysOnTop(true); // to show top of all other application
	dialog.setVisible(true);
	}
}

package com.company.utils.ui.box;

import javax.swing.*;

public class ErrorDialog {
	public static void errorDialog(String errorTitle,String errorMessage){
		JOptionPane.showMessageDialog(null,errorMessage,errorTitle,JOptionPane.ERROR_MESSAGE);
	}
}

package com.company.utils.ui.promptbox;

import javax.swing.*;

public class ErrorDialog {
	public static void errorDialog(String errorTop,String errorMessage){
		JOptionPane.showMessageDialog(null,errorMessage,errorTop,JOptionPane.ERROR_MESSAGE);
	}
}

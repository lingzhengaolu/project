package com.company.utils;

import javax.swing.*;
import java.io.File;

public class SelectFilePublic {
	public String PATH=null;
	public SelectFilePublic(){
		while (PATH==null){
			try{
				JFileChooser fd=new JFileChooser();
				fd.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fd.setMultiSelectionEnabled(false);
				fd.showDialog(null,"选择");
				File file=fd.getSelectedFile();
				PATH=file.getAbsolutePath();
			}catch (Exception e){
				PATH=null;
			}
		}

	}
}

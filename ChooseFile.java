package uidesign;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

public class ChooseFile {
	JFrame frame;
	
	public ChooseFile(JFrame frame){

	}
	public void chooseFile(boolean bcomboBox, boolean checkBox, int textField){
		JFileChooser fc = new JFileChooser("Save Text File");
		fc.addChoosableFileFilter(new FileFilter() {
			public String getDescription() {
				return "Text Files (*.txt)";
			}
			public boolean accept(File f){
				if (f.isDirectory()) {
					return true;
				}
				else{
					String filename = f.getName().toLowerCase();
					return filename.endsWith(".txt");
				}
			}
		});
		fc.setAcceptAllFileFilterUsed(false);
		fc.setSelectedFile(new File("GameSettings.txt"));
		if(fc.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION){
			WriteOut wrout = new WriteOut(new File(fc.getSelectedFile().getAbsolutePath()), bcomboBox, checkBox, textField);
				try {
					wrout.printIt();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}

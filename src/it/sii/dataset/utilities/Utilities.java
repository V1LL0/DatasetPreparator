package it.sii.dataset.utilities;

import java.io.File;

public class Utilities {

	public Utilities(){}
	
	public boolean percentageGuidedBoolean(double percentage){
		if(Math.random() <= percentage)
			return true;
		else	
			return false;
	}
	
	
	
	private boolean isUnixFileSystem() {
		if (System.getProperty("os.name").toLowerCase().contains("windows"))
			return false;			
		return true;
		}

	/**
 * Crea un nuova istanza di file, occupandosi di capire il sistema operativo sottostante (Unix o Windows)
 * @return
 */
	
	public File newFileIstance(String abstractPath){
		final String completeTrainingBackupFilePath;
		if (this.isUnixFileSystem())
			completeTrainingBackupFilePath = System.getProperty("user.dir") + "/" + abstractPath;
		else
			completeTrainingBackupFilePath = System.getProperty("user.dir") + "\\" + abstractPath;
		return new File(completeTrainingBackupFilePath);
	}

	
	
}

package it.sii.dataset.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	 */
	
	public File newFileIstance(String abstractPath){
		final String completeTrainingBackupFilePath;
		if (this.isUnixFileSystem())
			completeTrainingBackupFilePath = System.getProperty("user.dir") + "/" + abstractPath;
		else
			completeTrainingBackupFilePath = System.getProperty("user.dir") + "\\" + abstractPath;
		return new File(completeTrainingBackupFilePath);
	}

	
	
	public void writeLineTestAndResult(String line, FileWriter writerTest, FileWriter writerResults){
		
		String[] jsonParts = line.split(",");
		String stars = jsonParts[5].split(": ")[1];
		String businessID = jsonParts[jsonParts.length-1].split(": ")[1].split("}")[0].split("\"")[1];
		String userID = jsonParts[3].split(": ")[1].split("\"")[1];
		
		
		try {
			writerTest.write(userID+"\t"+businessID+"\n");
			writerResults.write(stars+"\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}

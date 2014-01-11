package it.sii.dataset;

import it.sii.dataset.utilities.Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DatasetPreparator {

	
	public void createPercentageOfDataset(String fileDatasetName, double percentage){
		
		Utilities utilities = new Utilities();
		
		String fileDSExtension = fileDatasetName.split("\\.")[0];
		
		File fileDataset = utilities.newFileIstance(fileDatasetName);
		
		File fileResult = utilities.newFileIstance(fileDSExtension+"_training.json");
		File fileTestResult = utilities.newFileIstance(fileDSExtension+"_test.json");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileDataset));
			FileWriter writer = new FileWriter(fileResult);
			FileWriter writerTest = new FileWriter(fileTestResult);
			
			while(reader.ready()){
				String line = reader.readLine();
				if(utilities.percentageGuidedBoolean(percentage))
					writer.write(line);		
				else
					writerTest.write(line);
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
		
	
	public static void main(String[] args) {
		
		DatasetPreparator preparator = new DatasetPreparator();
		double percentage = 0.7;
		
		String fileDatasetUserName="full_dataset/user.json";
		String fileDatasetBusinessName="full_dataset/business.json";
		String fileDatasetReviewName="full_dataset/review.json";
		
		preparator.createPercentageOfDataset(fileDatasetUserName, percentage);
		preparator.createPercentageOfDataset(fileDatasetBusinessName, percentage);
		preparator.createPercentageOfDataset(fileDatasetReviewName, percentage);
		
		
		
	}



}
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
		
		String fileDS_NoExtension = fileDatasetName.split("\\.")[0];
		
		File fileDataset = utilities.newFileIstance(fileDatasetName);
		
		File fileResult = utilities.newFileIstance(fileDS_NoExtension+"_training.json");
		File fileTestResult = utilities.newFileIstance(fileDS_NoExtension+"_test.json");
		File fileResultsResult = utilities.newFileIstance(fileDS_NoExtension+"_result.json");
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileDataset));
			FileWriter writer = new FileWriter(fileResult);
			FileWriter writerTest = new FileWriter(fileTestResult);
			FileWriter writerResults = new FileWriter(fileResultsResult);
			
			
			while(reader.ready()){
				String line = reader.readLine();
				if(utilities.percentageGuidedBoolean(percentage))
					writer.write(line+"\n");		
				else{
					utilities.writeLineTestAndResult(line, writerTest, writerResults);
				}
			}
			
	/**
	 * Prove di stampa:		
	 */
			/**
			BufferedReader readerFinal = new BufferedReader(new FileReader(fileDS_NoExtension+"_test.json"));
			BufferedReader readerFinalResults = new BufferedReader(new FileReader(fileDS_NoExtension+"_result.json"));
			System.out.println("TEST:");
			for(int i=0; i<20; i++){
				System.out.println(readerFinal.readLine());
			}
			System.out.println("\n\n\nRESULTS: ");
			for(int i=0; i<20; i++){
				System.out.println(readerFinalResults.readLine());
			}
			**/

			
		
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
		
//		String fileDatasetUserName="full_dataset/user.json";
//		String fileDatasetBusinessName="full_dataset/business.json";
		String fileDatasetReviewName="full_dataset/review.json";
		
//		preparator.createPercentageOfDataset(fileDatasetUserName, percentage);
//		preparator.createPercentageOfDataset(fileDatasetBusinessName, percentage);
		preparator.createPercentageOfDataset(fileDatasetReviewName, percentage);
		
	
		/***
		 * Prove di stampa:		
		 */
		/**
		BufferedReader readerFinal;
		try {
			readerFinal = new BufferedReader(new FileReader(fileDatasetReviewName));
			
			for(int i=0; i<20; i++){
				System.out.println(readerFinal.readLine());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/
	
		
	}



}
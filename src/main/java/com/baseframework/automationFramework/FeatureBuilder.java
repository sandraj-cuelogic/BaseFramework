package com.baseframework.automationFramework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FeatureBuilder {

	
	static File f = new File(".//Feature");
	static File[] files = f.listFiles();
	static File file;
	static File createdFile;

	public static void main(String[] args) throws IOException{
		AutomationLog log = AutomationLog.getAutomationLog();

		String browserCount = "3";
		
		try {
			if (files != null) {
				int fileLength = files.length;
				System.out.println(fileLength + "fileLength");
				for (int i = 0; i < fileLength; i++) {
					// count++;
					file = files[i];
					if (!(files[i].getName().contains(".feature"))) {
						System.out.println(files[i].getName() + "===========================");

						for (int j = 0; j <= Integer.parseInt(browserCount); j++) {
							if (j == 0) {
								System.out.println("j is 0");
								createdFile = createFileWithContent("chrome_"+files[i].getName(), files[i]);
								// create feature files for chrome
								modifyFileContent(createdFile.toString(), "chrome");
								System.out.println("chrome_"+files[i].getName() + "--------------------------");
//								String[] featureName= createdFile.getName().split(".");
//								System.out.println(featureName.length + "*********************");
								replaceContent(createdFile.toString(), "FeatureFileName", "chrome_"+files[i].getName());
							}
							if (j == 1) {
								System.out.println("j is 1");

								// create feature files for firefox
								createdFile = createFileWithContent("firefox_"+files[i].getName(),files[i]);
								modifyFileContent(createdFile.toString(), "firefox");
//								String featureName[] = createdFile.getName().split(".");
								replaceContent(createdFile.toString(), "FeatureFileName", "firefox_"+files[i].getName());

							}
							if (j == 2) {
								System.out.println("j is 2");

								// create feature files for IE
								createdFile = createFileWithContent("ie_"+files[i].getName(), files[i]);
								modifyFileContent(createdFile.toString(), "ie");
//								String featureName[] = createdFile.getName().split(".");
								replaceContent(createdFile.toString(), "FeatureFileName", "ie_"+files[i].getName());

							}
						}
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw e;
		}

	}
	
	static File outfile;
	public static File createFileWithContent(String featureFileName, File templateFile) throws IOException{
		System.out.println(featureFileName);
		File createFeatureFile = new File(".//Feature/"+featureFileName+".feature");
		if(createFeatureFile.createNewFile()){
			System.out.println("file was created");
			FileWriter writer = new FileWriter(createFeatureFile);
			FileInputStream instream = null;
			FileOutputStream outstream = null;
			String fileLocation = ".//Feature/" + featureFileName + ".feature";
			try {
				File infile = new File(templateFile.toString());
				System.out.println(templateFile.toString());
				outfile = new File(fileLocation);

				instream = new FileInputStream(infile);
				outstream = new FileOutputStream(outfile);

				byte[] buffer = new byte[1024];
				
				int length;
				/*
				 * copying the contents from input stream to output stream using read and write
				 * methods
				 */
				while ((length = instream.read(buffer)) >= 1) {
					outstream.write(buffer, 0, length);
					
					System.out.println(length + "                     " + instream.read(buffer));
				}
				// Closing the input/output file streams
				instream.close();
				outstream.close();
				System.out.println("Feature File created");
		} catch(Exception e){
			System.out.println(e);
		}
		}
		return outfile;
	}
	
	public static void modifyFileContent(String createdFile, String browserName){
		
		BufferedWriter bufferedWriter = null;
		FileWriter fileWriter = null;
		System.out.println(createdFile + "=========================");
		
		try{
			String data = "| " +browserName+ " |";
			File fileToBeModified = new File(createdFile);
			fileWriter = new FileWriter(fileToBeModified.getAbsoluteFile(), true);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write('\n'+ data);
			System.out.println("done");
			
		} catch(Exception e){
			System.out.println(e);
		}finally {

			try {

				if (bufferedWriter != null)
					bufferedWriter.close();

				if (fileWriter != null)
					fileWriter.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		
	}
	
	static void replaceContent(String filePath, String oldString, String newString) {
		File fileToBeModified = new File(filePath);
		String oldContent = "";
		BufferedReader reader = null;
		FileWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));

			// Reading all the lines of input text file into oldContent

			String line = reader.readLine();

			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();

				line = reader.readLine();
			}

			// Replacing oldString with newString in the oldContent

			String newContent = oldContent.replaceAll(oldString, newString);

			// Rewriting the input text file with newContent

			writer = new FileWriter(fileToBeModified);

			writer.write(newContent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the resources

				reader.close();

				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}

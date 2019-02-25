package com.baseframework.automationFramework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestRunnerBuilder {
	private static final String TAG = TestRunnerBuilder.class.getSimpleName();
	
	public static void main(String[] args) throws Exception {
		AutomationLog log = AutomationLog.getAutomationLog();

		File f = new File(".//Feature");
		File[] files = f.listFiles();
		
		int count = 0;
		try {
			if (files != null) {
				int fileLength = files.length;
				for (int i = 0; i < fileLength; i++) {
					// count++;
					File file = files[i];
					if (files[i].getName().endsWith(".feature")) {
						String[] featureFileNameSplit = files[i].getName().split("\\.");
						String TestRunnerFileName = featureFileNameSplit[0].toString();
						System.out.println(TestRunnerFileName);
						File createRunnerFile = new File(AutomationConfiguration.getConfigurationValueForProperty("testRunnerFolder")+TestRunnerFileName+".java");
						if (createRunnerFile.createNewFile()) {
							FileWriter writer = new FileWriter(createRunnerFile);
							FileInputStream instream = null;
							FileOutputStream outstream = null;
							String fileLocation = AutomationConfiguration.getConfigurationValueForProperty("testRunnerFolder") + TestRunnerFileName + ".java";
							try {
								File infile = new File(AutomationConfiguration.getConfigurationValueForProperty("testRunnerTemplateFolder"));
								File outfile = new File(fileLocation);

								instream = new FileInputStream(infile);
								outstream = new FileOutputStream(outfile);

								byte[] buffer = new byte[1024];

								int length;
								/*
								 * copying the contents from input stream to output stream using read and write
								 * methods
								 */
								while ((length = instream.read(buffer)) > 0) {
									outstream.write(buffer, 0, length);
								}

								// Closing the input/output file streams
								instream.close();
								outstream.close();
								log.info("TestRunner file created : " +TestRunnerFileName);
							} catch (IOException ioe) {
								ioe.printStackTrace();
							}
							
							modifyFile(fileLocation, "TestRunner", TestRunnerFileName);
						
						} else {
							log.error("Runner files not created");
						}
					}
				}
			}

		} catch (Exception e) {
			throw e;
		}

	}

	static void modifyFile(String filePath, String oldString, String newString) {
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
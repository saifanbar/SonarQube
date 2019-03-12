package org.sonar.samples.filecounter;
import java.io.*;


//class reads from the txt file, when given the file path
public class TextFileReader {

	//contains the filepath for the txtfile
	private String filepath;
	
	public TextFileReader() {
		filepath = "";
	}
	
	public TextFileReader(String filepath) {
		this.filepath = filepath;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	//could add in a string variable to read in what type of file/file path it is looking for
	public String returnWarFilePath() throws Exception {
		
		File file = new File(this.filepath);
		
		BufferedReader fileReader = new BufferedReader(new FileReader(file));

		String warPath = "";
		String line;
		   
		  while ((line = fileReader.readLine()) != null) 
		  {
		    
			warPath = line;
		  }
		fileReader.close();
		return warPath;
	}
}


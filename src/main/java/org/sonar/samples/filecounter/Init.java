package org.sonar.samples.filecounter;
import java.io.File;
import java.io.IOException;
import java.util.Properties;


 

public class Init {
	
	private TextFileReader textFileReader;
	private FileCounter fileCounter;
	private Unzip unzip;
	
	private File webInfFileObj;
	private File jspFileObj;
	
	private String textFilePath = "C:\\Users\\SA20018601\\Desktop\\ship2";
	
	private String destPath;
	private String webInfPath = "";
	private String jspPath = "";
	private int finalCount;
	private int finalJavaCount;
	
	public Init() throws Exception {
		textFileReader = new TextFileReader("C:\\Users\\SA20018601\\Desktop\\FileCounterPractice.txt");
		String warFilePath = textFileReader.returnWarFilePath();
		unzip = new Unzip(warFilePath, textFilePath);
		fileCounter = new FileCounter();
		
	}
	
	public int getFinalCount() {
		return finalCount;
	}
	
	public int getFinalJavaCount() {
		return finalJavaCount;
	}

	public void run(boolean switchOnOff) throws IOException{
		// method call to unzip war file
		if(switchOnOff) {			
			unzip.fileUnzip();
		} else {
			System.out.println("Switch set to: " + switchOnOff);
		}
		// gets the path of destination folder to where the file will be unzipped
		destPath = unzip.getDestPath();
		
		// creates a new File object of the webInf folder that is within the destination folder
		webInfFileObj = new File(destPath);
		
		// finds the WEB-INF file path
		webInfPath = fileCounter.findFile(webInfFileObj, "WEB-INF");
		System.out.println(webInfPath);
		
		// creates a new File object of the jsp folder that is within the WEB-INF folder
		jspFileObj = new File(webInfPath);
		
		// finds the jsp file path
		jspPath = fileCounter.findFile(jspFileObj, "_jsp");
		System.out.println(jspPath);
		
		// creates a new File object of jsp.Class that is within _jsp folder
		File jspClassFileObj = new File(jspPath);
		
		// calls counter() that gets the count of all _jsp.Class files
		finalCount = fileCounter.counter(jspClassFileObj, "^__.*\\.class$");
		
		finalJavaCount = fileCounter.counter(jspClassFileObj, "^__.*\\.class$");
		
		System.out.println("The amount of __jsp.class files is: " + finalCount);
		System.out.println("The amount of __jsp.java files is: " + finalJavaCount);
	}

}

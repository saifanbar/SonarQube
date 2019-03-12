package org.sonar.samples.filecounter;
import java.io.*;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import com.google.common.base.Stopwatch;


//class will unzip the given file from the file path
public class Unzip {
	
	//filepath that is zipped
	private String filePath;
	
	//destination path
	private String destPath;

	public Unzip(String filePath, String destPath) {

		this.filePath = filePath;
		this.destPath = destPath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getDestPath() {
		return destPath;
	}
	
	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	
	
	
		public void fileUnzip() throws IOException {
		
		Stopwatch timer = Stopwatch.createStarted();
			
		JarFile jarfile = new JarFile(new File(filePath)); 
	    Enumeration<JarEntry> jarEntry= jarfile.entries();
	    while(jarEntry.hasMoreElements())
	    {
	    	
	        String destdir = destPath;     
	        JarEntry je = jarEntry.nextElement();

	        System.out.println(je.getName());

	        File fl = new File(destdir, je.getName());
	        if(!fl.exists())
	        {
	            fl.getParentFile().mkdirs();
	            fl = new File(destdir, je.getName());
	        }
	        if(je.isDirectory())
	        {
	            continue;
	        }
	        InputStream is = jarfile.getInputStream(je);
	        FileOutputStream fo = new FileOutputStream(fl);
	        while(is.available()>0)
	        {
	            fo.write(is.read());
	        }
	        fo.close();
	        is.close();
	       
	        
	    }
	    System.out.println("It took " + timer.stop() + " to unzip file");
	    System.out.println(getFilePath() + " has been unzipped to " + getDestPath());
	    jarfile.close();
		
	}
	

}

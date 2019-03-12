package org.sonar.samples.filecounter;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;


public class FileCounter {

	private static int counter;
	
	
	public FileCounter() {
		counter = 0;
		
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}


	public String findFile(File start, String targetDirectory) {
		
		String found = null;
		String temp = null;
		File files[] = start.listFiles();
		for(File f: files) {
			if(f.isDirectory()) {
				if(f.getName().equals(targetDirectory)) {
					found = f.getAbsolutePath();
				}
				else {
					temp = findFile(f, targetDirectory);
					if(temp != null) {
						found = temp;
					}
				}
				
			}
		}
		return found;		
	}
	
	public int counter(File start, String targetFile) {
		
		int count = 0;
		
		File files[] = start.listFiles();
		for(File f: files) {
			if(f.isDirectory()) {
				
				count += counter(f, targetFile);
			} else {
				boolean doesItMatch = Pattern.matches(targetFile, f.getName());
				if(doesItMatch) {
					
					count++;
				}
			}
		}
		return count;
	}
		
}

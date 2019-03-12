package org.sonar.samples.java;

import static org.junit.Assert.*;

import org.junit.Test;
import org.sonar.samples.filecounter.FileCounter;
import org.sonar.samples.filecounter.Init;

public class fileCountTest {

	
	
	
	
	@Test
	public void test() throws Exception{
		
		
		Init init = new Init();
		
		init.run(false);
		
		
			if(init.getFinalCount() != init.getFinalJavaCount()) {
				fail(".Java files not compiled to .Class files");
			}
		}
	}



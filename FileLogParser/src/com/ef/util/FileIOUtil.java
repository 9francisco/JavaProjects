package com.ef.util;
/*
 * 		
 * 09/09/2018	Gerald Francisco 	Created FileIOUtil class get file contents		LogFileParser Project	
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import org.apache.log4j.Logger;

public class FileIOUtil {
	static Logger logger = Logger.getLogger(FileIOUtil.class);
	
	public Vector<String> getContentList(File aFile) {
		Vector<String> contents = new Vector<String>();
		
		try {
			BufferedReader input =  new BufferedReader(new FileReader(aFile));
			try {
				String line = null;
				while (( line = input.readLine()) != null) {
					contents.add(line);
				}
		    } finally {
		    	input.close();
		    }
	    } catch (IOException e){
	    	logger.error(e);
	    }
	    
	    return contents;
	 }
		
}

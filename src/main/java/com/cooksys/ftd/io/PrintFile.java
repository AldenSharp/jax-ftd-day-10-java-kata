package com.cooksys.ftd.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintFile {
	
	private static Logger log = LoggerFactory.getLogger(PrintFile.class);
	
	public static void main() throws FileNotFoundException, IOException {
		try (InputStream in = new FileInputStream("C:\\stupid-test-resources\\input.txt");) {
			int c;
/*			String outstring = "";
			while((c = in.read()) != -1) {
				outstring += in.readLine
			} */
			log.debug("PrintFile main method called.");
			//return outstring;
		}
	}

}

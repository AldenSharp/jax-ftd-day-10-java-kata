package com.cooksys.ftd.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopyFile {
	
	private static Logger log = LoggerFactory.getLogger(CopyFile.class);
	
	public static void main() throws FileNotFoundException, IOException {
		try (InputStream in = new FileInputStream("C:\\stupid-test-resources\\input.txt");
				OutputStream out = new FileOutputStream("C:\\stupid-test-resources\\output.txt");) {
			int c;
			while((c = in.read()) != -1) {
				out.write(c);
			}
			log.debug("CopyFile main method called.");
		}
	}

}

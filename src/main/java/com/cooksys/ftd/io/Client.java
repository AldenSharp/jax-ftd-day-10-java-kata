package com.cooksys.ftd.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client implements Runnable {

	private Logger log = LoggerFactory.getLogger(Client.class);

	private String hostname;
	private int port;
	private String[] messages;
	private PrintFile file;
	private boolean isFile;
	
	public Client(String hostname, int port, PrintFile file) {
		super();
		this.hostname = hostname;
		this.port = port;
		this.file = file;
		this.isFile = true;
	}

	public Client(String hostname, int port, String... messages) {
		super();
		this.hostname = hostname;
		this.port = port;
		this.messages = messages;
		this.isFile = false;
	}

	@Override
	public void run() {
		try (Socket server = new Socket(this.hostname, this.port);
				BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
				PrintWriter writer = new PrintWriter(server.getOutputStream(), true);) {
			
			if(isFile) {
				log.info("Sending server file: {}");
				BufferedReader br = null;
				String strLine = "";
				try {
					br = new BufferedReader(new FileReader("C:\\stupid-test-resources\\input.txt"));
					while((strLine = br.readLine()) != null) {
						log.info("Sending file line: {}", strLine);
						writer.println(strLine);
						log.info("Server responded with file line: {}", reader.readLine());
					}
				} catch (FileNotFoundException e) {
					log.error("Can't find the fileee");
				} catch (IOException e) {
					log.error("Can't read the filelee");
				}
			} else {
				// send a bunch of messages and read the responses
				for (String message : this.messages) {
					log.info("Sending server message: {}", message);
					writer.println(message);
					log.info("Server responded with message: {}", reader.readLine());
				}
			}
			
		} catch (IOException e) {
			log.error("client fail! oh noes :(", e);
		}
	}

}

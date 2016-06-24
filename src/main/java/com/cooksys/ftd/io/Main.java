package com.cooksys.ftd.io;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Server server = new Server(667);
	
		PrintFile file = new PrintFile();
		
		new Thread(server).start();

		List<Thread> clientThreads = new ArrayList<Thread>();

		clientThreads.add(new Thread(new Client("localhost", 667, "Here, have a file!")));
		clientThreads.add(new Thread(new Client("localhost", 667, file)));

		for (Thread t : clientThreads) {
			t.start();
		}

		for (Thread t : clientThreads) {
			t.join();
		}

		System.exit(0);
	}

}

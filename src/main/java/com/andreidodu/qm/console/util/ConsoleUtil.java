package com.andreidodu.qm.console.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ConsoleUtil {

	public static Map<Integer, String> scanCommandLine() throws IOException {
		//Console c = System.console();
		//String line = c.readLine();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String line = bufferedReader.readLine();
		
		Map<Integer, String> commands = new HashMap<>();
		int i = 0;
		String[] splitted = line.split("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?");
		while (i < splitted.length) {
			commands.put(i++, splitted[i - 1]);
		}
		return commands;
	}

}

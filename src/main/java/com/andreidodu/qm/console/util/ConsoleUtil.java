package com.andreidodu.qm.console.util;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class ConsoleUtil {

	public static Map<Integer, String> scanCommandLine() {
		Console c = System.console();
		String line = c.readLine();
		Map<Integer, String> commands = new HashMap<>();
		int i = 0;
		String[] splitted = line.split("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?");
		while (i < splitted.length) {
			commands.put(i++, splitted[i - 1]);
		}
		return commands;
	}

}

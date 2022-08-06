package com.andreidodu.qm.console;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.console.commands.Command;
import com.andreidodu.qm.console.constants.ConsoleConstants;

@Component
public class CommandProcessor {

	@Autowired
	List<Command> commands;

	public void process(Map<Integer, String> commands) {

		if (ConsoleConstants.EXIT_COMMAND.equalsIgnoreCase(commands.get(ConsoleConstants.MAIN_COMMAND))) {
			System.exit(0);
		}
		processQuestionnaireCommand(commands);
	}

	private void processQuestionnaireCommand(Map<Integer, String> commands) {
		System.out.println("==> Executor");
		boolean[] found = new boolean[1];
		this.commands.forEach(command -> {
			if (command.getCommand().equalsIgnoreCase(commands.get(ConsoleConstants.MAIN_COMMAND) + commands.get(ConsoleConstants.ACTION_COMMAND))) {
				command.execute(commands);
				found[0] = true;
				return;
			}
		});
		if (!found[0]) {
			System.out.println("Command not found");
		}
	}

}

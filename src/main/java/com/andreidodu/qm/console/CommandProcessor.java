package com.andreidodu.qm.console;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.andreidodu.qm.console.constants.ConsoleConstants;

@Component
public class CommandProcessor {

	private static final int MAIN_COMMAND = 0;
	private static final int ACTION_COMMAND = 1;

	public void process(Map<Integer, String> commands) {

		if (ConsoleConstants.EXIT_COMMAND.equalsIgnoreCase(commands.get(MAIN_COMMAND))) {
			System.exit(0);
		}
		if (ConsoleConstants.QUESTIONNAIRE_COMMAND.equalsIgnoreCase(commands.get(MAIN_COMMAND))) {
			processQuestionnaireCommand(commands);
		}
	}

	private void processQuestionnaireCommand(Map<Integer, String> commands) {
		String actionCommand = commands.get(ACTION_COMMAND);
		System.out.println("Questionnaire");
		if ("create".equalsIgnoreCase(actionCommand)) {
			System.out.println("Questionnaire creation selected");
			
		}else {
			System.out.println("Uknown command");
		}
	}

	public String generateRandomString(int length) {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		Random random = new Random();
		return random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(length).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}

}

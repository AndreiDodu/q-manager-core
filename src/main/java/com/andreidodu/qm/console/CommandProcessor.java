package com.andreidodu.qm.console;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.console.constants.ConsoleConstants;
import com.andreidodu.qm.dto.Questionnaire;
import com.andreidodu.qm.dto.input.QuestionnaireInsert;
import com.andreidodu.qm.service.QuestionnaireService;

@Component
public class CommandProcessor {

	@Autowired
	private QuestionnaireService questionnaireService;

	private static final int MAIN_COMMAND = 0;
	private static final int ACTION_COMMAND = 1;
	private static final int ARG0_COMMAND = 2;
	private static final int ARG1_COMMAND = 3;
	private static final int ARG2_COMMAND = 4;
	private static final int ARG3_COMMAND = 5;

	public void process(Map<Integer, String> commands) {

		if (ConsoleConstants.EXIT_COMMAND.equalsIgnoreCase(commands.get(MAIN_COMMAND))) {
			System.exit(0);
		}
		if (ConsoleConstants.QUESTIONNAIRE_COMMAND.equalsIgnoreCase(commands.get(MAIN_COMMAND))) {
			processQuestionnaireCommand(commands);
		}
	}

	private void processQuestionnaireCommand(Map<Integer, String> commands) {
		System.out.println("==> Questionnaire");
		if ("create".equalsIgnoreCase(commands.get(ACTION_COMMAND))) {
			System.out.println("==> Questionnaire creation selected");
			String title = this.isEmpty(commands.get(ARG0_COMMAND)) ? null : commands.get(ARG0_COMMAND);
			String help = this.isEmpty(commands.get(ARG1_COMMAND)) ? null : commands.get(ARG1_COMMAND);
			String languageCode = this.isEmpty(commands.get(ARG2_COMMAND)) ? null : commands.get(ARG2_COMMAND);

			QuestionnaireInsert questionnaireInsert = new QuestionnaireInsert(this.generateRandomString(10), title, help, languageCode);
			Questionnaire questionnaire = this.questionnaireService.create(questionnaireInsert);
			System.out.println("==> Questionnaire created: [" + questionnaire + "]");
		} else if ("update".equalsIgnoreCase(commands.get(ACTION_COMMAND))) {
			System.out.println("==> Questionnaire updating selected");
			String questionnaireCode = this.isEmpty(commands.get(ARG0_COMMAND)) ? null : commands.get(ARG0_COMMAND);
			String title = this.isEmpty(commands.get(ARG1_COMMAND)) ? null : commands.get(ARG1_COMMAND);
			String help = this.isEmpty(commands.get(ARG2_COMMAND)) ? null : commands.get(ARG2_COMMAND);
			String languageCode = this.isEmpty(commands.get(ARG3_COMMAND)) ? null : commands.get(ARG3_COMMAND);
			QuestionnaireInsert questionnaireInsert = new QuestionnaireInsert(questionnaireCode, title, help, languageCode);
			QuestionnaireInsert questionnaire = this.questionnaireService.update(questionnaireInsert);
			System.out.println("==> Questionnaire updated: [" + questionnaire + "]");
		} else if ("list".equalsIgnoreCase(commands.get(ACTION_COMMAND))) {
			System.out.println("==> Questionnaire list all");
			String languageCode = this.isEmpty(commands.get(ARG0_COMMAND)) ? null : commands.get(ARG0_COMMAND);
			List<QuestionnaireInsert> list = this.questionnaireService.getAll(languageCode);
			list.forEach(item -> {
				System.out.println(item);
			});
		} else if ("delete".equalsIgnoreCase(commands.get(ACTION_COMMAND))) {
			System.out.println("==> Questionnaire deletion selected");
			String questionnaireCode = this.isEmpty(commands.get(ARG0_COMMAND)) ? null : commands.get(ARG0_COMMAND);
			Boolean result = this.questionnaireService.delete(questionnaireCode);
			System.out.println("==> Questionnaire deletion status: " + result);
		} else {
			System.out.println("Uknown command");
		}
	}

	private boolean isEmpty(String string) {
		return string == null || "null".equalsIgnoreCase(string) || "$".equalsIgnoreCase(string) || string.trim().length() == 0;

	}

	public String generateRandomString(int length) {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 96; // letter 'z'
		Random random = new Random();
		return random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(length).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

}

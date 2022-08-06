package com.andreidodu.qm.console.commands;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.console.constants.ConsoleConstants;
import com.andreidodu.qm.console.util.ConsoleUtil;
import com.andreidodu.qm.console.util.QuestionnaireUtil;
import com.andreidodu.qm.dto.Questionnaire;
import com.andreidodu.qm.dto.input.QuestionnaireInsert;
import com.andreidodu.qm.service.QuestionnaireService;

@Component
public class CommandQuestionnaireCreate implements CommandQuestionnaire {

	private static final String COMMAND = "create";

	@Autowired
	private QuestionnaireService questionnaireService;

	@Override
	public String getCommand() {
		return COMMAND;
	}

	@Override
	public void execute(Map<Integer, String> commands) {
		System.out.println("==> Questionnaire creation selected");
		String title = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG0_COMMAND));
		String help = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG1_COMMAND));
		String languageCode = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG2_COMMAND));

		QuestionnaireInsert questionnaireInsert = new QuestionnaireInsert(QuestionnaireUtil.generateRandomString(10), title, help, languageCode);
		Questionnaire questionnaire = this.questionnaireService.create(questionnaireInsert);
		System.out.println("==> Questionnaire created: [" + questionnaire + "]");
	}

}

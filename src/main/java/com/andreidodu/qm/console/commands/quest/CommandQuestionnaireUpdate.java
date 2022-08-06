package com.andreidodu.qm.console.commands.quest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.console.commands.Command;
import com.andreidodu.qm.console.constants.ConsoleConstants;
import com.andreidodu.qm.console.util.ConsoleUtil;
import com.andreidodu.qm.dto.input.QuestionnaireInsert;
import com.andreidodu.qm.service.QuestionnaireService;

@Component
public class CommandQuestionnaireUpdate implements Command {

	private static final String COMMAND = "questionnaireUpdate";

	@Autowired
	private QuestionnaireService service;

	@Override
	public String getCommand() {
		return COMMAND;
	}

	@Override
	public void execute(Map<Integer, String> commands) {
		System.out.println("==> Questionnaire updating selected");
		String code = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG0_COMMAND));
		String title = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG1_COMMAND));
		String help = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG2_COMMAND));
		String languageCode = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG3_COMMAND));
		QuestionnaireInsert insertDto = new QuestionnaireInsert(code, title, help, languageCode);
		QuestionnaireInsert dto = this.service.update(insertDto);
		System.out.println("==> Questionnaire updated: [" + dto + "]");
	}

}

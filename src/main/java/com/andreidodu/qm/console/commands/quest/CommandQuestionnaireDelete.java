package com.andreidodu.qm.console.commands.quest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.console.commands.Command;
import com.andreidodu.qm.console.constants.ConsoleConstants;
import com.andreidodu.qm.console.util.ConsoleUtil;
import com.andreidodu.qm.service.QuestionnaireService;

@Component
public class CommandQuestionnaireDelete implements Command {

	private static final String COMMAND = "questionnaireDelete";

	@Autowired
	private QuestionnaireService service;

	@Override
	public String getCommand() {
		return COMMAND;
	}

	@Override
	public void execute(Map<Integer, String> commands) {
		System.out.println("==> Questionnaire deletion selected");
		String code = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG0_COMMAND));
		Boolean result = this.service.delete(code);
		System.out.println("==> Questionnaire deletion status: " + result);
	}

}

package com.andreidodu.qm.console.commands.group;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.console.commands.Command;
import com.andreidodu.qm.console.constants.ConsoleConstants;
import com.andreidodu.qm.console.util.ConsoleUtil;
import com.andreidodu.qm.console.util.QuestionnaireUtil;
import com.andreidodu.qm.dto.Group;
import com.andreidodu.qm.dto.input.GroupInsert;
import com.andreidodu.qm.service.GroupService;

@Component
public class CommandGroupCreate implements Command{

	private static final String COMMAND = "groupCreate";

	@Autowired
	private GroupService service;

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

		GroupInsert groupInsert = new GroupInsert(QuestionnaireUtil.generateRandomString(10), title, help, languageCode);
		Group group = this.service.create(groupInsert);
		System.out.println("==> Group created: [" + group + "]");
	}

}

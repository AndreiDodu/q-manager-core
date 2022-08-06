package com.andreidodu.qm.console.commands.section;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.console.commands.Command;
import com.andreidodu.qm.console.constants.ConsoleConstants;
import com.andreidodu.qm.console.util.ConsoleUtil;
import com.andreidodu.qm.console.util.QuestionnaireUtil;
import com.andreidodu.qm.dto.Section;
import com.andreidodu.qm.dto.input.SectionInsert;
import com.andreidodu.qm.service.SectionService;

@Component
public class CommandSectionCreate implements Command {

	private static final String COMMAND = "sectionCreate";

	@Autowired
	private SectionService service;

	@Override
	public String getCommand() {
		return COMMAND;
	}

	@Override
	public void execute(Map<Integer, String> commands) {
		System.out.println("==> Section creation selected");
		String title = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG0_COMMAND));
		String help = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG1_COMMAND));
		String languageCode = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG2_COMMAND));

		SectionInsert groupInsert = new SectionInsert(QuestionnaireUtil.generateRandomString(10), title, help, languageCode);
		Section dto = this.service.create(groupInsert);
		System.out.println("==> Section created: [" + dto + "]");
	}

}

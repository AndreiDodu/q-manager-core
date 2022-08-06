package com.andreidodu.qm.console.commands.section;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.console.commands.Command;
import com.andreidodu.qm.console.constants.ConsoleConstants;
import com.andreidodu.qm.console.util.ConsoleUtil;
import com.andreidodu.qm.dto.input.SectionInsert;
import com.andreidodu.qm.service.SectionService;

@Component
public class CommandSectionUpdate implements Command {

	private static final String COMMAND = "sectionUpdate";

	@Autowired
	private SectionService service;

	@Override
	public String getCommand() {
		return COMMAND;
	}

	@Override
	public void execute(Map<Integer, String> commands) {
		System.out.println("==> Section updating selected");
		String code = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG0_COMMAND));
		String title = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG1_COMMAND));
		String help = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG2_COMMAND));
		String languageCode = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG3_COMMAND));
		SectionInsert insertDTO = new SectionInsert(code, title, help, languageCode);
		SectionInsert dto = this.service.update(insertDTO);
		System.out.println("==> Section updated: [" + dto + "]");
	}

}

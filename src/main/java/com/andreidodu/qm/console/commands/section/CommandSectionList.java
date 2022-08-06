package com.andreidodu.qm.console.commands.section;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.console.commands.Command;
import com.andreidodu.qm.console.constants.ConsoleConstants;
import com.andreidodu.qm.console.util.ConsoleUtil;
import com.andreidodu.qm.dto.input.SectionInsert;
import com.andreidodu.qm.service.SectionService;

@Component
public class CommandSectionList implements Command {

	private static final String COMMAND = "sectionList";

	@Autowired
	private SectionService service;

	@Override
	public String getCommand() {
		return COMMAND;
	}

	@Override
	public void execute(Map<Integer, String> commands) {
		System.out.println("==> Section list all");
		String languageCode = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG0_COMMAND));
		List<SectionInsert> list = this.service.getAll(languageCode);
		list.forEach(item -> {
			System.out.println(item);
		});
	}

}

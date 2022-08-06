package com.andreidodu.qm.console.commands.group;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.console.commands.Command;
import com.andreidodu.qm.console.constants.ConsoleConstants;
import com.andreidodu.qm.console.util.ConsoleUtil;
import com.andreidodu.qm.dto.input.GroupInsert;
import com.andreidodu.qm.service.GroupService;

@Component
public class CommandGroupList implements Command {

	private static final String COMMAND = "groupList";

	@Autowired
	private GroupService service;

	@Override
	public String getCommand() {
		return COMMAND;
	}

	@Override
	public void execute(Map<Integer, String> commands) {
		System.out.println("==> Group list all");
		String languageCode = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG0_COMMAND));
		List<GroupInsert> list = this.service.getAll(languageCode);
		list.forEach(item -> {
			System.out.println(item);
		});
	}

}

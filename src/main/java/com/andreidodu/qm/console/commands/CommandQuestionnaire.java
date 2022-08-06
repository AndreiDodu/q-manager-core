package com.andreidodu.qm.console.commands;

import java.util.Map;

public interface CommandQuestionnaire {

	String getCommand();
	
	void execute(Map<Integer, String> commands);
}

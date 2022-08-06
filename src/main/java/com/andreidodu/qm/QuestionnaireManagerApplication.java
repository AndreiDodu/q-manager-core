package com.andreidodu.qm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andreidodu.qm.console.CommandProcessor;
import com.andreidodu.qm.console.util.ConsoleUtil;

@SpringBootApplication
public class QuestionnaireManagerApplication implements CommandLineRunner {

	@Autowired
	private CommandProcessor commandProcessor;

	public static void main(String[] args) {
		SpringApplication.run(QuestionnaireManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			this.commandProcessor.process(ConsoleUtil.scanCommandLine());
		}
	}

}

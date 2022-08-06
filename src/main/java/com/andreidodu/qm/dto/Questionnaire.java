package com.andreidodu.qm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Questionnaire extends Common {

	private Long id;
	private String questionnaireCode;
	private String titleCode;
	private String helpCode;

}

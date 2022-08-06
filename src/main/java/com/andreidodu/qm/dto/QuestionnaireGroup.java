package com.andreidodu.qm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionnaireGroup extends Common {

	private Long id;
	private Questionnaire questionnaire;
	private Group group;
	private Integer order;

}

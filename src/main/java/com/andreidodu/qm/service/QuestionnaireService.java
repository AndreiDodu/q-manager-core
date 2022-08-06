package com.andreidodu.qm.service;

import com.andreidodu.qm.dto.Questionnaire;
import com.andreidodu.qm.dto.input.QuestionnaireInsert;

public interface QuestionnaireService {

	public Questionnaire create(QuestionnaireInsert questionnaireIn);

	public QuestionnaireInsert update(QuestionnaireInsert questionnaireInsert);

}

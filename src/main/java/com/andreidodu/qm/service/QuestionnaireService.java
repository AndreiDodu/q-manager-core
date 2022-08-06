package com.andreidodu.qm.service;

import java.util.List;

import com.andreidodu.qm.dto.Questionnaire;
import com.andreidodu.qm.dto.input.QuestionnaireInsert;

public interface QuestionnaireService {

	public Questionnaire create(QuestionnaireInsert questionnaireIn);

	public QuestionnaireInsert update(QuestionnaireInsert questionnaireInsert);

	public List<QuestionnaireInsert> getAll(String languageCode);

	public Boolean delete(String questionnaireCode);

}

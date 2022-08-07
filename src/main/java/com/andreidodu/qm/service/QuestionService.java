package com.andreidodu.qm.service;

import java.util.List;

import com.andreidodu.qm.dto.Question;
import com.andreidodu.qm.dto.input.QuestionInsert;

public interface QuestionService {

	Question create(QuestionInsert groupInsert);

	Boolean delete(String questionCode);

	List<QuestionInsert> getAll(String languageCode);

	QuestionInsert getByCode(String code, String languageCode);

	Question update(QuestionInsert groupInsert);

}

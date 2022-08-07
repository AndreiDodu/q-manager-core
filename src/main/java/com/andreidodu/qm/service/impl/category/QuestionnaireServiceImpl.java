package com.andreidodu.qm.service.impl.category;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.db.QuestionnaireDB;
import com.andreidodu.qm.dto.Questionnaire;
import com.andreidodu.qm.dto.input.QuestionnaireInsert;
import com.andreidodu.qm.mapper.QuestionnaireMapper;
import com.andreidodu.qm.service.category.QuestionnaireService;
import com.andreidodu.qm.service.impl.common.CategoryCommonServiceImpl;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionnaireServiceImpl extends CategoryCommonServiceImpl<QuestionnaireDB, Long, Questionnaire, QuestionnaireInsert, QuestionnaireMapper> implements QuestionnaireService {

	public QuestionnaireServiceImpl() {
		super(Questionnaire.class, QuestionnaireInsert.class);
	}

}

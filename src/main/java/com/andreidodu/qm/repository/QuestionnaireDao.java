package com.andreidodu.qm.repository;

import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.QuestionnaireDB;
import com.andreidodu.qm.repository.common.CategoryCommonDao;

@Repository
public interface QuestionnaireDao extends CategoryCommonDao<QuestionnaireDB, Long> {

	QuestionnaireDB findByCode(String questionnaireCode);

}

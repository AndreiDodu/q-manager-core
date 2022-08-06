package com.andreidodu.qm.repository;

import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.QuestionnaireDB;

@Repository
public interface QuestionnaireDao extends CommonDao<QuestionnaireDB, Long> {

	QuestionnaireDB findByCode(String questionnaireCode);

}

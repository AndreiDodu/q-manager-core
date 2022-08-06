package com.andreidodu.qm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.QuestionnaireDB;

@Repository
public interface QuestionnaireDao extends CrudRepository<QuestionnaireDB, Long> {

	QuestionnaireDB findByQuestionnaireCode(String questionnaireCode);

}

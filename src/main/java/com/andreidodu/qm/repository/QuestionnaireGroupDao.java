package com.andreidodu.qm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.QuestionnaireGroupDB;

@Repository
public interface QuestionnaireGroupDao extends CrudRepository<QuestionnaireGroupDB, Long> {

}

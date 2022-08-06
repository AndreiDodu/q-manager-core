package com.andreidodu.qm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.QuestionDB;

@Repository
public interface QuestionDao extends CrudRepository<QuestionDB, Long> {

}

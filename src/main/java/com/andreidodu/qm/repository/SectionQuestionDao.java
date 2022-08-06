package com.andreidodu.qm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.SectionQuestionDB;

@Repository
public interface SectionQuestionDao extends CrudRepository<SectionQuestionDB, Long> {

}

package com.andreidodu.qm.repository;

import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.SectionQuestionDB;
import com.andreidodu.qm.repository.common.AssociationCommonDao;

@Repository(value = "sectionquestionDao")
public interface SectionQuestionDao extends AssociationCommonDao<SectionQuestionDB, Long> {

}

package com.andreidodu.qm.repository;

import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.QuestionnaireGroupDB;
import com.andreidodu.qm.repository.common.AssociationCommonDao;

@Repository(value = "questionnairegroupDao")
public interface QuestionnaireGroupDao extends AssociationCommonDao<QuestionnaireGroupDB, Long> {

}

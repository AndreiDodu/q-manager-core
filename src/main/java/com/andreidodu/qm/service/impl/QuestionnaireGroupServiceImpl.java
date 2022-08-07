package com.andreidodu.qm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.db.QuestionnaireGroupDB;
import com.andreidodu.qm.dto.QuestionnaireGroup;
import com.andreidodu.qm.dto.input.common.AssociationInsert;
import com.andreidodu.qm.mapper.common.CommonMapper;
import com.andreidodu.qm.service.QuestionnaireGroupService;
import com.andreidodu.qm.service.impl.common.AssociationCommonServiceImpl;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionnaireGroupServiceImpl extends AssociationCommonServiceImpl<QuestionnaireGroup, QuestionnaireGroupDB, Long, CommonMapper<QuestionnaireGroupDB,AssociationInsert,AssociationInsert>> implements QuestionnaireGroupService {
	
	public QuestionnaireGroupServiceImpl() {
		super(QuestionnaireGroup.class);
	}

}

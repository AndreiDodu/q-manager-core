package com.andreidodu.qm.service.impl.association;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.db.QuestionnaireGroupDB;
import com.andreidodu.qm.dto.QuestionnaireGroup;
import com.andreidodu.qm.mapper.QuestGroupMapper;
import com.andreidodu.qm.service.association.QuestionnaireGroupService;
import com.andreidodu.qm.service.impl.common.AssociationCommonServiceImpl;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionnaireGroupServiceImpl extends AssociationCommonServiceImpl<QuestionnaireGroup, QuestionnaireGroupDB, Long, QuestGroupMapper> implements QuestionnaireGroupService {
	
	public QuestionnaireGroupServiceImpl() {
		super(QuestionnaireGroup.class);
	}

}

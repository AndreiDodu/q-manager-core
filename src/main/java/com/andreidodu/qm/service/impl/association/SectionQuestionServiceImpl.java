package com.andreidodu.qm.service.impl.association;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.db.SectionQuestionDB;
import com.andreidodu.qm.dto.SectionQuestion;
import com.andreidodu.qm.mapper.SectionQuestionMapper;
import com.andreidodu.qm.service.association.SectionQuestionService;
import com.andreidodu.qm.service.impl.common.AssociationCommonServiceImpl;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SectionQuestionServiceImpl extends AssociationCommonServiceImpl<SectionQuestion, SectionQuestionDB, Long, SectionQuestionMapper>
		implements SectionQuestionService {

	public SectionQuestionServiceImpl() {
		super(SectionQuestion.class);
	}

}

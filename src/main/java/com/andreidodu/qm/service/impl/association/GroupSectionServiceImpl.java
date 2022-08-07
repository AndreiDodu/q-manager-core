package com.andreidodu.qm.service.impl.association;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.db.GroupSectionDB;
import com.andreidodu.qm.dto.GroupSection;
import com.andreidodu.qm.mapper.GroupSectionMapper;
import com.andreidodu.qm.service.association.GroupSectionService;
import com.andreidodu.qm.service.impl.common.AssociationCommonServiceImpl;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GroupSectionServiceImpl extends AssociationCommonServiceImpl<GroupSection, GroupSectionDB, Long,GroupSectionMapper> implements GroupSectionService {

	public GroupSectionServiceImpl() {
		super(GroupSection.class);
	}

}

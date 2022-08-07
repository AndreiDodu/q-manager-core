package com.andreidodu.qm.service.impl.category;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.db.GroupDB;
import com.andreidodu.qm.dto.Group;
import com.andreidodu.qm.mapper.GroupMapper;
import com.andreidodu.qm.service.category.GroupService;
import com.andreidodu.qm.service.impl.common.CategoryCommonServiceImpl;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GroupServiceImpl extends CategoryCommonServiceImpl<GroupDB, Long, Group, GroupMapper> implements GroupService {

	public GroupServiceImpl() {
		super(Group.class);
	}

}

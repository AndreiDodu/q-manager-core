package com.andreidodu.qm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.db.GroupDB;
import com.andreidodu.qm.dto.Group;
import com.andreidodu.qm.dto.input.GroupInsert;
import com.andreidodu.qm.mapper.GroupMapper;
import com.andreidodu.qm.repository.GroupDao;
import com.andreidodu.qm.service.GroupService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GroupServiceImpl extends CommonServiceImpl<GroupDB, Long, Group, GroupInsert, GroupDao, GroupMapper> implements GroupService {

	public GroupServiceImpl() {
		super(Group.class, GroupInsert.class);
	}

}

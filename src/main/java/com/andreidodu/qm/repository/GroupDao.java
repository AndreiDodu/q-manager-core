package com.andreidodu.qm.repository;

import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.GroupDB;
import com.andreidodu.qm.repository.common.CategoryCommonDao;

@Repository
public interface GroupDao extends CategoryCommonDao<GroupDB, Long> {

	GroupDB findByCode(String code);

}

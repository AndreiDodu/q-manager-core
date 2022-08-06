package com.andreidodu.qm.repository;

import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.GroupDB;

@Repository
public interface GroupDao extends CommonDao<GroupDB, Long> {

	GroupDB findByCode(String code);

}

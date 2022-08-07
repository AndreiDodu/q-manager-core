package com.andreidodu.qm.repository;

import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.GroupSectionDB;
import com.andreidodu.qm.repository.common.AssociationCommonDao;

@Repository
public interface GroupSectionDao extends AssociationCommonDao<GroupSectionDB, Long> {

}

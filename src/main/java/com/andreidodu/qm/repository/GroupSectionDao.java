package com.andreidodu.qm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.GroupSectionDB;

@Repository
public interface GroupSectionDao extends CrudRepository<GroupSectionDB, Long> {

}

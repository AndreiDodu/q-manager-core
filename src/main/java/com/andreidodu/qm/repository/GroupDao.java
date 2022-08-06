package com.andreidodu.qm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.GroupDB;

@Repository
public interface GroupDao extends CrudRepository<GroupDB, Long> {

}

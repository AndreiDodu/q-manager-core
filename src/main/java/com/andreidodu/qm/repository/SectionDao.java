package com.andreidodu.qm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.SectionDB;

@Repository
public interface SectionDao extends CrudRepository<SectionDB, Long> {

}

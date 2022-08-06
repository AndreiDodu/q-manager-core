package com.andreidodu.qm.repository;

import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.SectionDB;

@Repository
public interface SectionDao extends CommonDao<SectionDB, Long> {

	SectionDB findByCode(String code);

}

package com.andreidodu.qm.repository;

import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.SectionDB;
import com.andreidodu.qm.repository.common.CategoryCommonDao;

@Repository
public interface SectionDao extends CategoryCommonDao<SectionDB, Long> {

	SectionDB findByCode(String code);

}

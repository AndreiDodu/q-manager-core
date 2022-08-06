package com.andreidodu.qm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.db.SectionDB;
import com.andreidodu.qm.dto.Section;
import com.andreidodu.qm.dto.input.SectionInsert;
import com.andreidodu.qm.mapper.SectionMapper;
import com.andreidodu.qm.service.SectionService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SectionServiceImpl extends CommonServiceImpl<SectionDB, Long, Section, SectionInsert, SectionMapper> implements SectionService {

	public SectionServiceImpl() {
		super(Section.class, SectionInsert.class);
	}

}

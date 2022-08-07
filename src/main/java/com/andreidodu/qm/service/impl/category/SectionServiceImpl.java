package com.andreidodu.qm.service.impl.category;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.db.SectionDB;
import com.andreidodu.qm.dto.Section;
import com.andreidodu.qm.mapper.SectionMapper;
import com.andreidodu.qm.service.category.SectionService;
import com.andreidodu.qm.service.impl.common.CategoryCommonServiceImpl;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SectionServiceImpl extends CategoryCommonServiceImpl<SectionDB, Long, Section, SectionMapper> implements SectionService {

	public SectionServiceImpl() {
		super(Section.class);
	}

}

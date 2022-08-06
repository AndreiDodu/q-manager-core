package com.andreidodu.qm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.andreidodu.qm.db.SectionDB;
import com.andreidodu.qm.dto.Section;
import com.andreidodu.qm.dto.input.SectionInsert;
import com.andreidodu.qm.mapper.common.CommonMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SectionMapper extends CommonMapper<SectionDB, Section, SectionInsert> {

}

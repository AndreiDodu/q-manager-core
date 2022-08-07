package com.andreidodu.qm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.andreidodu.qm.db.GroupSectionDB;
import com.andreidodu.qm.dto.input.common.AssociationInsert;
import com.andreidodu.qm.mapper.common.CommonMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GroupSectionMapper extends CommonMapper<GroupSectionDB, AssociationInsert, AssociationInsert> {

}

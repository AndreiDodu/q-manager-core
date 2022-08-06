package com.andreidodu.qm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.andreidodu.qm.db.GroupDB;
import com.andreidodu.qm.dto.Group;
import com.andreidodu.qm.dto.input.GroupInsert;
import com.andreidodu.qm.mapper.common.CommonMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GroupMapper extends CommonMapper<GroupDB, Group, GroupInsert> {

}

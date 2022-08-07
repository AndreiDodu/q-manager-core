package com.andreidodu.qm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.andreidodu.qm.db.QuestionDB;
import com.andreidodu.qm.dto.Question;
import com.andreidodu.qm.dto.input.QuestionInsert;
import com.andreidodu.qm.mapper.common.CommonMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface QuestionMapper extends CommonMapper<QuestionDB, Question, QuestionInsert> {

}

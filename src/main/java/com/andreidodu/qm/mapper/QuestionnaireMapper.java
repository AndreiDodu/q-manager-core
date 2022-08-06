package com.andreidodu.qm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.andreidodu.qm.db.QuestionnaireDB;
import com.andreidodu.qm.dto.Questionnaire;
import com.andreidodu.qm.dto.input.QuestionnaireInsert;
import com.andreidodu.qm.mapper.common.CommonMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface QuestionnaireMapper extends CommonMapper<QuestionnaireDB, Questionnaire, QuestionnaireInsert> {

}

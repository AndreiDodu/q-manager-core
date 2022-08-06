package com.andreidodu.qm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.andreidodu.qm.db.TranslationDB;
import com.andreidodu.qm.dto.Translation;
import com.andreidodu.qm.dto.input.TranslationInsert;
import com.andreidodu.qm.mapper.common.CommonMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TranslationMapper extends CommonMapper<TranslationDB, Translation, TranslationInsert> {

}

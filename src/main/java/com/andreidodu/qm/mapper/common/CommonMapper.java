package com.andreidodu.qm.mapper.common;

import org.mapstruct.MappingTarget;

public interface CommonMapper<DBType, DTOType, DTOInsertType> {

	DBType toDB(DTOInsertType dto);

	DTOType toDTO(DBType db);

	void update(@MappingTarget DBType db, DTOInsertType dto);

}

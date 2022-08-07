package com.andreidodu.qm.mapper.common;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.MappingTarget;

public interface CommonMapper<DBType, DTOType, DTOInsertType> {

	DBType toDB(DTOInsertType dto);

	DTOType toDTO(DBType db);

	default List<DTOType> toDTO(List<DBType> dbs) {
		return dbs.stream().map(db -> this.toDTO(db)).collect(Collectors.toList());
	}

	void update(@MappingTarget DBType db, DTOInsertType dto);

}

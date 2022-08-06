package com.andreidodu.qm.service.common;

import java.util.List;

public interface CategoryCommonService<DTOInsertType, DTOType> {

	public DTOType create(DTOInsertType insertDto);

	public DTOInsertType update(DTOInsertType insertDto);

	public List<DTOInsertType> getAll(String languageCode);

	public Boolean delete(String code);

	DTOInsertType getByCode(String code, String languageCode);

}

package com.andreidodu.qm.service.common;

import java.util.List;

import com.andreidodu.qm.dto.input.common.CategoryInsert;

public interface CategoryCommonService<DTOType> {

	public DTOType create(CategoryInsert insertDto);

	public CategoryInsert update(CategoryInsert insertDto);

	public List<CategoryInsert> getAll(String languageCode);

	public Boolean delete(String code);

	CategoryInsert getByCode(String code, String languageCode);

}

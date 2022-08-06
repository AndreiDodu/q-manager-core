package com.andreidodu.qm.service;

import java.util.List;

import com.andreidodu.qm.IgnoreDuringScan;

@IgnoreDuringScan
public interface CommonService<DTOInsertType, DTOType> {

	public DTOType create(DTOInsertType insertDto);

	public DTOInsertType update(DTOInsertType insertDto);

	public List<DTOInsertType> getAll(String languageCode);

	public Boolean delete(String code);

}

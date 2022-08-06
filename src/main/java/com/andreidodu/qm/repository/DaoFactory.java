package com.andreidodu.qm.repository;

import com.andreidodu.qm.repository.common.CategoryCommonDao;

public interface DaoFactory {
	
	public <DBType, IDType> CategoryCommonDao<DBType, IDType> getDao(String name);

}

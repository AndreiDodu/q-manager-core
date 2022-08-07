package com.andreidodu.qm.repository;

import com.andreidodu.qm.repository.common.AssociationCommonDao;
import com.andreidodu.qm.repository.common.CategoryCommonDao;

public interface DaoFactory {
	
	public <DBType, IDType> CategoryCommonDao<DBType, IDType> getCategoryDao(String name);
	
	public <DBType, IDType> AssociationCommonDao<DBType, IDType> getAssociationDao(String name);

}

package com.andreidodu.qm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.repository.common.AssociationCommonDao;
import com.andreidodu.qm.repository.common.CategoryCommonDao;

@Component
public class DaoFactoryImpl implements DaoFactory {

	@Autowired
	private ApplicationContext context;

	public <DBType, IDType> CategoryCommonDao<DBType, IDType> getCategoryDao(String name) {
		return (CategoryCommonDao<DBType, IDType>) this.context.getBean(name.toLowerCase() + "Dao");
	}

	@Override
	public <DBType, IDType> AssociationCommonDao<DBType, IDType> getAssociationDao(String name) {
		return (AssociationCommonDao<DBType, IDType>) this.context.getBean(name.toLowerCase() + "Dao");
	}

}

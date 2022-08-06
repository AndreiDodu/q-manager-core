package com.andreidodu.qm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.repository.common.CategoryCommonDao;

@Component
public class DaoFactoryImpl implements DaoFactory {

	@Autowired
	private ApplicationContext context;

	public <DBType, IDType> CategoryCommonDao<DBType, IDType> getDao(String name) {
		return (CategoryCommonDao<DBType, IDType>) this.context.getBean(name.toLowerCase() + "Dao");
	}

}

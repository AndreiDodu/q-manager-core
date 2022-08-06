package com.andreidodu.qm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DaoFactoryImpl implements DaoFactory {

	@Autowired
	private ApplicationContext context;

	public <DBType, IDType> CommonDao<DBType, IDType> getDao(String name) {
		return (CommonDao<DBType, IDType>) this.context.getBean(name.toLowerCase() + "Dao");
	}

}

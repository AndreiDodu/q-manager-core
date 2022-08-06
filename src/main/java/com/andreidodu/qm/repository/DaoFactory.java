package com.andreidodu.qm.repository;

public interface DaoFactory {
	
	public <DBType, IDType> CommonDao<DBType, IDType> getDao(String name);

}

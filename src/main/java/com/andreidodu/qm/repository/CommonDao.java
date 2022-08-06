package com.andreidodu.qm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean  
public interface CommonDao<DBType, IDType> extends CrudRepository<DBType, IDType> {

	DBType findByCode(String code);

}

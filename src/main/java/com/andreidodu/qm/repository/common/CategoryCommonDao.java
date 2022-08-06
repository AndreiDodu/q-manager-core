package com.andreidodu.qm.repository.common;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean  
public interface CategoryCommonDao<DBType, IDType> extends CrudRepository<DBType, IDType> {

	DBType findByCode(String code);

}

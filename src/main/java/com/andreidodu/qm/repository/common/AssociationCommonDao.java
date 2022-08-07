package com.andreidodu.qm.repository.common;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean  
public interface AssociationCommonDao<DBType, IDType> extends CrudRepository<DBType, IDType> {

	Optional<DBType> findByParentCodeAndChildCode(String parentCode, String childCode);

	List<DBType> findByParentCode(String parentCode);

	void deleteByParentCodeAndChildCode(String parentCode, String childCode);

}

package com.andreidodu.qm.service.impl.common;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.dto.input.common.AssociationInsert;
import com.andreidodu.qm.mapper.common.CommonMapper;
import com.andreidodu.qm.repository.DaoFactory;
import com.andreidodu.qm.repository.common.AssociationCommonDao;
import com.andreidodu.qm.service.common.AssociationCommonService;

@Transactional(propagation = Propagation.REQUIRED)
public class AssociationCommonServiceImpl<DTOType, DBType, IDType, MapperType extends CommonMapper<DBType, AssociationInsert, AssociationInsert>> implements AssociationCommonService<AssociationInsert, DTOType> {

	@Autowired
	private DaoFactory daoFactory;

	@Autowired
	private MapperType mapper;

	private final Class<DTOType> dtoClazz;

	public AssociationCommonServiceImpl(Class<DTOType> dtoClazz) {
		this.dtoClazz = dtoClazz;
	}

	private AssociationCommonDao<DBType, IDType> getDao() {
		return this.daoFactory.getAssociationDao(this.dtoClazz.getSimpleName());
	}

	@Override
	public AssociationInsert createAssociation(AssociationInsert associationInsert) {
		DBType db = this.mapper.toDB(associationInsert);
		db = this.getDao().save(db);
		return this.mapper.toDTO(db);
	}

	@Override
	public Boolean deleteAssociation(String parentCode, String childCode) {
		this.getDao().deleteByParentCodeAndChildCode(parentCode, childCode);
		return true;
	}

	@Override
	public List<AssociationInsert> getAssociationAll(String parentCode) {
		return this.mapper.toDTO(this.getDao().findByParentCode(parentCode));
	}

	@Override
	public AssociationInsert getAssociationByCode(String parentCode, String childCode) {
		return this.mapper.toDTO(this.getDao().findByParentCodeAndChildCode(parentCode, childCode).get());
	}

	@Override
	public AssociationInsert updateAssociation(AssociationInsert dtoIns) {
		Optional<DBType> dbOpt = this.getDao().findByParentCodeAndChildCode(dtoIns.parentCode(), dtoIns.childCode());
		if (dbOpt.isPresent()) {
			DBType db = dbOpt.get();
			this.mapper.update(db, dtoIns);
			db = this.getDao().save(db);
			return this.mapper.toDTO(db);
		}
		return null;
	}

}

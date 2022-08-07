package com.andreidodu.qm.service.common;

import java.util.List;

public interface AssociationCommonService<DTOInsertType, DTOType> {

	DTOInsertType updateAssociation(DTOInsertType dtoIns);

	DTOInsertType createAssociation(DTOInsertType associationInsert);

	Boolean deleteAssociation(String parentCode, String childCode);

	List<DTOInsertType> getAssociationAll(String parentCode);

	DTOInsertType getAssociationByCode(String parentCode, String childCode);

}

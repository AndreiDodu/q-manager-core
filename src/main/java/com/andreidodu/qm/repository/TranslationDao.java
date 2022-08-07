package com.andreidodu.qm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andreidodu.qm.db.TranslationDB;

@Repository
public interface TranslationDao extends CrudRepository<TranslationDB, Long> {

	TranslationDB findByCommonCodeAndSubCodeAndLanguageCode(String commonCode, String subCode, String languageCode);

	void deleteByCommonCodeAndSubCode(String commonCode, String subCode);

	List<TranslationDB> findByCommonCodeAndLanguageCode(String code, String languageCode);

}

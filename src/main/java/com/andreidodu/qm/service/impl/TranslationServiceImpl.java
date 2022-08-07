package com.andreidodu.qm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.db.TranslationDB;
import com.andreidodu.qm.dto.Translation;
import com.andreidodu.qm.dto.input.TranslationInsert;
import com.andreidodu.qm.mapper.TranslationMapper;
import com.andreidodu.qm.repository.TranslationDao;
import com.andreidodu.qm.service.TranslationService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TranslationServiceImpl implements TranslationService {

	@Autowired
	private TranslationDao dao;

	@Autowired
	private TranslationMapper mapper;

	@Override
	public Translation create(TranslationInsert translation) {
		TranslationDB db = this.mapper.toDB(translation);
		db = this.dao.save(db);
		return this.mapper.toDTO(db);
	}

	@Override
	public Translation update(TranslationInsert translation) {
		TranslationDB db = this.dao.findByCommonCodeAndSubCodeAndLanguageCode(translation.commonCode(), translation.subCode(), translation.languageCode());
		if (db != null) {
			this.mapper.update(db, translation);
			db = this.dao.save(db);
			return this.mapper.toDTO(db);
		}
		return null;
	}

	@Override
	public Translation findByCommonCodeSubCodeLanguageCode(String commonCode, String subCode, String languageCode) {
		TranslationDB db = this.dao.findByCommonCodeAndSubCodeAndLanguageCode(commonCode, subCode, languageCode);
		return this.mapper.toDTO(db);
	}

	@Override
	public void deleteByCommonCodeAndSubCode(String commonCode, String subCode) {
		this.dao.deleteByCommonCodeAndSubCode(commonCode, subCode);
	}

	@Override
	public List<Translation> findByCommonCodeLanguageCode(String code, String languageCode) {
		List<TranslationDB> dbs = this.dao.findByCommonCodeAndLanguageCode(code, languageCode);
		return this.mapper.toDTO(dbs);
	}

	@Override
	public void deleteByCommonCodeAndLanguageCode(String code, String languageCode) {
		this.dao.deleteByCommonCodeAndLanguageCode(code, languageCode);
		
	}

	@Override
	public void deleteByCommonCode(String code) {
		this.dao.deleteByCommonCode(code);
		
	}

}

package com.andreidodu.qm.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.db.CodesDB;
import com.andreidodu.qm.dto.Translation;
import com.andreidodu.qm.dto.input.InputCommon;
import com.andreidodu.qm.dto.input.TranslationInsert;
import com.andreidodu.qm.mapper.common.CommonMapper;
import com.andreidodu.qm.repository.CommonDao;
import com.andreidodu.qm.repository.DaoFactory;
import com.andreidodu.qm.service.CommonService;
import com.andreidodu.qm.service.TranslationService;

@Transactional(propagation = Propagation.REQUIRED)
public class CommonServiceImpl<DBType extends CodesDB, IDType, DTOType, DTOInsertType extends InputCommon, MapperType extends CommonMapper<DBType, DTOType, DTOInsertType>>
		implements CommonService<DTOInsertType, DTOType> {

	private static final String HELP_QUESTION_CODE = "HELP";
	private static final String TITLE_QUESTION_CODE = "TITLE";

	private final Class<DTOType> dtoClazz;
	private final Class<DTOInsertType> dtoInsertClazz;

	@Autowired
	private DaoFactory daoFactory;

	@Autowired
	private TranslationService translationService;

	@Autowired
	private MapperType mapper;

	private CommonDao<DBType, IDType> getDao() {
		return this.daoFactory.getDao(this.dtoClazz.getSimpleName());
	}

	public CommonServiceImpl(Class<DTOType> dtoClazz, Class<DTOInsertType> dtoInsertClazz) {
		this.dtoClazz = dtoClazz;
		this.dtoInsertClazz = dtoInsertClazz;
	}

	@Override
	public DTOType create(DTOInsertType dtoInsert) {
		DBType db = this.mapper.toDB(dtoInsert);

		if (dtoInsert.title() != null) {
			if (dtoInsert.languageCode() == null) {
				return null;
			}
			TranslationInsert translation = new TranslationInsert(dtoInsert.code(), TITLE_QUESTION_CODE, dtoInsert.languageCode(), dtoInsert.title());
			Translation title = this.translationService.create(translation);
			db.setTitleCode(title.subCode());
		}
		if (dtoInsert.help() != null) {
			if (dtoInsert.languageCode() == null) {
				return null;
			}
			TranslationInsert translation = new TranslationInsert(dtoInsert.code(), HELP_QUESTION_CODE, dtoInsert.languageCode(), dtoInsert.help());
			Translation title = this.translationService.create(translation);
			db.setHelpCode(title.subCode());
		}

		db = getDao().save(db);
		return this.mapper.toDTO(db);
	}

	@Override
	public DTOInsertType update(DTOInsertType questionnaireToUpdate) {
		CommonDao<DBType, IDType> commonDao = getDao();
		DBType db = commonDao.findByCode(questionnaireToUpdate.code());
		if (db != null) {
			if (questionnaireToUpdate.title() != null) {
				if (questionnaireToUpdate.languageCode() == null) {
					return null;
				}
				TranslationInsert translation = new TranslationInsert(db.getCode(), TITLE_QUESTION_CODE, questionnaireToUpdate.languageCode(), questionnaireToUpdate.title());
				Translation result = this.translationService.update(translation);
				if (result == null) {
					result = this.translationService.create(translation);
				}
				db.setHelpCode(result.subCode());
			}
			if (questionnaireToUpdate.help() != null) {
				if (questionnaireToUpdate.languageCode() == null) {
					return null;
				}
				TranslationInsert translation = new TranslationInsert(db.getCode(), HELP_QUESTION_CODE, questionnaireToUpdate.languageCode(), questionnaireToUpdate.help());
				Translation result = this.translationService.update(translation);
				if (result == null) {
					result = this.translationService.create(translation);
				}
				db.setHelpCode(result.subCode());
			}
			commonDao.save(db);
			return questionnaireToUpdate;
		}
		return null;
	}

	@Override
	public List<DTOInsertType> getAll(String languageCode) {
		List<DBType> items = StreamSupport.stream(getDao().findAll().spliterator(), false).collect(Collectors.toList());
		List<DTOInsertType> result = new ArrayList<>();
		items.forEach(item -> {
			Translation title = this.translationService.findByCommonCodeSubCodeLanguageCode(item.getCode(), TITLE_QUESTION_CODE, languageCode);
			Translation help = this.translationService.findByCommonCodeSubCodeLanguageCode(item.getCode(), HELP_QUESTION_CODE, languageCode);

			try {
				DTOInsertType ins = dtoInsertClazz.getConstructor(String.class, String.class, String.class, String.class).newInstance(item.getCode(), title == null ? null : title.text(),
						help == null ? null : help.text(), languageCode);
				result.add(ins);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}

		});
		return result;
	}

	@Override
	public Boolean delete(String code) {

		DBType db = getDao().findByCode(code);
		if (db != null) {
			if (db.getTitleCode() != null) {
				this.translationService.deleteByCommonCodeAndSubCode(db.getCode(), db.getTitleCode());
			}
			if (db.getHelpCode() != null) {
				this.translationService.deleteByCommonCodeAndSubCode(db.getCode(), db.getHelpCode());
			}
			getDao().delete(db);
			return true;
		}
		return true;
	}

}

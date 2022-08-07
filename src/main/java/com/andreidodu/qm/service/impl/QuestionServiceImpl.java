package com.andreidodu.qm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.db.QuestionDB;
import com.andreidodu.qm.dto.Pair;
import com.andreidodu.qm.dto.Question;
import com.andreidodu.qm.dto.Translation;
import com.andreidodu.qm.dto.input.QuestionInsert;
import com.andreidodu.qm.dto.input.TranslationInsert;
import com.andreidodu.qm.mapper.QuestionMapper;
import com.andreidodu.qm.repository.QuestionDao;
import com.andreidodu.qm.service.QuestionService;
import com.andreidodu.qm.service.TranslationService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {

	private static final String HELP_IDENTIFICATOR = "HELP";

	private static final String QUESTION_IDENTIFICATOR = "QUESTION";

	@Autowired
	private TranslationService translationService;

	@Autowired
	private QuestionDao dao;

	@Autowired
	private QuestionMapper mapper;

	@Override
	public Question create(QuestionInsert dtoInsert) {
		if (dtoInsert.languageCode() == null) {
			return null;
		}

		QuestionDB db = new QuestionDB();
		db.setCode(dtoInsert.code());

		if (dtoInsert.text() != null) {
			TranslationInsert translation = new TranslationInsert(dtoInsert.code(), QUESTION_IDENTIFICATOR, dtoInsert.languageCode(), dtoInsert.text());
			this.translationService.create(translation);
		}

		if (dtoInsert.help() != null) {
			TranslationInsert translation = new TranslationInsert(dtoInsert.code(), HELP_IDENTIFICATOR, dtoInsert.languageCode(), dtoInsert.help());
			this.translationService.create(translation);
			db.setHelpCode(HELP_IDENTIFICATOR);
		}

		db.setType(dtoInsert.type());

		if ("MUL".equalsIgnoreCase(dtoInsert.type())) {
			int[] i = new int[1];
			dtoInsert.options().forEach(opt -> {
				TranslationInsert translation = new TranslationInsert(dtoInsert.code(), String.valueOf(i[0]++), dtoInsert.languageCode(), opt.value());
				this.translationService.create(translation);
			});

		}
		return this.mapper.toDTO(this.dao.save(db));
	}

	@Override
	public Boolean delete(String questionCode) {
		this.translationService.deleteByCommonCode(questionCode);
		this.dao.deleteByCode(questionCode);
		return true;
	}

	@Override
	public List<QuestionInsert> getAll(String languageCode) {
		List<QuestionInsert> result = new ArrayList<>();
		this.dao.findAll().forEach(db -> {
			result.add(new QuestionInsert(db.getCode(), null, null, db.getType(), languageCode, null));
		});
		return result;
	}

	@Override
	public QuestionInsert getByCode(String code, String languageCode) {
		QuestionDB db = this.dao.findByCode(code);
		Translation questionText = this.translationService.findByCommonCodeSubCodeLanguageCode(code, QUESTION_IDENTIFICATOR, languageCode);
		Translation helpText = this.translationService.findByCommonCodeSubCodeLanguageCode(code, HELP_IDENTIFICATOR, languageCode);
		List<Pair> options = new ArrayList<>();
		if ("MUL".equalsIgnoreCase(db.getType())) {
			List<Translation> data = this.translationService.findByCommonCodeLanguageCode(code, languageCode);
			options = data.stream().map(item -> new Pair(item.subCode(), item.text())).collect(Collectors.toList());
		}
		return new QuestionInsert(code, questionText.text(), helpText.text(), db.getType(), languageCode, options);
	}

	@Override
	public Question update(QuestionInsert dtoInsert) {
		if (dtoInsert.languageCode() == null) {
			return null;
		}

		QuestionDB db = this.dao.findByCode(dtoInsert.code());

		if (db != null) {
			db.setCode(dtoInsert.code());

			if (dtoInsert.text() != null) {
				this.translationService.deleteByCommonCodeAndSubCode(dtoInsert.code(), QUESTION_IDENTIFICATOR);
				TranslationInsert translation = new TranslationInsert(dtoInsert.code(), QUESTION_IDENTIFICATOR, dtoInsert.languageCode(), dtoInsert.text());
				this.translationService.create(translation);
			}

			if (dtoInsert.help() != null) {
				this.translationService.deleteByCommonCodeAndSubCode(dtoInsert.code(), HELP_IDENTIFICATOR);
				TranslationInsert translation = new TranslationInsert(dtoInsert.code(), HELP_IDENTIFICATOR, dtoInsert.languageCode(), dtoInsert.help());
				this.translationService.create(translation);
				db.setHelpCode(HELP_IDENTIFICATOR);
			}

			db.setType(dtoInsert.type());

			if ("MUL".equalsIgnoreCase(dtoInsert.type())) {
				this.translationService.deleteByCommonCodeAndLanguageCode(dtoInsert.code(), dtoInsert.languageCode());
				int[] i = new int[1];
				dtoInsert.options().forEach(opt -> {
					TranslationInsert translation = new TranslationInsert(dtoInsert.code(), String.valueOf(i[0]++), dtoInsert.languageCode(), opt.value());
					this.translationService.create(translation);
				});

			}
			return this.mapper.toDTO(this.dao.save(db));
		}
		return null;
	}

}

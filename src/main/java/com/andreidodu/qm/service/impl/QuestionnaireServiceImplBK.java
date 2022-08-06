//package com.andreidodu.qm.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.andreidodu.qm.db.QuestionnaireDB;
//import com.andreidodu.qm.dto.Questionnaire;
//import com.andreidodu.qm.dto.Translation;
//import com.andreidodu.qm.dto.input.InputCommon;
//import com.andreidodu.qm.dto.input.QuestionnaireInsert;
//import com.andreidodu.qm.dto.input.TranslationInsert;
//import com.andreidodu.qm.mapper.QuestionnaireMapper;
//import com.andreidodu.qm.repository.QuestionnaireDao;
//import com.andreidodu.qm.service.QuestionnaireService;
//import com.andreidodu.qm.service.TranslationService;
//
//@Service
//@Transactional(propagation = Propagation.REQUIRED)
//public class QuestionnaireServiceImplBK implements QuestionnaireService {
//
//	private static final String HELP_QUESTION_CODE = "HELP";
//	private static final String TITLE_QUESTION_CODE = "TITLE";
//
//	@Autowired
//	QuestionnaireDao questionnaireDao;
//
//	@Autowired
//	private TranslationService translationService;
//
//	@Autowired
//	private QuestionnaireMapper questionnaireMapper;
//
//	@Override
//	public Questionnaire create(InputCommon questionnaireIn) {
//		QuestionnaireDB db = this.questionnaireMapper.toDB(questionnaireIn);
//
//		if (questionnaireIn.title() != null) {
//			if (questionnaireIn.languageCode() == null) {
//				return null;
//			}
//			TranslationInsert translation = new TranslationInsert(questionnaireIn.code(), TITLE_QUESTION_CODE, questionnaireIn.languageCode(), questionnaireIn.title());
//			Translation title = this.translationService.create(translation);
//			db.setTitleCode(title.subCode());
//		}
//		if (questionnaireIn.help() != null) {
//			if (questionnaireIn.languageCode() == null) {
//				return null;
//			}
//			TranslationInsert translation = new TranslationInsert(questionnaireIn.code(), HELP_QUESTION_CODE, questionnaireIn.languageCode(), questionnaireIn.help());
//			Translation title = this.translationService.create(translation);
//			db.setHelpCode(title.subCode());
//		}
//
//		db = this.questionnaireDao.save(db);
//		return this.questionnaireMapper.toDTO(db);
//	}
//
//	@Override
//	public QuestionnaireInsert update(QuestionnaireInsert questionnaireToUpdate) {
//		QuestionnaireDB db = this.questionnaireDao.findByQuestionnaireCode(questionnaireToUpdate.code());
//		if (db != null) {
//			if (questionnaireToUpdate.title() != null) {
//				if (questionnaireToUpdate.languageCode() == null) {
//					return null;
//				}
//				TranslationInsert translation = new TranslationInsert(db.getQuestionnaireCode(), TITLE_QUESTION_CODE, questionnaireToUpdate.languageCode(), questionnaireToUpdate.title());
//				Translation result = this.translationService.update(translation);
//				if (result == null) {
//					result = this.translationService.create(translation);
//				}
//				db.setHelpCode(result.subCode());
//			}
//			if (questionnaireToUpdate.help() != null) {
//				if (questionnaireToUpdate.languageCode() == null) {
//					return null;
//				}
//				TranslationInsert translation = new TranslationInsert(db.getQuestionnaireCode(), HELP_QUESTION_CODE, questionnaireToUpdate.languageCode(), questionnaireToUpdate.help());
//				Translation result = this.translationService.update(translation);
//				if (result == null) {
//					result = this.translationService.create(translation);
//				}
//				db.setHelpCode(result.subCode());
//			}
//			this.questionnaireDao.save(db);
//			return questionnaireToUpdate;
//		}
//		return null;
//	}
//
//	@Override
//	public List<QuestionnaireInsert> getAll(String languageCode) {
//		List<QuestionnaireDB> questionnaires = StreamSupport.stream(this.questionnaireDao.findAll().spliterator(), false).collect(Collectors.toList());
//		List<QuestionnaireInsert> result = new ArrayList<>();
//		questionnaires.forEach(item -> {
//			Translation title = this.translationService.findByCommonCodeSubCodeLanguageCode(item.getQuestionnaireCode(), TITLE_QUESTION_CODE, languageCode);
//			Translation help = this.translationService.findByCommonCodeSubCodeLanguageCode(item.getQuestionnaireCode(), HELP_QUESTION_CODE, languageCode);
//			QuestionnaireInsert ins = new QuestionnaireInsert(item.getQuestionnaireCode(), title == null ? null : title.text(), help == null ? null : help.text(), languageCode);
//			result.add(ins);
//		});
//		return result;
//	}
//
//	@Override
//	public Boolean delete(String questionnaireCode) {
//		QuestionnaireDB db = this.questionnaireDao.findByQuestionnaireCode(questionnaireCode);
//		if (db != null) {
//			if (db.getTitleCode() != null) {
//				this.translationService.deleteByCommonCodeAndSubCode(db.getQuestionnaireCode(), db.getTitleCode());
//			}
//			if (db.getHelpCode() != null) {
//				this.translationService.deleteByCommonCodeAndSubCode(db.getQuestionnaireCode(), db.getHelpCode());
//			}
//			this.questionnaireDao.delete(db);
//			return true;
//		}
//		return true;
//	}
//
//}

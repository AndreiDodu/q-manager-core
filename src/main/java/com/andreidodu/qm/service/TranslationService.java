package com.andreidodu.qm.service;

import java.util.List;

import com.andreidodu.qm.dto.Translation;
import com.andreidodu.qm.dto.input.TranslationInsert;

public interface TranslationService {

	Translation create(TranslationInsert translation);

	Translation update(TranslationInsert translation);

	Translation findByCommonCodeSubCodeLanguageCode(String commonCode, String subCode, String languageCode);

	void deleteByCommonCodeAndSubCode(String questionnaireCode, String titleCode);

	List<Translation> findByCommonCodeLanguageCode(String code, String languageCode);

}

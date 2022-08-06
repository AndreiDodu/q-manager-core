package com.andreidodu.qm.service;

import com.andreidodu.qm.dto.Translation;
import com.andreidodu.qm.dto.input.TranslationInsert;

public interface TranslationService {

	Translation create(TranslationInsert translation);

	Translation update(TranslationInsert translation);

}

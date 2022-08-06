package com.andreidodu.qm.dto.input;

import com.andreidodu.qm.dto.input.common.CategoryInputCommon;

public record QuestionnaireInsert(String code, String title, String help, String languageCode) implements CategoryInputCommon {
}

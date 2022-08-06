package com.andreidodu.qm.dto.input;

public record QuestionnaireInsert(String code, String title, String help, String languageCode) implements InputCommon {
}

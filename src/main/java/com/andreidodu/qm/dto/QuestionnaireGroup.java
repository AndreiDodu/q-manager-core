package com.andreidodu.qm.dto;

public record QuestionnaireGroup(Long id, Questionnaire questionnaire, Group group, Integer order) {
}

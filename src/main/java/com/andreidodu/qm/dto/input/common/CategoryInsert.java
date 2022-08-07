package com.andreidodu.qm.dto.input.common;

public record CategoryInsert(String code, String title, String help, String languageCode) implements CategoryInputCommon {
}

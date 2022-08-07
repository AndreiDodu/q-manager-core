package com.andreidodu.qm.dto.input;

import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.andreidodu.qm.dto.Pair;

public record QuestionInsert(
		String code, 
		String text,
		String help, 
		@Pattern(regexp = "NUM|TEXT|STR|DATE|MUL", flags = Pattern.Flag.CASE_INSENSITIVE) 
		String type,
		@Size(min = 3, max = 3)
		String languageCode,
		List<Pair> options
		) {
}

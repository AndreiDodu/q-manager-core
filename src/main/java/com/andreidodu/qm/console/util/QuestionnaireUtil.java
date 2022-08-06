package com.andreidodu.qm.console.util;

import java.util.Random;

public class QuestionnaireUtil {

	public static String generateRandomString(int length) {
		int leftLimit = 48;
		int rightLimit = 96;
		Random random = new Random();
		return random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(length).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

}

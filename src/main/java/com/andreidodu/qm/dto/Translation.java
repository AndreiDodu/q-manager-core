package com.andreidodu.qm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Translation extends Common {

	private Long id;
	private String commonCode;
	private String subCode;
	private String language;
	private String text;

}

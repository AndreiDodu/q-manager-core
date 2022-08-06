package com.andreidodu.qm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question extends Common {

	private Long id;
	private String code;
	private String helpCode;
	private String commonCode;
	private String type;

}

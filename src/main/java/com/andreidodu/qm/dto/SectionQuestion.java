package com.andreidodu.qm.dto;

import com.andreidodu.qm.db.CommonDB;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionQuestion extends CommonDB {

	private Long id;
	private Section section;
	private Question question;
	private Integer order;

}

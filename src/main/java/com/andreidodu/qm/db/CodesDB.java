package com.andreidodu.qm.db;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class CodesDB extends CommonDB{

	@Column(name = "code", nullable = false, unique = true)
	private String code;

	@Column(name = "title_code")
	private String titleCode;
	
	@Column(name = "help_code")
	private String helpCode;
}

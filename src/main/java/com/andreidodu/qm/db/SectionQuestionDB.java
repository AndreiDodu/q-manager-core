package com.andreidodu.qm.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "conf_section_question", uniqueConstraints = @UniqueConstraint(columnNames = { "section_code", "question_code" }))
public class SectionQuestionDB extends CommonDB {

	@Id
	@Column(name = "conf_section_question_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "section_code")
	private String parentCode;

	@Column(name = "question_code")
	private String childCode;

	@Column(name = "pos")
	private Integer order;

}

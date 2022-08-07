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
@Table(name = "conf_questionnaire_group", uniqueConstraints = @UniqueConstraint(columnNames = { "questionnaire_code", "group_code" }))
public class QuestionnaireGroupDB extends CommonDB {

	@Id
	@Column(name = "conf_questionnaire_group_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "questionnaire_code")
	private String parentCode;

	@Column(name = "group_code")
	private String childCode;

	@Column(name = "pos")
	private Integer order;

}

package com.andreidodu.boilerplate.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "conf_questionnaire_group")
public class QuestionnaireGroupDB extends CommonDB {

	@Id
	@Column(name = "conf_questionnaire_group_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "conf_questionnaire_id")
	private QuestionnaireDB questionnaire;

	@ManyToOne
	@JoinColumn(name = "conf_group_id")
	private GroupDB group;

	@Column(name = "order")
	private Integer order;

}

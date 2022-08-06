package com.andreidodu.qm.db;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "conf_question")
public class QuestionDB extends CommonDB {

	@Id
	@Column(name = "conf_question_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "question_code", nullable = false, unique = true)
	private String code;

	@Column(name = "help_code")
	private String helpCode;

	@Column(name = "common_code")
	private String commonCode;

	@Pattern(regexp = "NUM|TEXT|STR|DATE|MUL", flags = Pattern.Flag.CASE_INSENSITIVE)
	@Column(name = "type")
	private String type;

	@OneToMany(mappedBy = "question")
	Set<SectionQuestionDB> sectionQuestions;

}

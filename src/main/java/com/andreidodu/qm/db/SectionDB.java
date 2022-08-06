package com.andreidodu.qm.db;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "conf_section")
public class SectionDB extends CommonDB {

	@Id
	@Column(name = "conf_section_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "section_code", nullable = false, unique = true)
	private String section_code;

	@Column(name = "title_code")
	private String titleCode;
	
	@Column(name = "help_code")
	private String helpCode;

	@OneToMany(mappedBy = "section")
	Set<GroupSectionDB> groupSections;

	@OneToMany(mappedBy = "section")
	Set<SectionQuestionDB> sectionQuestions;

}

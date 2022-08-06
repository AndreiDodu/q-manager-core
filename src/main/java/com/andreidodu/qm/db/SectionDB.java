package com.andreidodu.qm.db;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
@AttributeOverrides({ @AttributeOverride(name = "code", column = @Column(name = "section_code")) })
public class SectionDB extends CodesDB {

	@Id
	@Column(name = "conf_section_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "section")
	Set<GroupSectionDB> groupSections;

	@OneToMany(mappedBy = "section")
	Set<SectionQuestionDB> sectionQuestions;

}

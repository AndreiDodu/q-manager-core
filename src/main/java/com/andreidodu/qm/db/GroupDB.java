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
@Table(name = "conf_group")
public class GroupDB extends CommonDB {

	@Id
	@Column(name = "conf_group_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "group_code", nullable = false, unique = true)
	private String groupCode;

	@Column(name = "title_code")
	private String titleCode;

	@OneToMany(mappedBy = "group")
	Set<QuestionnaireGroupDB> questionnaireGroups;

	@OneToMany(mappedBy = "group")
	Set<GroupSectionDB> groupSections;
}

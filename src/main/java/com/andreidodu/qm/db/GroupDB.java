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
@Table(name = "conf_group")
@AttributeOverrides({ @AttributeOverride(name = "code", column = @Column(name = "group_code")) })
public class GroupDB extends CodesDB {

	@Id
	@Column(name = "conf_group_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "group")
	Set<QuestionnaireGroupDB> questionnaireGroups;

	@OneToMany(mappedBy = "group")
	Set<GroupSectionDB> groupSections;
}

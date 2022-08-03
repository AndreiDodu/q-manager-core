package com.andreidodu.boilerplate.db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name = "conf_section")
public class SectionDB extends CommonDB {

	@Id
	@Column(name = "conf_section_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "section_code", nullable = false, unique = true)
	private String section_code;

	@Column(name = "title")
	private String title;

	@OneToMany(mappedBy = "section")
	Set<GroupSectionDB> groupSections;

}

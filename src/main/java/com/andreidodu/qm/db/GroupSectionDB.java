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
@Table(name = "conf_group_section", uniqueConstraints = @UniqueConstraint(columnNames = { "group_code", "section_code" }))
public class GroupSectionDB extends CommonDB {

	@Id
	@Column(name = "conf_group_section_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "group_code")
	private String parentCode;

	@Column(name = "section_code")
	private String childCode;

	@Column(name = "pos")
	private Integer order;

}

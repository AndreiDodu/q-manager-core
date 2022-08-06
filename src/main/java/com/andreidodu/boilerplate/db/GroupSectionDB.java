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
@Table(name = "conf_group_section")
public class GroupSectionDB extends CommonDB {

	@Id
	@Column(name = "conf_group_section_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "conf_group_id")
	private GroupDB group;

	@ManyToOne
	@JoinColumn(name = "conf_section_id")
	private SectionDB section;

	@Column(name = "order")
	private Integer order;

}

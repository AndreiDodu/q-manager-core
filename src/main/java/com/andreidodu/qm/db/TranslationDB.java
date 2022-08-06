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
@Table(name = "conf_translation", uniqueConstraints = @UniqueConstraint(columnNames = { "common_code",
"identification_code", "language_code" }))
public class TranslationDB extends CommonDB {

	@Id
	@Column(name = "conf_translation_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "common_code")
	private String commonCode;

	@Column(name = "identification_code")
	private String subCode;

	@Column(name = "language_code", nullable = false)
	private String language;

	@Column(name = "text")
	private String text;

}

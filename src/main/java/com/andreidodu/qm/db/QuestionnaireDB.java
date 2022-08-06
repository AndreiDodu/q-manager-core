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
@Table(name = "conf_questionnaire")
@AttributeOverrides({ @AttributeOverride(name = "code", column = @Column(name = "questionnaire_code")) })
public class QuestionnaireDB extends CodesDB {

	@Id
	@Column(name = "conf_questionnaire_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@OneToMany(mappedBy = "questionnaire")
	Set<QuestionnaireGroupDB> questionnaireGroups;

}

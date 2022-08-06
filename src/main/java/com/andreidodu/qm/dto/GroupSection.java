package com.andreidodu.qm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupSection extends Common {

	private Long id;
	private Group group;
	private Section section;
	private Integer order;

}

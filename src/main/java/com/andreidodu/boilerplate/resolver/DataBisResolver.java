package com.andreidodu.boilerplate.resolver;

import org.springframework.stereotype.Component;

import com.andreidodu.boilerplate.dto.DataBis;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class DataBisResolver implements GraphQLQueryResolver {

//	@Autowired
//	private DataBisService dataBisService;

	public DataBis getDataBis(Long id) {
		return null;
		// return this.dataBisService.findById(id);
	}

}

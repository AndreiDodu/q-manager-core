package com.andreidodu.boilerplate.resolver;

import org.springframework.stereotype.Component;

import com.andreidodu.boilerplate.dto.Data;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class DataResolver implements GraphQLQueryResolver {

//	@Autowired
//	private DataService dataService;

	public Data getData(String id) {
		return null; // return this.dataService.findById(id);
	}

}

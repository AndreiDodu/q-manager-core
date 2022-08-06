package com.andreidodu.qm;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(excludeFilters = @Filter(IgnoreDuringScan.class))
public class SpringConfig {

}

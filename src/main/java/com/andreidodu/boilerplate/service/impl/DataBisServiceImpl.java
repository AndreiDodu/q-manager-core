//package com.andreidodu.boilerplate.service.impl;
//
//import javax.transaction.Transactional;
//
//import org.dozer.DozerBeanMapper;
//import org.dozer.Mapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.andreidodu.boilerplate.dao.DataBisDao;
//import com.andreidodu.boilerplate.db.DataBisDB;
//import com.andreidodu.boilerplate.dto.DataBis;
//import com.andreidodu.boilerplate.service.DataBisService;
//
//@Service
//@Transactional
//public class DataBisServiceImpl implements DataBisService {
//
//	@Autowired
//	private DataBisDao dataBisDao;
//	
//	@Autowired
//	private Mapper mapper;
//
//	@Override
//	public DataBis findById(Long id) {
//		DataBisDB db = this.dataBisDao.findById(id).get();
//		return this.mapper.map(db, DataBis.class);
//	}
//
//}

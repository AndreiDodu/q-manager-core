package com.andreidodu.qm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.service.QuestionnaireService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionnaireServiceImpl implements QuestionnaireService {

}

package com.andreidodu.qm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andreidodu.qm.service.TranslationService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TranslationServiceImpl implements TranslationService {

}

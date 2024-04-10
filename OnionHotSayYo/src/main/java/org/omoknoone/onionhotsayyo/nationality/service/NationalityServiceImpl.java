package org.omoknoone.onionhotsayyo.nationality.service;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.nationality.repository.NationalityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NationalityServiceImpl implements NationalityService {

    private final ModelMapper modelMapper;
    private final NationalityRepository nationalityRepository;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public NationalityServiceImpl(ModelMapper modelMapper, NationalityRepository nationalityRepository) {
        this.modelMapper = modelMapper;
        this.nationalityRepository = nationalityRepository;
    }
}

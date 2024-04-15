package org.omoknoone.onionhotsayyo.nationality.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.omoknoone.onionhotsayyo.nationality.aggregate.Nationality;
import org.omoknoone.onionhotsayyo.nationality.repository.NationalityRepository;
import org.omoknoone.onionhotsayyo.nationality.dto.NationalityDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<NationalityDTO> viewNationality() {

        List<Nationality> nationalityList = nationalityRepository.findAll();
        return modelMapper.map(nationalityList, new TypeToken<List<NationalityDTO>>() {}.getType());
    }
}

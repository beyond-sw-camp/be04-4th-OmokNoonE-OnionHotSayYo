package org.omoknoone.onionhotsayyo.nationality.controller;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.nationality.service.NationalityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Nationalities")
public class NationalityController {

    private final NationalityService nationalityService;
    private final ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public NationalityController(NationalityService nationalityService, ModelMapper modelMapper) {
        this.nationalityService = nationalityService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/view")
    public String viewNationality() {

        return null;
    }

    @GetMapping("/set/language/{language}")
    public String setLanguage(@PathVariable String language) {

        return null;
    }

    @GetMapping("/health_check")
    public String healthCheck() {
        return "Good";
    }
}

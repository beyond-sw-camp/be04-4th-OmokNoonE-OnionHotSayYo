package org.omoknoone.onionhotsayyo.nationality.controller;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.nationality.dto.NationalityDTO;
import org.omoknoone.onionhotsayyo.nationality.service.NationalityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/nationalities")
public class NationalityController {

    private final NationalityService nationalityService;
    private final ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public NationalityController(NationalityService nationalityService, ModelMapper modelMapper) {
        this.nationalityService = nationalityService;
        this.modelMapper = modelMapper;
    }

    /* 회원가입 시 국적 조회 */
    @GetMapping("/view")
    public List<NationalityDTO> viewNationality() {

        List<NationalityDTO> nationalityDTOList = nationalityService.viewNationality();

        return nationalityDTOList;
    }

    /* 웹 페이지 언어 설정 (언어에 대한 정보는 cookie에 저장) */
    @GetMapping("/set/language/{language}")
    public String setLanguage(@PathVariable String language) {

        return null;
    }

    @GetMapping("/health_check")
    public String healthCheck() {
        return "Good";
    }
}

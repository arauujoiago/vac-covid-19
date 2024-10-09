package com.pratica.covid19m.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@DataJpaTest
class countryVaccinationServiceTest {
    @Autowired
    CountryVaccinationService service;


    @BeforeEach
    void setUp(){
    }

    void testCsvToModel() throws IOException {
        MultipartFile multipartFile = new MockMultipartFile("country_vaccinations.csv", new FileInputStream(new File("country_vaccinations.csv")));
        service.persistCSV(multipartFile);
    }
}
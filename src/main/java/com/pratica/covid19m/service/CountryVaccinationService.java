package com.pratica.covid19m.service;


import com.opencsv.bean.CsvToBeanBuilder;
import com.pratica.covid19m.model.CountryVaccination;
import com.pratica.covid19m.model.GraphDTO;
import com.pratica.covid19m.model.IsoDatePK;
import com.pratica.covid19m.repository.CountryVaccinationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

@Service
public class CountryVaccinationService {

    private final CountryVaccinationRepository repository;

    public CountryVaccinationService(CountryVaccinationRepository repository) {
        this.repository = repository;
    }

    public void persistCSV(MultipartFile file){
        List<CountryVaccination> result = this.convertToModel(file);
        repository.saveAll(result);
    }

    public List<CountryVaccination> findAll() {
        return null;
    }

    public Optional<CountryVaccination> findByIsoDate(IsoDatePK id) {
        return repository.findById(id);
    }
    
    public List<GraphDTO> vacPDay() {
        return repository.vacPDay();
    }

    public List<CountryVaccination> convertToModel(MultipartFile file) {
        List<CountryVaccination> models;
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            models = new CsvToBeanBuilder<CountryVaccination>(reader)
                    .withType(CountryVaccination.class)
                    .withType(CountryVaccination.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build()
                    .parse();

        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getCause());
        }
        return models;
    }
}

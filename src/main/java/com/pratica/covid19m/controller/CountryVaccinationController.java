package com.pratica.covid19m.controller;

import com.pratica.covid19m.model.CountryVaccination;
import com.pratica.covid19m.model.IsoDatePK;
import com.pratica.covid19m.model.GraphDTO;
import com.pratica.covid19m.service.CountryVaccinationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping(value = {"/countryVaccinatio"} )
public class CountryVaccinationController {

    private final CountryVaccinationService service;

    public CountryVaccinationController(CountryVaccinationService service) {
        this.service = service;
    }

    @GetMapping
    public String status(){
        return "API ON";
    }

    @PostMapping("/upload")
public ResponseEntity<Map<String, String>> persistCSV(@RequestParam("file") MultipartFile file) {
    Map<String, String> response = new HashMap<>();
    try {
        service.persistCSV(file);
        response.put("message", "Arquivo CSV enviado e processado com sucesso.");
        return ResponseEntity.ok(response);
    } catch (Exception e) {
        response.put("error", "Erro ao processar o arquivo CSV: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}


    @GetMapping("/vacPDay")
    public List<GraphDTO> vacPday(){ return service.vacPDay();}


    @GetMapping("/getAll")
    public List<CountryVaccination> getAll(){
        return service.findAll();
    }

    @GetMapping("/get/{isoCode}/{date}")
    public Optional<CountryVaccination> getById(@PathVariable(value="isoCode") String isoCode, @PathVariable(value="date")String date){
        return service.findByIsoDate(new IsoDatePK(isoCode,LocalDate.parse(date)));
    }

}

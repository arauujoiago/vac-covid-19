package com.pratica.covid19m.repository;

import com.pratica.covid19m.model.CountryVaccination;
import com.pratica.covid19m.model.GraphDTO;
import com.pratica.covid19m.model.IsoDatePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryVaccinationRepository extends JpaRepository<CountryVaccination, IsoDatePK> {

    @Query("select new com.pratica.covid19m.model.GraphDTO(cv.date, sum(cv.dailyVaccinationsPerMillion)) from CountryVaccination  cv group by cv.date order by cv.date")
    List<GraphDTO> vacPDay();
}

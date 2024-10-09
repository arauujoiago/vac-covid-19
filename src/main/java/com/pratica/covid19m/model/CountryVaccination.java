package com.pratica.covid19m.model;
    

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;


@Table(name = "country_vaccinations")
@Entity
@Getter
@IdClass(IsoDatePK.class)
@AllArgsConstructor
@NoArgsConstructor
public class CountryVaccination {

    @CsvBindByName(column = "country")
    private String country;

    @Id
    @CsvBindByName(column = "iso_code")
    private String isoCode;

    @Id
    @CsvDate("yyyy-MM-dd")
    @CsvBindByName(column = "date")
    private LocalDate date;

    @CsvNumber("")
    @CsvBindByName(column = "total_vaccinations")
    private Integer totalVaccinations;

    @CsvNumber("")
    @CsvBindByName(column = "people_vaccinated")
    private Integer peopleVaccinated;

    @CsvNumber("")
    @CsvBindByName(column = "people_fully_vaccinated")
    private Integer peopleFullyVaccinated;

    @CsvNumber("")
    @CsvBindByName(column = "daily_vaccinations_raw")
    private Double dailyVaccinationsRaw;

    @CsvNumber("")
    @CsvBindByName(column = "daily_vaccinations")
    private Double dailyVaccinations;

    @CsvNumber("")
    @CsvBindByName(column = "total_vaccinations_per_hundred")
    private Double totalVaccinationsPerHundred;

    @CsvNumber("")
    @CsvBindByName(column = "people_vaccinated_per_hundred")
    private Double peopleVaccinatedPerHundred;

    @CsvNumber("")
    @CsvBindByName(column = "people_fully_vaccinated_per_hundred")
    private Double peopleFullyVaccinatedPerHundred;

    @CsvNumber("")
    @CsvBindByName(column = "daily_vaccinations_per_million")
    private Double dailyVaccinationsPerMillion;

    @CsvBindByName(column = "vaccines")
    private String vaccines;

    @CsvBindByName(column = "source_name")
    private String sourceName;

    @CsvBindByName(column = "source_website")
    private String sourceWebsite;
    

}

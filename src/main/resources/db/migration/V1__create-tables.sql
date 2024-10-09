CREATE TABLE country_vaccinations
(
    iso_code                            VARCHAR(255) NOT NULL,
    country                             VARCHAR(255) NULL,
    date                                date         NOT NULL,
    total_vaccinations                  INT          NULL,
    people_vaccinated                   INT          NULL,
    people_fully_vaccinated             INT          NULL,
    daily_vaccinations_raw              FLOAT       NULL,
    daily_vaccinations                  FLOAT       NULL,
    total_vaccinations_per_hundred      FLOAT       NULL,
    people_vaccinated_per_hundred       FLOAT       NULL,
    people_fully_vaccinated_per_hundred FLOAT       NULL,
    daily_vaccinations_per_million      FLOAT       NULL,
    vaccines                            VARCHAR(255) NULL,
    source_name                         VARCHAR(255) NULL,
    source_website                      VARCHAR(255) NULL,
    CONSTRAINT pk_country_vaccinations PRIMARY KEY (iso_code, date)
);
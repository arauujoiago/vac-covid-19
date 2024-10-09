package com.pratica.covid19m.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IsoDatePK implements Serializable {
    private String isoCode;
    private LocalDate date;
}

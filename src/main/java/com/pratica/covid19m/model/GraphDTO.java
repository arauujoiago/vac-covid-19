package com.pratica.covid19m.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class GraphDTO {
    LocalDate date;
    Double vacs;
}

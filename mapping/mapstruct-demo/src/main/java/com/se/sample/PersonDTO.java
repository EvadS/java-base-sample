package com.se.sample;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.mapstruct.Mapping;

@Data
@Builder
@ToString
public class PersonDTO {
    private String id;
    private String firstName;
    private String lastName;

    private String educationalQualification;
    private String residentialCity;
    private String residentialCountry;
}
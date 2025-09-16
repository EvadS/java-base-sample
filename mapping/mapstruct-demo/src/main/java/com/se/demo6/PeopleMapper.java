package com.se.demo6;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface PeopleMapper {

    List<Employee> toEmployee(List<People> people);

    @Mapping(source = "name", target = "info", qualifiedByName = "displayName")
    Employee toEmployee(People people);


    @Named("displayName")
    default String getAudioId(String name){
        return "Employee with name:" + name;
    }
}

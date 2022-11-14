package com.se.sample;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BasicMapper {
    BasicMapper INSTANCE = Mappers.getMapper(BasicMapper.class);

    BasicUserDTO convert(BasicUser user);


    default PersonDTO convertCustom(BasicUser user) {
        return PersonDTO
                .builder()
                .id(String.valueOf(user.getId()))
                .firstName(user.getName().substring(0, user.getName().indexOf(" ")))
                .lastName(user.getName().substring(user.getName().indexOf(" ") + 1))
                .build();
    }

    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.name", target = "firstName")
    @Mapping(source = "education.degreeName", target = "educationalQualification")
    @Mapping(source = "address.city", target = "residentialCity")
    @Mapping(source = "address.country", target = "residentialCountry")
    PersonDTO convert(BasicUser user, Education education, Address address);
}

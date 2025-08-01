package com.se.demo4;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class App {

    @Getter
    @Setter
    @Builder
    static class ClassSource {
        private int id;
        private String name;
        private String numT;
        private List<AddressSource> addresses;
        private PersonSource person;
    }

    @Getter
    @Setter
    @Builder
    static class AddressSource implements Serializable {
        @JsonProperty("postalCode")
        private String postalCode;
    }

    @Getter
    @Setter
    @Builder
    static class PersonSource implements Serializable {
        @JsonProperty("jobTitle")
        private String jobTitle;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    static class ClassDestination {
        private int id;
        private String name;
        private String numT;
        private List<AddressDestination> addresses;
        private PersonDestination person;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    static class AddressDestination implements Serializable {
        @JsonProperty("zipCode")
        private String zipCode;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    static class PersonDestination implements Serializable {
        @JsonProperty("workTitle")
        private String workTitle;
    }

    @Mapper(uses = {AddressMapper.class})
    interface ClassMapper {
        @Mapping(source = "person.jobTitle", target = "person.workTitle")
        ClassDestination sourceToDestination(ClassSource source);
    }

    @Mapper
    interface AddressMapper {
        @Mapping(source = "postalCode", target = "zipCode")
        AddressDestination sourceToDestination(AddressSource source);
    }

    private static final ClassMapper classMapper = Mappers.getMapper(ClassMapper.class);

    public static void main(String[] args) {
        PersonSource personSource = PersonSource.builder().jobTitle("Dev").build();

        List<AddressSource> addressSources =
                Arrays.asList(
                        AddressSource.builder().postalCode("412101").build(),
                        AddressSource.builder().postalCode("411001").build());

        ClassSource classSource =
                ClassSource.builder()
                        .id(1)
                        .name("Firstname")
                        .numT("2")
                        .addresses(addressSources)
                        .person(personSource)
                        .build();

        ClassDestination classDestination = classMapper.sourceToDestination(classSource);
        System.out.println(classDestination);
    }
}

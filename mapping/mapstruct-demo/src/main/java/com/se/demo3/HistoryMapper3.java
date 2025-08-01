package com.se.demo3;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HistoryMapper3 {

    HistoryMapper3 INSTANCE = Mappers.getMapper(HistoryMapper3.class);

    @Mappings({
            @Mapping(target = "request.userEmail", source = "id.userEmail"),
            @Mapping(target = "request.documentId", source = "id.documentId"),
            @Mapping(target = "request.publisher", source = "publisher")
    })
    HistoryResponse toHistoryResponse (DocumentHistory record);

}

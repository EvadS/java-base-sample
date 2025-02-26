package com.se.demo2;

import com.se.demo2.domain.DocumentHistory;
import com.se.demo2.request.HistoryRequest;
import com.se.demo2.response.HistoryItemResponse;
import com.se.demo2.response.HistoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.util.Date;

@Mapper
public interface DocumentHistoryMapper {

    DocumentHistoryMapper INSTANCE = Mappers.getMapper(DocumentHistoryMapper.class);

    @Mappings({
            @Mapping(source = "documentDate", target = "documentDate", qualifiedByName = "localDateTimeDate")
    })
    DocumentHistory toDocumentHistory(HistoryRequest request);


    @Named("localDateTimeDate")
    default Date localDateTimeToInstant(Long localDateTime) {
        Date date = new Date(localDateTime);
        return date;
    }

    @Named("longToDate")
    default Long longToDate(Date date) {
        return date.getTime();
    }


    @Named("dateToDTimestamp")
    default Timestamp dateToDTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    // Long <-- Date
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(source = "userEmail", target = "request.userEmail"),
            @Mapping(source = "documentDate", target = "request.documentDate", qualifiedByName = "longToDate"),
    })
    HistoryResponse toHistoryResponse(DocumentHistory record);


    // Date -->
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "userEmail", source = "userEmail"),

            @Mapping(target = "documentDate", source = "documentDate", qualifiedByName = "dateToDTimestamp"),

    })
    HistoryItemResponse toHistoryItemResponse(DocumentHistory record);

}

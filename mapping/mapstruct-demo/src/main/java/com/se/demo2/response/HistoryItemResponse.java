package com.se.demo2.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryItemResponse {
    private Long id;

    private String userEmail;
    private String documentId;
    private String documentNumber;
    private String documentName;
    private String documentType;
    public  String publisher;
    public  String status;
    private String statusColor;
    private Timestamp documentDate;
    private Timestamp documentViewDate;
}

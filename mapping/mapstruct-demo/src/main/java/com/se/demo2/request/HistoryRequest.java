package com.se.demo2.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HistoryRequest {
    private String userEmail;
    private String documentId;
//    private String documentNumber;
//    private String documentName;
//    private String documentType;
    public  String publisher;
//    public  String status;
//    private String statusColor;
    private Long documentDate;
    //private Long documentViewDate;
}

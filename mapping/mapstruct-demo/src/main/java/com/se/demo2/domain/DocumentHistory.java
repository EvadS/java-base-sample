package com.se.demo2.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class DocumentHistory implements Serializable {

   private Long id;
   private String userEmail;
//    private String documentId;
//    private String documentNumber;
//    private String documentName;
//    private String documentType;
//    public String publisher;
//    public String status;
    private Date documentDate;
//    private Date documentViewDate;
//    private String statusColor;
}

package com.se.demo3;


import lombok.*;

import java.util.Date;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentHistory {

    private HistoryId id;
    public String publisher;

    public String status;
    private String documentNumber;
    private String documentName;
    private String documentType;
    private Date documentDate;
    private Date documentViewDate;
    private String statusColor;


    public HistoryId getId() {
        return id;
    }

    public void setId(HistoryId id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public Date getDocumentViewDate() {
        return documentViewDate;
    }

    public void setDocumentViewDate(Date documentViewDate) {
        this.documentViewDate = documentViewDate;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }
}

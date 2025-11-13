package ua.se.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

import java.time.LocalDateTime;


public class SummarizeItemResponse {

    private long id;
    private String text;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateTime;
    private String ipsRole;

    public SummarizeItemResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getIpsRole() {
        return ipsRole;
    }

    public void setIpsRole(String ipsRole) {
        this.ipsRole = ipsRole;
    }
}

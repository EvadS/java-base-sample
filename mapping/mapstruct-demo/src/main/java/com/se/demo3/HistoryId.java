package com.se.demo3;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HistoryId {

    private String documentId;

    private String userEmail;
}

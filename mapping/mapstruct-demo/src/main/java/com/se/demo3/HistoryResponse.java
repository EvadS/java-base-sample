package com.se.demo3;


import com.se.demo2.request.HistoryRequest;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryResponse {
    private HistoryRequest request;
}

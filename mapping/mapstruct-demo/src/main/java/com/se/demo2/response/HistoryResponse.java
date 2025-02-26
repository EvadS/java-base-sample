package com.se.demo2.response;

import com.se.demo2.request.HistoryRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryResponse {
    private long id;
    private HistoryRequest request;
}

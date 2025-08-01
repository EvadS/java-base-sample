package com.se.demo3;

import com.se.demo2.request.HistoryRequest;
import org.junit.jupiter.api.Test;


class HistoryMapperTest {


    HistoryId historyId = new HistoryId("1", "mail@mail.com");
    HistoryRequest historyRequest = HistoryRequest.builder()
            .publisher("publisher input")
            .documentId("KD0003")
            .userEmail("my-mail@mail.com")
            .build();

    DocumentHistory dh = new  DocumentHistory();
    //dh.set
    //(historyId, "my publisher");

    @Test
    public void shouldWorkCorrect() {

        HistoryResponse historyResponse = HistoryMapper3.INSTANCE.toHistoryResponse(dh);

        int a = 0;
    }
}
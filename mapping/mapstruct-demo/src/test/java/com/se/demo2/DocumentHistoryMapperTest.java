package com.se.demo2;


import com.se.demo2.domain.DocumentHistory;
import com.se.demo2.request.HistoryRequest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class DocumentHistoryMapperTest {
    @Test
    public void test(){


        HistoryRequest historyRequest = HistoryRequest.builder()
                .documentDate(System.currentTimeMillis())
                .build();

        DocumentHistory documentHistory = DocumentHistoryMapper.INSTANCE.toDocumentHistory(historyRequest);

        assertNotNull(documentHistory);
    }

}
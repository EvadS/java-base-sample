package ua.se.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import ua.se.demo.model.SummarizePagedResponse;
import ua.se.demo.model.SummarizeRequest;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;

public class HttpClientExample3_1_1 {
    private static ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    private static final CloseableHttpClient httpClient  = HttpClientBuilder.create()
            .build();

    public static void main(String[] args) {

        try {
            String result = sendPOST("http://localhost:8087/api/v1/summarize/paged");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String sendPOST(String url) throws IOException {

        SummarizeRequest summarizeRequest = new SummarizeRequest();
        summarizeRequest.setDate(LocalDate.parse("2025-05-29"));
        summarizeRequest.setPageNumber(0);
        summarizeRequest.setPageSize(10);

        String result = "";

        HttpPost post = new HttpPost(url);
        post.addHeader("content-type", "application/json;charset=UTF-8");
        post.setHeader("Accept-Language", "ua-UA");
        post.setHeader("Accept", "application/json");

//        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String json = mapper.writeValueAsString(summarizeRequest);

        // send a JSON data
        post.setEntity(new StringEntity(json));

        try {
            SummarizePagedResponse execute = httpClient.execute(post,
                    response -> {
                        String string = EntityUtils.toString(response.getEntity());
                        int statusCode = response.getStatusLine().getStatusCode();

                        // 200
                        SummarizePagedResponse car = mapper.readValue(string, SummarizePagedResponse.class);
                        return car;
                    }
            );

            System.out.println("SummarizePagedResponse");
            System.out.println(execute.toString());
        } catch (IOException e) {
            System.out.println("error while send request to:" + url);
            System.out.println(e.getMessage()+ e);
        }

        return result;
    }

}
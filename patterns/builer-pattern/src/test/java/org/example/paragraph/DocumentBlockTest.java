package org.example.paragraph;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Address;
import org.junit.Assert;
import org.junit.Test;

public class DocumentBlockTest {

    @Test
    public void  testBase () throws JsonProcessingException {

        BlockType blockType = BlockType.TEXT;
        BlockText blockText = new BlockText("block text");
        String css = "class-a class-b";
        String attributes= "attributes";


        DocumentBlock documentBlock = DocumentBlock.builder()
                .blockType(blockType)
                .blockText(blockText)
                .css(css)
                .attributes(attributes)
                .build();


        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(documentBlock);
        System.out.println("---------------------------------------------");
        System.out.println(json);
        System.out.println("---------------------------------------------");

        DocumentBlock read = objectMapper.readValue(json, DocumentBlock.class);

        Assert.assertNotNull(documentBlock);
    }
}
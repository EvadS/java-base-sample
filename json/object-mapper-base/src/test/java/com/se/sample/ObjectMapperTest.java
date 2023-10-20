package com.se.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.sample.utils.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ObjectMapperTest {

    ObjectMapper mapper = new ObjectMapper();


    @Test
    public void read_json_work_correct() throws Exception {
        //	Arrange
        String targetLocation = ObjectMapperTest.class
                .getProtectionDomain().getCodeSource().getLocation().getFile();
        //	Act
        List<String> result = FileUtils.ReadListFromJson(targetLocation, "\\json\\old_structure.json");

        //	Assert
        Assert.assertNotNull(result);
    }

    @Test
    public void read_document_Should_work_correct() throws Exception {
        //	Arrange
        String targetLocation = ObjectMapperTest.class
                .getProtectionDomain().getCodeSource().getLocation().getFile();
        //	Act
        List<String> result = FileUtils.ReadListFromJson(targetLocation, "\\json\\lu\\document_structure.json");

        //	Assert
        Assert.assertNotNull(result);
    }

}

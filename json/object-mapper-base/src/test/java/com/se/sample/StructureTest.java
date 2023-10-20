package com.se.sample;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.sample.model.Example;
import com.se.sample.model.Structure;
import com.se.sample.utils.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StructureTest {

    @Test
    public void read_old_structure_should_work_correct() throws IOException {

        //	Arrange
        String targetLocation = StructureTest.class
                .getProtectionDomain().getCodeSource().getLocation().getFile();
        //	Act
        List<Structure> structures = FileUtils.ReadStructureListFromJson(targetLocation, "\\json\\lz\\document_structure.json");

        //	Assert
        Assert.assertNotNull(structures);
    }

    @Test
    public void read_new_structure_should_work_correct() throws IOException {

        //	Arrange
        String targetLocation = StructureTest.class
                .getProtectionDomain().getCodeSource().getLocation().getFile();
        //	Act
        List<Structure> structures = FileUtils.ReadStructureListFromJson(targetLocation, "\\json\\lu\\document_structure.json");

        //	Assert
        Assert.assertNotNull(structures);
    }

    @Test
    public void read_new_structure_should2_work_correct() throws IOException {

        //	Arrange
        String targetLocation = StructureTest.class
                .getProtectionDomain().getCodeSource().getLocation().getFile();
        //	Act
        List<Structure> structures = FileUtils.ReadStructureListFromJson(targetLocation, "\\json\\lu\\struct2.json");

        //	Assert
        Assert.assertNotNull(structures);
    }

    @Test
    public void read_new_structure_should2_lz_work_correct() throws IOException {

        //	Arrange
        String targetLocation = StructureTest.class
                .getProtectionDomain().getCodeSource().getLocation().getFile();
        //	Act
        List<Structure> structures = FileUtils.ReadStructureListFromJson(targetLocation, "\\json\\lz\\struct2.json");

        //	Assert
        Assert.assertNotNull(structures);
    }


    @Test
    public void read_content_error_should_lu_work_correct() throws IOException {

        //	Arrange
        String targetLocation = StructureTest.class
                .getProtectionDomain().getCodeSource().getLocation().getFile();
        //	Act
       // List<StructureVer2> structures = FileUtils.ReadStructureVer2ListFromJson(targetLocation, "\\json\\lu\\content_error.json");

        String filepath = targetLocation + "\\json\\lu\\content_error.json";

        ObjectMapper mapper = new ObjectMapper();
        Example res ;
        try (InputStream is = new FileInputStream(new File(filepath))) {
            res =  mapper.readValue(is, new TypeReference<Example>() {
            });
        }

        //	Assert
        Assert.assertNotNull(res);
    }

    @Test
    public void write_to_str(){
        String str = "";
    }
}

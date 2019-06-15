package com.sandbox.tools;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    @Test
    public void readFileFromResourcesTest(){
        FileReader fileReader = new FileReader();
        String content = fileReader.getDataContent();
        String expectedContent = "Hello world test";
        assertEquals(expectedContent, content);
    }

}

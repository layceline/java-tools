package com.sandbox.tools;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {

    private String dataContent = "";

    public FileReader(){
        dataContent = readFileAsString("test.txt");
    }

    private String readFileAsString(String filename){

        String content = "";
        try{
            Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
            content = new String(Files.readAllBytes(path));
        } catch(URISyntaxException | IOException e){
            System.out.println(e);
        }

        return content;
    }

    public String getDataContent() {
        return dataContent;
    }
}

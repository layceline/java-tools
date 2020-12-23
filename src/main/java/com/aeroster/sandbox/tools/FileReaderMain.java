package com.aeroster.sandbox.tools;

import com.aeroster.sandbox.tools.filereader.FileReader;

public class FileReaderMain {

    public static void main(String [] args){
        FileReader fileReader = new FileReader();
        String content = fileReader.getDataContent();
        System.out.println(content);
    }
}

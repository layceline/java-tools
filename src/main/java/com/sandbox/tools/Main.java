package com.sandbox.tools;

public class Main {

    public static void main(String [] args){
        FileReader fileReader = new FileReader();
        String content = fileReader.getDataContent();
        System.out.println(content);
    }
}

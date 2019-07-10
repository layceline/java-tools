package com.sandbox.tools;

import com.sandbox.tools.argsparser.ArgumentParser;
import org.apache.commons.cli.*;

public class ArgumentParserMain {

    public static long SERVER_BATCH_MAX_SIZE;
    public static long SERVER_REQUEST_TIMEOUT;

    public static void main(String[] args) {

        // create Options object
        final Options options = ArgumentParser.generateOptions();

        if (args.length < 1)
        {
            ArgumentParser.printHelp(options);
            System.exit(-1);
        }

        final CommandLine commandLine = ArgumentParser.generateCommandLine(options, args);

        if(commandLine != null){
            // Faut il deux try ou un seul?
            try {
                SERVER_BATCH_MAX_SIZE = Long.valueOf(commandLine.getOptionValue(ArgumentParser.MAX_BATCH_SIZE_OPTION));
            } catch (NumberFormatException e){
                System.out.println("Please give a long value for " + ArgumentParser.MAX_BATCH_SIZE_OPTION);
                // exit or set default value
            }
            try {
                SERVER_REQUEST_TIMEOUT = Long.valueOf(commandLine.getOptionValue(ArgumentParser.TIMEOUT_OPTION));
            } catch (NumberFormatException e){
                System.out.println("Please give a long value for " + ArgumentParser.TIMEOUT_OPTION);
                // exit or set default value
            }
        }
        System.out.println("Server Max Batch Size: " + SERVER_BATCH_MAX_SIZE);
        System.out.println("Server Request Timeout: " + SERVER_REQUEST_TIMEOUT);
    }



}

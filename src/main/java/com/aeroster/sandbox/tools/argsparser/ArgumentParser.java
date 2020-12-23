package com.aeroster.sandbox.tools.argsparser;

import org.apache.commons.cli.*;

public class ArgumentParser {

    public static final String TIMEOUT_OPTION = "timeout";
    public static final String MAX_BATCH_SIZE_OPTION = "max_batch_size";

    public static Options generateOptions(){
        final Option timeoutOption = Option.builder("t")
                .required(true)
                .hasArg(true)
                .longOpt(TIMEOUT_OPTION)
                .desc("Request timeout")
                .build();
        final Option maxBatchSizeOption = Option.builder("s")
                .required(true)
                .hasArg(true)
                .longOpt(MAX_BATCH_SIZE_OPTION)
                .desc("Get data max return size")
                .build();

        final Options options = new Options();
        options.addOption(timeoutOption);
        options.addOption(maxBatchSizeOption);
        return options;
    }

    public static CommandLine generateCommandLine(Options options, String[] commandLineArgs){
        final CommandLineParser cmdLineParser = new DefaultParser();
        CommandLine commandLine = null;
        try
        {
            commandLine = cmdLineParser.parse(options, commandLineArgs);
        }
        catch (ParseException parseException)
        {
            parseException.printStackTrace();
        }
        return commandLine;
    }

    /**
     * Generate and print help information with Apache Commons CLI.
     *
     * @param options Instance of Options to be used to prepare
     *    help formatter.
     */
    public static void printHelp(final Options options)
    {
        final HelpFormatter formatter = new HelpFormatter();
        final String syntax = "main.class";
        formatter.printHelp(syntax, options, true);
    }
}

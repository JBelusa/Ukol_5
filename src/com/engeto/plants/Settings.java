package com.engeto.plants;

public class Settings {
    private static final String getFilePlantDelimiter = "\t";
    private static final String defaultFileName = "kvetiny.txt";

    private static final String testWrongDate = "kvetiny-spatne-datum.txt";

    private static final String testWrongFrequency = "kvetiny-spatne-frekvence.txt";



    private static final String defaultSaveFileName = "novekvetiny.txt";

    public static String getFilePlantDelimiter(){
        return getFilePlantDelimiter;
    }

    public static String getDefaultFileName(){
        return defaultFileName;
    }

    public static String getTestWrongDate(){
        return testWrongDate;
    }
    public static String getTestWrongFrequency(){
        return testWrongFrequency;
    }

    public static String getDefaultSaveFileName(){
        return defaultSaveFileName;
    }

}

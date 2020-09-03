package com.learning.corenlp;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;

public class Pipeline {

    private static StanfordCoreNLP stanfordCoreNLP;
    private static Properties properties;
//    private static String propertiesName = "tokenize";

    private Pipeline() {}

//    static
//    {
//        properties = new Properties();
//        properties.setProperty("annotators", propertiesName);
//    }

    public static StanfordCoreNLP getInstance(String propertiesName) {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);

        if (stanfordCoreNLP == null)
            stanfordCoreNLP = new StanfordCoreNLP();

        return stanfordCoreNLP;
    }
}

package com.learning.corenlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class SentimentAnalysis {

    public static void main(String[] args) {
        System.out.println("Initializing Stanford CoreNLP...");
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getInstance("tokenize, ssplit, pos, lemma, ner, parse, sentiment");

        String text = "Hey hey! What are you doing tonight? Fancy going for a drink later? I fucking hate you. I am so joyous!";

        System.out.println("Creating core document...");
        CoreDocument coreDocument = new CoreDocument(text);
        System.out.println("Annotating document...");
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreSentence> sentences = coreDocument.sentences();

        for(CoreSentence sent: sentences) {
            String sentenceText = sent.text();
            String sentiment = sent.sentiment();
            System.out.println(sentenceText + " -> " + sentiment);
            System.out.println();
        }
    }
}

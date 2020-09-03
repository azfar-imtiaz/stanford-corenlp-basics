package com.learning.corenlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class Lemmatization {

    public static void main(String[] args) {
        System.out.println("Initializing Stanford CoreNLP...");
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getInstance("tokenize, spplit, lemma");

        String text = "Hey hey! What are you doing tonight? Fancy going for a drink later?";

        System.out.println("Creating core document...");
        CoreDocument coreDocument = new CoreDocument(text);
        System.out.println("Annotating document...");
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreSentence> sentences = coreDocument.sentences();

        for(CoreSentence sent: sentences) {
            System.out.println(sent.toString());
            List<CoreLabel> words = sent.tokens();
            // NOTE: This function is only available in the CoreSentence object. If we don't do sentence tokenization,
            // then lemmas will need to be extracted in a different way - look below
            List<String> lemmas = sent.lemmas();
            for (int i = 0; i < lemmas.size(); i++) {
                CoreLabel word = words.get(i);
//                String lemma = lemmas.get(i);

                 // NOTE: Alternatively, if we're not using sentence tokenization...
                 String lemma = word.get(CoreAnnotations.LemmaAnnotation.class);
                System.out.println(word.word() + " -> " + lemma);
            }
            System.out.println();
        }
    }
}

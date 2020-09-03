package com.learning.corenlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class POSTags {

    public static void main(String[] args) {
        System.out.println("Initializing Stanford CoreNLP...");
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getInstance("tokenize, spplit, pos");

        String text = "Hey hey! What are you up to tonight? Fancy going for a drink later?";

        System.out.println("Creating core document...");
        CoreDocument coreDocument = new CoreDocument(text);
        System.out.println("Annotating document...");
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreSentence> sentences = coreDocument.sentences();

        for(CoreSentence sent: sentences) {
            System.out.println(sent.toString());
            List<CoreLabel> words = sent.tokens();
            // NOTE: This function is only available in the CoreSentence object. If we don't do sentence tokenization,
            // then POS tags will need to be extracted in a different way - look below
            List<String> posTags = sent.posTags();
            for (int i = 0; i < posTags.size(); i++) {
                CoreLabel word = words.get(i);
                String posTag = posTags.get(i);

                // NOTE: Alternatively, if we're not using sentence tokenization...
                // String posTag = word.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                System.out.println(word.word() + " -> " + posTag);
            }
            System.out.println();
        }
    }
}

package com.learning.corenlp;

import com.learning.corenlp.Pipeline;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class SentenceTokenization {

    public static void main(String[] args) {
        System.out.println("Initializing Stanford CoreNLP...");
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getInstance("tokenize, spplit");

        String text = "Hey hey! What are you up to tonight? Fancy going for a drink later?";

        System.out.println("Creating core document...");
        CoreDocument coreDocument = new CoreDocument(text);
        System.out.println("Annotating document...");
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreSentence> sentences = coreDocument.sentences();

        for(CoreSentence sent: sentences) {
            System.out.println(sent.toString());
            List<CoreLabel> words = sent.tokens();
            for (CoreLabel word: words) {
                System.out.println(word.word());
            }
            System.out.println();
        }

    }
}

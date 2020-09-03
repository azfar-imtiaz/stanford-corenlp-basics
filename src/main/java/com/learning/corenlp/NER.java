package com.learning.corenlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class NER {

    public static void main(String[] args) {
        System.out.println("Initializing Stanford CoreNLP...");
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getInstance("tokenize, ssplit, pos, lemma, ner");

        String text = "Hey hey! What are you doing tonight? Fancy going for a drink later?";

        System.out.println("Creating core document...");
        CoreDocument coreDocument = new CoreDocument(text);
        System.out.println("Annotating document...");
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreSentence> sentences = coreDocument.sentences();

        for(CoreSentence sent: sentences) {
            System.out.println(sent.toString());
            List<CoreLabel> words = sent.tokens();
            /*
                NOTE: This function is only available in the CoreSentence object
                This entityMentions() function returns a list of EntityMention objects, and this is the list of only
                those words which have an entity. So this cannot be used in conjunction with a loop over all words, since
                both lists are of different sizes.

                List<CoreEntityMention> entities = sent.entityMentions();
            */
            for (CoreLabel word : words) {
                String ent = word.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                System.out.println(word.word() + " -> " + ent);
            }
            System.out.println();
        }
    }
}

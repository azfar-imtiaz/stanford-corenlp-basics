import com.learning.corenlp.Pipeline;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class Tokenization {

    public static void main(String[] args) {
        System.out.println("Initializing Stanford CoreNLP...");
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getInstance("tokenize");

        String text = "Hey hey! What are you up to tonight?";

        System.out.println("Creating core document...");
        CoreDocument coreDocument = new CoreDocument(text);
        System.out.println("Annotating document...");
        stanfordCoreNLP.annotate(coreDocument);

        for (CoreLabel coreLabel: coreDocument.tokens()) {
            System.out.println(coreLabel.word());
        }
    }
}

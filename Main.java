import nlp.languagemodel.LanguageModel;
import nlp.languagemodel.Shannon;
import nlp.ngram.NGramManager;

/**
* Main
*/
public class Main {
	
	public static void main(String[] args) {
		
		Shannon ss = new Shannon(new LanguageModel(new NGramManager("RRR")));
		
	}
	
}

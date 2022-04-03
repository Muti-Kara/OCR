import java.io.IOException;
import java.util.ArrayList;

import image.GrayBuffer;
import image.io.ImageReader;
import image.io.ImageWriter;
import neuralnet.algebra.matrix.Matrix;
import neuralnet.network.NeuralNetwork;
import neuralnet.preproccess.parameters.Reader;
import nlp.datastructures.ProbableString;
import nlp.languagemodel.LanguageModel;
import nlp.ngram.NGramManager;
import nlp.spellcheck.NoisyChannel;

/**
* Main
*/
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		GrayBuffer img = ImageReader.read("RRR");
		ImageWriter.write(img, "rrrr");
		LanguageModel lm = new LanguageModel(new NGramManager("RRRRR"));
		NoisyChannel nc = new NoisyChannel();
		NeuralNetwork nn = Reader.readNN();
		String s = nn.classify(new Matrix(20, 10)); //TODO take image instead matrix
		ArrayList<ProbableString> candidates = nc.candidates(s);
		double max = 0;
		for(ProbableString str : candidates){
			max += str.getProbability() * 1e9 * lm.probability(str.getStr());
		}
		System.out.println(max);
		
	}
	
}

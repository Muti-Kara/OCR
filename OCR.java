import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import dip.Segmentation;
import dip.data.MyImage;
import dip.io.MyImageIO;

import nnet.network.NeuralNetwork;
import nnet.network.net.ANN;
import nnet.network.net.CNN;

public class OCR {

	public static void main(String[] args) throws IOException {
		MyImage image = MyImageIO.read(args[0]).resize(720, 480);
		Segmentation segmentation = new Segmentation(image);
		
		CNN cnn = new CNN();
		cnn.addLayer(CNN.CONVOLUTION, 2, 5);
		cnn.addLayer(CNN.MAX_POOL, 2);
		cnn.addLayer(CNN.CONVOLUTION, 2, 3);
		cnn.addLayer(CNN.MAX_POOL, 2);
		
		cnn.read(new Scanner(new File("CNN.txt")));

		ANN ann = new ANN();
		ann.addLayer(ANN.INPUT, 484);
		ann.addLayer(ANN.SOFTMAX, 26);
		
		ann.read(new Scanner(new File("ANN.txt")));
		
		NeuralNetwork net = new NeuralNetwork();
		net.addNet(cnn);
		net.addNet(ann);
		
		String text = "";
		for (int i = 0; i < segmentation.size(); i++) {
			MyImage[] line = segmentation.line(i);
			for (MyImage character : line) {
				text += net.classify(character.resize(49, 49).convertToDouble2D());
			}
			text += "\n";
		}
		
		System.out.println(text);
		
	}
}

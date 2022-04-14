import java.io.IOException;

import image.GrayBuffer;

import image.io.ImageReader;
import image.io.ImageWriter;

import image.operation.Sauvola;
import image.operation.GrayScale;

import image.parser.LineParser;
import neuralnet.matrix.Matrix;
import neuralnet.network.NeuralNetwork;
import neuralnet.network.layer.FullyConnected;
import neuralnet.network.net.ANN;

/**
* Main
*/
public class Main {
	
	public static void main(String[] args) throws IOException {
		// String dir = "/home/yuio/Project";
		
		// GrayBuffer buff = ImageReader.read(dir + "/data.jpg");
		
		// double factor = 0.6;
		
		// buff = buff.resize(factor);
		// ImageWriter.write(buff, dir + "/grayscale.jpg");
		// System.out.println("Resizing is done");
		
		// GrayScale.convertRGBtoGrayScale(buff);
		// ImageWriter.write(buff, dir + "/grayscale.jpg");
		// System.out.println("Grayscaling is done");
		
		// Sauvola.binarize(buff);
		// ImageWriter.write(buff, dir + "/binary.jpg");
		// System.out.println("Binarization is done");
		
		// LineParser parser = new LineParser(buff);
		// parser.parse();
		// ImageWriter.write(buff, dir + "/lined_binary.jpg");
		// System.out.println("Line parsing is done");
		
		NeuralNetwork net = new NeuralNetwork();
		ANN ann = new ANN();
		ann.addLayer(2, FullyConnected.IDENTITY_ACTIVATION, FullyConnected.PRETRAINED);
		ann.addLayer(3, FullyConnected.RELU_ACTIVATION, FullyConnected.PRETRAINED);
		net.addNet(ann);
		net.forwardPropagation(new Matrix(2, 1));
		System.out.println(net);
	}
	
}

import java.io.IOException;

import image.GrayBuffer;
import image.Line;
import image.io.ImageReader;
import image.io.ImageWriter;
import image.operation.GaussianSmoothing;
import image.operation.GrayScale;
import image.operation.Sauvola;
import image.parser.LineParser;

/**
* Main
*/
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		GrayBuffer img = ImageReader.read("input.jpg");
		
		GrayScale.convertRGBtoGrayScale(img);;
		
		
		GaussianSmoothing.calculateKernel(25);
		img = GaussianSmoothing.smooth(img);
		
		// Sauvola.binarize(img);
		// ImageWriter.write(img, "binarized.jpg");
		
		LineParser parser = new LineParser(img);
		parser.parse();
		
		ImageWriter.write(img, "result.jpg");
		
		System.out.println(parser.getSize());
		
		Line line  = parser.getLine(4);
		for (int i = 0; i < line.getSize(); i++) {
			img.mark(line.getW(i), line.getH(i));
		}
		
		ImageWriter.write(img, "single.jpg");
	}
	
}

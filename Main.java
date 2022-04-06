import java.io.IOException;

import image.Sauvola;
import image.GrayBuffer;
import image.io.ImageReader;
import image.io.ImageWriter;

/**
* Main
*/
public class Main {
	
	public static void main(String[] args) throws IOException {
		String dir = "/home/yuio/Project";
		
		GrayBuffer buff = ImageReader.read(dir + "/data.jpg");
		//buff = buff.resize(buff.getWidth()/4, buff.getHeight()/4);
		Sauvola.convertRGBtoGrayScale(buff);
		Sauvola.binarize(buff);
		//buff = buff.resize(buff.getWidth()*2, buff.getHeight()*2);
		ImageWriter.write(buff, dir + "/binary.jpg");
		
	}
	
}

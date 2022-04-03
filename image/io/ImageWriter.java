package image.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
* ImageWriter
*/
public class ImageWriter {
	
	public static void write(BufferedImage img, String fileName) throws IOException {
		ImageIO.write(img, "JPG", new File(fileName));
	}
	
}

package image.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
* ImageReader
*/
public class ImageReader {
	
	public static BufferedImage read(String fileName) throws IOException {
		return ImageIO.read(new File(fileName));
	}
	
}

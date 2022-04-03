package image;

import java.awt.image.BufferedImage;

/**
* Image
* @author Muti Kara
*/
public class ImageBuffer {
	BufferedImage img;
	int width;
	int height;
	
	public ImageBuffer(BufferedImage img) {
		this.img = img;
		this.width = img.getWidth();
		this.height = img.getHeight();
		for(int w = 0; w < width; w++){
			for(int h = 0; h < height; h++){
				int p = img.getRGB(w, h);
				p = (p >> 16 & 0xff + p >> 8 & 0xff + p & 0xff)/3;
				set(w, h, p);
			}
		}
	}
	
	public int get(int w, int h) {
		return img.getRGB(w, h) & 0xff;
	}
	
	public void set(int w, int h, int value) {
		img.setRGB(w, h, (0xff << 24 | value << 16 | value << 8 | value));
	}
	
}

package image;

import java.awt.image.BufferedImage;

/**
* My grayscale image data structure for image manipulation
* @author Muti Kara
*/
public class GrayBuffer {
	BufferedImage img;
	int width;
	int height;
	
	/**
	* Creates an GrayBuffer object from given BufferedImage
	* @param img
	*/
	public GrayBuffer(BufferedImage img) {
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
	
	/**
	* Creates an empty GrayBuffer
	* @param width
	* @param height
	*/
	public GrayBuffer(int width, int height) {
		this.width = width;
		this.height = height;
		this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}
	
	/**
	* 
	* @param areaX
	* @param areaY
	* @param areaWidth
	* @param areaHeight
	* @return the rectangular area as a GrayBuffer
	*/
	public GrayBuffer cut(int areaX, int areaY, int areaWidth, int areaHeight) {
		GrayBuffer cutted = new GrayBuffer(areaWidth, areaHeight);
		for(int w = areaX; w < areaX + areaWidth; w++){
			for(int h = areaY; h < areaY + areaHeight; h++){
				cutted.set(w - areaX, h - areaY, this.get(w, h));
			}
		}
		return cutted;
	}
	
	/**
	* 
	* @param w
	* @param h
	* @return pixel value of (w, h)
	*/
	public int get(int w, int h) {
		return img.getRGB(w, h) & 0xff;
	}
	
	/**
	* Sets pixel with value (between 0 and 255)
	* @param w
	* @param h
	* @param value
	*/
	public void set(int w, int h, int value) {
		img.setRGB(w, h, (0xff << 24 | value << 16 | value << 8 | value));
	}
	
	/**
	* 
	* @return BufferedImage object that this object holds
	*/
	public BufferedImage getBuffer() {
		return img;
	}
	
}

package image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

/**
* My grayscale image data structure for image manipulation
* @author Muti Kara
*/
public class GrayBuffer {
	final int CONTRAST = 40;
	
	BufferedImage img;
	int width;
	int height;
	
	String text;
	double probability;
	double background = 0;
	
	/**
	* Creates an GrayBuffer object from given BufferedImage
	* @param img
	*/
	public GrayBuffer(BufferedImage img) {
		RescaleOp adjust = new RescaleOp(1.3f, 15, null);
		adjust.filter(img, img);
		
		this.img = img;
		this.width = img.getWidth();
		this.height = img.getHeight();
		
		for(int w = 0; w < width; w++){
			for(int h = 0; h < height; h++){
				int p = img.getRGB(w, h);
				p = ((p >> 16 & 0xff) + (p >> 8 & 0xff) + (p & 0xff))/3;
				p = (p/CONTRAST) * CONTRAST;
				set(w, h, p);
			}
		}
		for(int w = 0; w < width; w++){
			for(int h = 0; h < height; h++){
				background += get(w, h);
			}
		}
		background /= width * height;
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
		BufferedImage cutted = img.getSubimage(areaX, areaY, areaWidth, areaHeight);
		return new GrayBuffer(cutted);
	}
	
	/**
	* 
	* @param newWidth
	* @param newHeight
	* @return resized GrayBuffer 
	*/
	public GrayBuffer resize(int newWidth, int newHeight) {
		BufferedImage newImg = new BufferedImage(newWidth, newHeight, this.getBuffer().getType());
		Graphics2D graphics2d = newImg.createGraphics();
		graphics2d.drawImage(img, 0, 0, newWidth, newHeight, null);
		graphics2d.dispose();
		return new GrayBuffer(newImg);
	}
	
	/**
	* 
	* @return a 2D double array from BufferedImage
	*/
	public double[][] convertToDouble2D() {
		double[][] matrix = new double[width][height];
		for(int w = 0; w < width; w++)
			for(int h = 0; h < height; h++)
				matrix[w][h] = this.get(w, h);
		return matrix;
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
	
	/**
	* 
	* @return width of this BufferedImage
	*/
	public int getWidth() {
		return width;
	}

	/**
	* 
	* @return height of this BufferedImage
	*/
	public int getHeight() {
		return height;
	}
	
	/**
	* 
	* @return bacground of this image
	*/
	public double getBackground() {
		return background;
	}
}

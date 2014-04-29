
package com.model;

/**
 * @author David
 *
 */
public class Color {
	
	private byte r;
	private byte g;
	private byte b;

	public final static Color black = new Color((byte)0 ,(byte)0 ,(byte)0);
	public final static Color BLACK = black;
	public final static Color blue = new Color((byte)0 ,(byte)0 ,(byte)255);
	public final static Color BLUE = blue;
	public final static Color cyan = new Color((byte)0 ,(byte)255 ,(byte)255);
	public final static Color CYAN = cyan;
	public final static Color darkGray = new Color((byte)64 ,(byte)64 ,(byte)64);
	public final static Color DARK_GRAY = darkGray;
	public final static Color gray = new Color((byte)128 ,(byte)128 ,(byte)128);
	public final static Color GRAY = gray;
	public final static Color green = new Color((byte)0 ,(byte)255 ,(byte)0);
	public final static Color GREEN = green;
	public final static Color lightGray = new Color((byte)192 ,(byte)192 ,(byte)192);
	public final static Color LIGHT_GRAY = lightGray;
	public final static Color magenta = new Color((byte)255 ,(byte)0 ,(byte)255);
	public final static Color MAGENTA = magenta;
	public final static Color orange = new Color((byte)255 ,(byte)200 ,(byte)0);
	public final static Color ORANGE = orange;
	public final static Color pink = new Color((byte)255 ,(byte)175 ,(byte)175);
	public final static Color PINK = pink;
	public final static Color red = new Color((byte)255 ,(byte)0 ,(byte)0);
	public final static Color RED = red;
	public final static Color white = new Color((byte)255 ,(byte)255 ,(byte)255);
	public final static Color WHITE = white;
	public final static Color yellow = new Color((byte)255 ,(byte)255 ,(byte)0);
	public final static Color YELLOW = yellow;
	
	public Color(byte red, byte green, byte blue) {
		this.r = red;
		this.g = green;
		this.b = blue;
	}

	/**
	 * @return the red
	 */
	public byte getRed() {
		return r;
	}

	/**
	 * @return the green
	 */
	public byte getGreen() {
		return g;
	}

	/**
	 * @return the blue
	 */
	public byte getBlue() {
		return b;
	}
	
	public byte[] toByteArray() {
		byte[] ret = new byte[3];
		ret[0] = this.r;
		ret[1] = this.g;
		ret[2] = this.b;
		return ret;
	}
	
}

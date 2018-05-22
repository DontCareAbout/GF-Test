package us.dontcareabout.gfTest.client.ui;

import com.google.gwt.user.client.Random;
import com.sencha.gxt.chart.client.draw.Color;
import com.sencha.gxt.chart.client.draw.RGB;

import us.dontcareabout.gxt.client.draw.LRectangleSprite;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Toolkit {
	public static LRectangleSprite genRectangle() {
		return genRectangle(100, 100);
	}

	public static LRectangleSprite genRectangle(double w, double h) {
		LRectangleSprite result = new LRectangleSprite();
		result.setWidth(w);
		result.setHeight(h);
		result.setRadius(10);
		RGB color = new RGB(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256));
		result.setFill(color);
		result.setStroke(new RGB(256 - color.getRed(), 256 - color.getGreen(), 256 - color.getBlue()));
		result.setStrokeWidth(2);
		return result;
	}

	public static TextButton genButton(String text) {
		return genButton(text, RGB.WHITE, RGB.BLACK);
	}

	public static TextButton genButton(String text, Color textColor, Color bgColor) {
		TextButton result = new TextButton(text);
		result.setTextColor(textColor);
		result.setBgColor(bgColor);
		result.setBgRadius(10);
		return result;
	}
}

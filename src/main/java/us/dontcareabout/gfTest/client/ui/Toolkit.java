package us.dontcareabout.gfTest.client.ui;

import com.google.gwt.user.client.Random;
import com.sencha.gxt.chart.client.draw.RGB;

import us.dontcareabout.gxt.client.draw.LRectangleSprite;

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
}

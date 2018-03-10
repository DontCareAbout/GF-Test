package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.RGB;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gxt.client.draw.LayerContainer;
import us.dontcareabout.gxt.client.draw.LayerSprite;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_11_3 extends LayerContainer implements Issue {
	final int col = 10;
	final int row = 20;

	public Issue_11_3() {
		for (int i = 0; i < col * row; i++) {
			gen();
		}
	}

	@Override
	protected void onResize(int width, int height) {
		double w = width * 1.0 / col;
		double h = height * 1.0 / row;

		for (int i = 0; i < col; i++) {
			final double x = w * i;
			for (int j = 0; j < row; j++) {
				LayerSprite ls = (LayerSprite)getLayers().get(i * row + j);
				ls.onResize(w, h);
				ls.setLX(x);
				ls.setLY(h * j);
			}
		}

		super.onResize(width, height);
	}

	private TextButton gen() {
		TextButton btn = new TextButton("A█國y");
		btn.setWidth(250);
		btn.setHeight(160);
		btn.setBgColor(RGB.MAGENTA);
		btn.setBgRadius(5);
		addLayer(btn);
		return btn;
	}

	@Override
	public int number() {
		return 11;
	}

	@Override
	public String[] tags() {
		return new String[]{"GF-Draw", "TextButton"};
	}

	@Override
	public String topic() {
		return "TextButton resize 的效能測試";
	}
}

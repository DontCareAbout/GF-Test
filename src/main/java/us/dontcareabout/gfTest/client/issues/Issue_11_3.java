package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.RGB;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gfTest.client.ui.Toolkit;
import us.dontcareabout.gxt.client.draw.LayerContainer;
import us.dontcareabout.gxt.client.draw.LayerSprite;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_11_3 extends LayerContainer implements Issue {
	final int col = 10;
	final int row = 20;

	public Issue_11_3() {
		for (int i = 0; i < col * row; i++) {
			TextButton btn = Toolkit.genButton("A█國y", RGB.WHITE, RGB.BLUE);
			btn.resize(250, 160);
			addLayer(btn);
		}
	}

	@Override
	protected void onResize(int width, int height) {
		double w = width * 1.0 / col;
		double h = height * 1.0 / row;

		for (int i = 0; i < col; i++) {
			final double x = w * i;
			for (int j = 0; j < row; j++) {
				LayerSprite ls = getLayers().get(i * row + j);
				ls.resize(w, h);
				ls.setLX(x);
				ls.setLY(h * j);
			}
		}

		super.onResize(width, height);
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

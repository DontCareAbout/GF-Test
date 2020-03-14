package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.core.client.util.Margins;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gxt.client.draw.LayerContainer;
import us.dontcareabout.gxt.client.draw.LayerSprite;
import us.dontcareabout.gxt.client.draw.layout.HorizontalLayoutLayer;
import us.dontcareabout.gxt.client.draw.layout.VerticalLayoutLayer;

public class Issue_42 extends LayerContainer implements Issue {
	private static final Margins margins = new Margins(4, 8, 12, 16);

	private HorizontalLayoutLayer root = new HorizontalLayoutLayer();

	public Issue_42() {
		for (int i = 0; i < 4; i++) {
			VerticalLayoutLayer vll = new VerticalLayoutLayer();
			vll.setMargins(margins);
			vll.setGap(10);
			vll.setBgColor(RGB.GREEN);
			root.addChild(vll, i == 0 ? 1 : i * 100);

			for (int j = 0; j < 4; j++) {
				LayerSprite ls = new LayerSprite();
				ls.setBgColor(RGB.ORANGE);
				vll.addChild(ls, j == 0 ? 1 : j * 50);
			}
		}

		root.setMargins(margins);
		root.setGap(10);
		root.setBgColor(RGB.PINK);
		addLayer(root);
	}

	@Override
	protected void onResize(int width, int height) {
		root.resize(width, height);
		super.onResize(width, height);
	}

	@Override
	public int number() {
		return 42;
	}

	@Override
	public String[] tags() {
		return new String[]{"GF-Draw", "VerticalLayoutLayer", "HorizontalLayoutLayer"};
	}

	@Override
	public String topic() {
		return "VerticalLayoutLayer / HorizontalLayoutLayer 功能測試（含 gap / margin）";
	}
}

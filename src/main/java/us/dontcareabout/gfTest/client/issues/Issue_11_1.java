package us.dontcareabout.gfTest.client.issues;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gfTest.client.ui.Toolkit;
import us.dontcareabout.gxt.client.draw.Layer;
import us.dontcareabout.gxt.client.draw.LayerContainer;
import us.dontcareabout.gxt.client.draw.LayerSprite;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_11_1 extends LayerContainer implements Issue {
	private static final int col = 3;
	private static final int row = 4;

	public Issue_11_1() {
		for (int i = 0; i < col; i++) {
			for (int j = 1; j < row + 1; j++) {
				TextButton btn = Toolkit.genButton("A█國y");
				btn.resize(200 + i * 60, j * 40);
				addLayer(btn);
			}
		}
	}

	@Override
	protected void onResize(int width, int height) {
		int y = 0;
		int x = 0;
		int count = 0;

		for (Layer layer : getLayers()) {
			LayerSprite ls = (LayerSprite)layer;
			ls.resize(ls.getWidth(), ls.getHeight());
			ls.setLX(x);
			ls.setLY(y);
			y += ls.getHeight() + 5;
			count++;

			if (count % row == 0) {
				y = 0;
				x += ls.getWidth() + 5;
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
		return "TextButton 自動調整字體大小（ TextUtil.autoResize()）";
	}
}

package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.core.client.util.Margins;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gxt.client.draw.Layer;
import us.dontcareabout.gxt.client.draw.LayerContainer;
import us.dontcareabout.gxt.client.draw.LayerSprite;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_11_2 extends LayerContainer implements Issue {
	final Margins _10_0_0_0 = new Margins(10, 0, 0, 0);
	final Margins _0_0_0_10 = new Margins(0, 0, 0, 10);

	final Margins _10_0_0_10 = new Margins(10, 0, 0, 10);
	final Margins _10_10_0_0 = new Margins(10, 10, 0, 0);

	final Margins _10_0_10_0 = new Margins(10, 0, 10, 0);
	final Margins _0_10_0_10 = new Margins(0, 10, 0, 10);

	public Issue_11_2() {
		gen(true);
		TextButton t1 = gen(true);
		t1.setMargins(_10_0_0_0);
		TextButton t5 = gen(true);
		t5.setMargins(_0_0_0_10);

		TextButton t2 = gen(true);
		t2.setMargins(_10_0_0_10);
		TextButton t4 = gen(true);
		t4.setMargins(_10_10_0_0);

		TextButton t3 = gen(true);
		t3.setMargins(_10_0_10_0);
		TextButton t6 = gen(true);
		t6.setMargins(_0_10_0_10);

//		gen(false);
	}

	@Override
	protected void onResize(int width, int height) {
		int y = 0;

		for (Layer layer : getLayers()) {
			LayerSprite ls = (LayerSprite)layer;
			ls.resize(ls.getWidth(), ls.getHeight());
			ls.setLY(y);
			y += ls.getHeight() + 5;
		}

		super.onResize(width, height);
	}

	private TextButton gen(boolean upDown) {
		TextButton btn = new TextButton("████");
		btn.resize(upDown ? 190 : 250, upDown ? 80 : 160);
		btn.setBgColor(RGB.PINK);
//		btn.setBgRadius(10);
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
		return "TextButton 的 margins 設定";
	}
}

package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.Color;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gxt.client.draw.LayerContainer;
import us.dontcareabout.gxt.client.draw.LayerSprite;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_8 extends LayerContainer implements Issue {
	final Color[] color = {RGB.GREEN, RGB.BLUE, RGB.PINK, RGB.PURPLE};
	private TextButton btn = new TextButton("clear()");

	public Issue_8() {
		final LayerSprite layer = new LayerSprite();

		for (int i = 0; i < 6; i++) {
			layer.add(gen(500 - i * 20, 500 - i * 20, color[i%color.length], 100, 100));
		}

		addLayer(layer);

		btn.setBgColor(RGB.BLACK);
		btn.setTextColor(RGB.WHITE);
		btn.setBgRadius(10);
		btn.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				layer.clear();
			}
		});
		addLayer(btn);
	}

	@Override
	protected void onResize(int width, int height) {
		btn.resize(200, 100);
		super.onResize(width, height);
	}

	private LayerSprite gen(double x, double y, Color c, int w, int h) {
		LayerSprite result = new LayerSprite();
		result.setBgColor(c);
		result.resize(w, h);
		result.setLX(x);
		result.setLY(y);
		return result;
	}

	@Override
	public int number() {
		return 8;
	}

	@Override
	public String[] tags() {
		return new String[]{"GF-Draw", "LayerSprite"};
	}

	@Override
	public String topic() {
		return "Layer.clear()";
	}
}

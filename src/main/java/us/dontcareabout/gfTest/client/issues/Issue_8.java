package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.Color;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gxt.client.draw.Cursor;
import us.dontcareabout.gxt.client.draw.LayerContainer;
import us.dontcareabout.gxt.client.draw.LayerSprite;

public class Issue_8 extends LayerContainer implements Issue {
	final Color[] color = {RGB.GREEN, RGB.BLUE, RGB.PINK, RGB.PURPLE};

	public Issue_8() {
		final LayerSprite layer = new LayerSprite();

		for (int i = 0; i < 6; i++) {
			layer.add(gen(500 - i * 20, 500 - i * 20, color[i%color.length], 100, 100));
		}

		addLayer(layer);

		final LayerSprite btn = gen(0, 0, RGB.RED, 200, 100);
		btn.setCursor(Cursor.POINTER);	//FIXME 沒有作用？ WTF？
		btn.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				layer.clear();
			}
		});
		addLayer(btn);
	}

	private LayerSprite gen(double x, double y, Color c, int w, int h) {
		LayerSprite result = new LayerSprite();
		result.setBgColor(c);
		result.setWidth(w);
		result.setHeight(h);
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

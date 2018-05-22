package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gfTest.client.ui.Toolkit;
import us.dontcareabout.gxt.client.draw.LRectangleSprite;
import us.dontcareabout.gxt.client.draw.LayerContainer;
import us.dontcareabout.gxt.client.draw.LayerSprite;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_8 extends LayerContainer implements Issue {
	private TextButton btn = Toolkit.genButton("clear()");
	private LayerSprite layer = new LayerSprite();

	public Issue_8() {
		for (int i = 0; i < 6; i++) {
			LRectangleSprite newOne = Toolkit.genRectangle();
			newOne.setLX(500 - i * 20);
			newOne.setLY(500 - i * 20);
			layer.add(newOne);
		}

		addLayer(layer);
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

package us.dontcareabout.gfTest.client.issues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gfTest.client.ui.Toolkit;
import us.dontcareabout.gxt.client.draw.LayerContainer;
import us.dontcareabout.gxt.client.draw.component.TextButton;
import us.dontcareabout.gxt.client.draw.layout.HorizontalLayoutLayer;
import us.dontcareabout.gxt.client.draw.layout.VerticalLayoutLayer;
import us.dontcareabout.gxt.client.util.ColorUtil;

public class Issue_55 extends LayerContainer implements Issue {
	private static final int width = 6;
	private static final int height = 9;

	private VerticalLayoutLayer root = new VerticalLayoutLayer();
	private HorizontalLayoutLayer btnLayer = new HorizontalLayoutLayer();
	private VerticalLayoutLayer rows = new VerticalLayoutLayer();

	private boolean isRandom;

	public Issue_55() {
		addLayer(root);
		TextButton sequence = Toolkit.genButton("Sequence");
		sequence.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				if (!isRandom) { return; }
				isRandom = false;
				build();
			}
		});
		TextButton random = Toolkit.genButton("random");
		random.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				isRandom = true;
				build();
			}
		});
		btnLayer.addChild(sequence, 100);
		btnLayer.addChild(random, 100);
		btnLayer.setGap(20);
		btnLayer.setMargins(5);

		root.addChild(btnLayer, 50);
		root.addChild(rows, 1);
		build();
	}

	private void build() {
		List<Integer> order = genSequence();

		if (isRandom) {
			Collections.shuffle(order);
		}

		rows.clear();

		for (int i = 0; i < height; i++) {
			HorizontalLayoutLayer hll = new HorizontalLayoutLayer();
			rows.addChild(hll, 1.0 / height);

			for (int i2 = 0; i2 < width; i2++) {
				int v = order.get(i * width + i2);
				RGB color = ColorUtil.differential(v);
				TextButton tb = new TextButton("" + v);
				tb.setBgColor(color);
				tb.setTextColor(ColorUtil.blackOrWhite(color));
				hll.addChild(tb, 1.0 / width);;
			}
		}

		root.redeploy();
		adjustMember(getOffsetWidth(), getOffsetHeight());
	}

	@Override
	protected void adjustMember(int width, int height) {
		root.resize(width, height);
	}

	@Override
	public int number() {
		return 55;
	}

	@Override
	public String[] tags() {
		return new String[]{"ColorUtil"};
	}

	@Override
	public String topic() {
		return "differentColor() / blackOrWhite()";
	}

	private static List<Integer> genSequence() {
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < height; i++) {
			for (int i2 = 0; i2 < width; i2++) {
				result.add(i * width + i2);
			}
		}

		return result;
	}
}

package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gfTest.client.ui.Toolkit;
import us.dontcareabout.gxt.client.draw.LRectangleSprite;
import us.dontcareabout.gxt.client.draw.LayerSprite;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_21 extends LayerSprite implements Issue {
	private int offset = 0;

	private TextButton btn = new TextButton("增加 sprite");

	public Issue_21() {
		btn.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				add();
			}
		});
		btn.setLX(80);
		btn.setLY(10);
		btn.setBgColor(RGB.BLACK);
		btn.setTextColor(RGB.WHITE);
		btn.setBgRadius(10);
		add(btn);
	}

	@Override
	protected void adjustMember() {
		btn.resize(100, 70);
	}

	public void add() {
		LRectangleSprite newOne = Toolkit.genRectangle();
		newOne.setLX(10 + offset);
		newOne.setLY(100 + offset);
		add(newOne);
		redeploy();
		offset += 10;
	}

	public void addAndRedraw() {
		add();
		redraw();
	}

	@Override
	public int number() {
		return 21;
	}

	@Override
	public String[] tags() {
		return new String[]{"GF-Draw", "LayerSprite"};
	}

	@Override
	public String topic() {
		return "LayerSprite.redeploy()";
	}
}

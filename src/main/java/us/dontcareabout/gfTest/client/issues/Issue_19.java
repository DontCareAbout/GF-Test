package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gxt.client.draw.LayerSprite;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_19 extends VerticalLayoutContainer implements Issue {
	public Issue_19() {
		add(new Foo(), new VerticalLayoutData(-1, -1));
		setScrollMode(ScrollMode.AUTO);
	}

	@Override
	public int number() {
		return 19;
	}

	@Override
	public String[] tags() {
		return new String[]{"GF-Draw", "LayerSprite"};
	}

	@Override
	public String topic() {
		return "LayerSprite resize() 可影響 asWidget() 的大小";
	}

	private class Foo extends LayerSprite {
		TextButton bigger = genButton(true);
		TextButton smaller = genButton(false);

		Foo() {
			setBgColor(RGB.LIGHTGRAY);
			bigger.setLX(20);
			bigger.setLY(20);
			add(bigger);

			smaller.setLX(140);
			smaller.setLY(20);
			add(smaller);
		}

		@Override
		protected void adjustMember() {
			bigger.resize(100, 50);
			smaller.resize(100, 50);
		}

		private TextButton genButton(boolean isBigger) {
			final int size = isBigger ? 100 : -100;
			TextButton result = new TextButton(isBigger ? "變大" : "變小");
			result.setBgColor(isBigger ? RGB.YELLOW : RGB.PINK);
			result.setBgRadius(10);
			result.addSpriteSelectionHandler(new SpriteSelectionHandler() {
				@Override
				public void onSpriteSelect(SpriteSelectionEvent event) {
					resize(getWidth() + size, getHeight() + size);
				}
			});
			return result;
		}
	}
}

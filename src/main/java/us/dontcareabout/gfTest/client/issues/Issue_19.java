package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gfTest.client.ui.Toolkit;
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
		TextButton bigger = Toolkit.genButton("變大", RGB.BLACK, RGB.YELLOW);
		TextButton smaller = Toolkit.genButton("變小", RGB.BLACK, RGB.PINK);

		Foo() {
			setBgColor(RGB.LIGHTGRAY);
			bigger.setLX(20);
			bigger.setLY(20);
			bigger.addSpriteSelectionHandler(new Handler(true));
			add(bigger);

			smaller.setLX(140);
			smaller.setLY(20);
			smaller.addSpriteSelectionHandler(new Handler(false));
			add(smaller);
		}

		@Override
		protected void adjustMember() {
			bigger.resize(100, 50);
			smaller.resize(100, 50);
		}

		private class Handler implements SpriteSelectionHandler {
			final int size;

			Handler(boolean isBigger) {
				size = isBigger ? 100 : -100;
			}

			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				resize(getWidth() + size, getHeight() + size);
			}
		}
	}
}

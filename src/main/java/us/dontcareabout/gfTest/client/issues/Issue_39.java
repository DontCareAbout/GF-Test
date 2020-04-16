package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gfTest.client.ui.Toolkit;
import us.dontcareabout.gxt.client.draw.LayerContainer;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_39 extends LayerContainer implements Issue {
	private static final String[] text = {"按我", "ごめんなさい", "Able was I ere I saw Elba."};

	private int counter = 0;
	private TextButton once = Toolkit.genButton(text[counter], RGB.WHITE, RGB.RED);

	public Issue_39() {
		once.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				counter++;
				once.setText(text[counter % text.length]);
			}
		});
		addLayer(once);
	}

	@Override
	protected void adjustMember(int width, int height) {
		once.setLX(10);
		once.setLY(10);
		once.resize(250, 60);
	}

	@Override
	public int number() {
		return 39;
	}

	@Override
	public String[] tags() {
		return new String[]{"GF-Draw", "TextButton"};
	}

	@Override
	public String topic() {
		return "TextButton.setText() 要能重新讓字串置中";
	}
}

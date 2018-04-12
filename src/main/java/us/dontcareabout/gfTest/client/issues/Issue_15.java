package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.RGB;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_15 extends TextButton implements Issue {
	public Issue_15() {
		super("整個版面都是 TextButton... 囧>");
		setBgRadius(20);
		setBgColor(RGB.LIGHTGRAY);
	}

	@Override
	public int number() {
		return 15;
	}

	@Override
	public String[] tags() {
		return new String[]{"GF-Draw", "LayerSprite"};
	}

	@Override
	public String topic() {
		return "LayerSprite.asWidget()";
	}

}

package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.RGB;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gxt.client.draw.LTextSprite;
import us.dontcareabout.gxt.client.draw.LayerSprite;

public class Issue_30 extends LayerSprite implements Issue {
	public Issue_30() {
		LTextSprite text = new LTextSprite();
		text.setText("看得到就是正常啦～ \\囧/");
		text.setFontSize(30);
		text.setFill(RGB.RED);
		text.setLX(10);
		text.setLY(10);
		add(text);

		redraw();
	}

	@Override
	public int number() {
		return 30;
	}

	@Override
	public String[] tags() {
		return new String[]{"GF-Draw", "Layer"};
	}

	@Override
	public String topic() {
		return "還沒有加到 DrawComponent 就呼叫 Layer.redraw() 的狀況，"
				+ "修正前會炸 NPE，而導致整個畫面掛掉。";
	}
}

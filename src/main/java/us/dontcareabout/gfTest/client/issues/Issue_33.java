package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.DrawComponent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite;

import us.dontcareabout.gfTest.client.Issue;

public class Issue_33 extends DrawComponent implements Issue {
	private TextSprite text = new TextSprite("點我就消失不再出現 Orz");

	public Issue_33() {
		text.setFontSize(30);
		addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				removeAndAdd();
			}
		});
		add();
	}

	private void add() {
		addSprite(text);
		redrawSurfaceForced();	//為了確保萬一加的，不加應該也無所謂
	}

	@Override
	protected void onResize(int width, int height) {
		text.setX(10);
		text.setY(10);
		super.onResize(width, height);
	}

	private void removeAndAdd() {
		remove(text);
		add();
	}

	@Override
	public int number() {
		return 33;
	}

	@Override
	public String[] tags() {
		return new String[]{"GXT", "DrawComponent"};
	}

	@Override
	public String topic() {
		return "同一個 Sprite instance 移除後再加入 DrawComponent 會無法顯示";
	}
}

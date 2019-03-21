package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gxt.client.draw.LTextSprite;
import us.dontcareabout.gxt.client.draw.LayerSprite;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_35 extends LayerSprite implements Issue {
	private LayerSprite child = new LayerSprite();
	private TextButton grandchild = new TextButton("第二層 Layer");
	private LTextSprite text = new LTextSprite("第一層 Layer");

	private TextButton hiddenChild = new TextButton("第一層變動");
	private TextButton hiddenGrandchild = new TextButton("第二層變動");

	public Issue_35() {
		text.setFontSize(25);
		child.add(text);

		grandchild.setBgColor(RGB.RED);
		grandchild.setTextColor(RGB.WHITE);
		child.add(grandchild);

		child.setBgColor(RGB.YELLOW);
		add(child);

		hiddenChild.setBgColor(RGB.BLACK);
		hiddenChild.setTextColor(RGB.WHITE);
		hiddenChild.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				child.setHidden(!child.isHidden());
			}
		});

		hiddenGrandchild.setBgColor(RGB.BLACK);
		hiddenGrandchild.setTextColor(RGB.WHITE);
		hiddenGrandchild.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				grandchild.setHidden(!grandchild.isHidden());
			}
		});
		add(hiddenChild);
		add(hiddenGrandchild);
	}

	@Override
	protected void adjustMember() {
		hiddenChild.setLX(20);
		hiddenChild.setLY(10);
		hiddenChild.resize(140, 40);

		hiddenGrandchild.setLX(180);
		hiddenGrandchild.setLY(10);
		hiddenGrandchild.resize(140, 40);

		child.setLX(00);
		child.setLY(100);
		child.resize(400, 400);

		text.setLX(10);
		text.setLY(10);

		grandchild.setLX(150);
		grandchild.setLY(150);
		grandchild.resize(200, 200);
	}


	@Override
	public int number() {
		return 35;
	}

	@Override
	public String[] tags() {
		return new String[]{"GF-Draw", "Layer", "LayerSprite"};
	}

	@Override
	public String topic() {
		return "Layer 與 LayerSprite 的 hidden 操作";
	}

}

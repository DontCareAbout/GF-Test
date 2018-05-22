package us.dontcareabout.gfTest.client.issues;

import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gfTest.client.ui.Toolkit;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_25 extends VerticalLayoutContainer implements Issue {
	private final HorizontalLayoutData hld = new HorizontalLayoutData(0.5, 1, new Margins(5));
	private Issue_21 issue_21 = new Issue_21();
	public Issue_25() {
		add(issue_21, new VerticalLayoutData(1, 1));

		HorizontalLayoutContainer hlc = new HorizontalLayoutContainer();

		TextButton add = Toolkit.genButton("add (X)");
		add.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				issue_21.add();
			}
		});
		hlc.add(add, hld);

		TextButton redraw = Toolkit.genButton("add & redraw");
		redraw.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				issue_21.addAndRedraw();
			}
		});
		hlc.add(redraw, hld);

		add(hlc, new VerticalLayoutData(1, 100));
	}

	@Override
	public int number() {
		return 25;
	}

	@Override
	public String[] tags() {
		return new String[]{"GF-Draw", "Layer"};
	}

	@Override
	public String topic() {
		return "LayerSprite.redraw()。"
			+ "下方按鈕的「add (X)」並不會有任何反應，"
			+ "「add & redraw」才會正常顯示（含之前沒反應的部份）";
	}
}

package us.dontcareabout.gfTest.client.issues;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gxt.client.draw.LayerContainer;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public class Issue_37 extends LayerContainer implements Issue {
	private TextButton once = genButton("onResize()");
	private TextButton onceAndDeferred = genButton("onResize()（deferred）");
	private TextButton twice = genButton("兩次 onResize()");
	private TextButton twiceAndDeffered = genButton("兩次（deferred）");
	private TextButton foo = genButton("我要變大啦 >///<");

	private int counter;

	public Issue_37() {
		once.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				adjust();
				restoreSize();
			}
		});
		addLayer(once);

		onceAndDeferred.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				adjust();
				Scheduler.get().scheduleDeferred(new ScheduledCommand() {
					@Override
					public void execute() {
						restoreSize();
					}
				});
			}
		});
		addLayer(onceAndDeferred);

		twice.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				adjust();
				onResize(1, 1);
				restoreSize();
			}
		});
		addLayer(twice);

		twiceAndDeffered.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				adjust();
				onResize(1, 1);
				Scheduler.get().scheduleDeferred(new ScheduledCommand() {
					@Override
					public void execute() {
						restoreSize();
					}
				});
			}
		});
		addLayer(twiceAndDeffered);

		addLayer(foo);
	}

	boolean deferred;

	@Override
	protected void adjustMember(int width, int height) {
		once.setLX(10);
		once.setLY(10);
		once.resize(120, 40);

		twice.setLX(140);
		twice.setLY(10);
		twice.resize(180, 40);

		onceAndDeferred.setLX(330);
		onceAndDeferred.setLY(10);
		onceAndDeferred.resize(180, 40);

		twiceAndDeffered.setLX(520);
		twiceAndDeffered.setLY(10);
		twiceAndDeffered.resize(180, 40);

		foo.setLX(20);
		foo.setLY(60);
		foo.resize(100 + counter * 30, 50 + counter * 10);
	}

	private void adjust() {
		foo.undeploy();
		foo = genButton("第 " + (++counter) + " 次");
		addLayer(foo);
	}

	private void restoreSize() {
		onResize(getOffsetWidth(), getOffsetHeight());
	}

	private static TextButton genButton(String text) {
		TextButton result = new TextButton(text);
		result.setBgColor(RGB.RED);
		result.setTextColor(RGB.WHITE);
		return result;
	}

	@Override
	public int number() {
		return 65535;
	}

	@Override
	public String[] tags() {
		return new String[]{"GF-Draw", "TextButton", "TextUtil"};
	}

	@Override
	public String topic() {
		return "TextUtil.autoResize() bug。\n"
				+ "修正前只有 twiceAndDeffered 才能正常顯示，"
				+ "正確應該是 once 就能正常顯示";
	}
}

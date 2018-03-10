package us.dontcareabout.gfTest.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.container.Viewport;

import us.dontcareabout.gfTest.client.ui.MainView;
import us.dontcareabout.gwt.client.GFEP;
import us.dontcareabout.gwt.client.iCanUse.Feature;

public class Tester extends GFEP {
	public Tester() {
		needFeature(Feature.Canvas);
	}

	@Override
	protected String version() { return "0.0.1"; }

	@Override
	protected String defaultLocale() { return "zh_TW"; }


	@Override
	protected void featureFail() {
		Window.alert("這個瀏覽器我不尬意，不給用..... \\囧/");
	}

	@Override
	protected void start() {
		Viewport vp = new Viewport();
		vp.add(new MainView());
		RootPanel.get().add(vp);
	}
}

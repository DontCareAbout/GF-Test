package us.dontcareabout.gfTest.client;

import com.google.gwt.user.client.Window;

import us.dontcareabout.fontMetrics.client.Font;
import us.dontcareabout.fontMetrics.client.FontMetrics;
import us.dontcareabout.fontMetrics.client.MetricsField;
import us.dontcareabout.gwt.client.Console;
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
		FontMetrics fm = FontMetrics.get(new Font());
		Console.log(fm.getValue(MetricsField.bottom));
		if (!TIMES_200.equals(fm)) {
			Window.alert(diff(TIMES_200, fm));
		} else {
			Window.alert("\\囧/");
		}
	}

	private static final FontMetrics TIMES_200 = new FontMetrics();
	static {
		TIMES_200.setValue(MetricsField.bottom, 0.5);
		TIMES_200.setValue(MetricsField.capHeight, -0.68);
		TIMES_200.setValue(MetricsField.baseline, 0);
		TIMES_200.setValue(MetricsField.xHeight, -0.45);
		TIMES_200.setValue(MetricsField.descent, 0.21);
		TIMES_200.setValue(MetricsField.ascent, -0.695);
		TIMES_200.setValue(MetricsField.tittle, -0.695);
	}

	private static String diff(FontMetrics a, FontMetrics b) {
		StringBuffer result = new StringBuffer();

		for (MetricsField type : MetricsField.values()) {
			if (a.getValue(type) != b.getValue(type)) {
				result.append(type + " : " + a.getValue(type) + " != " + b.getValue(type));
			}
		}

		return result.toString();
	}
}

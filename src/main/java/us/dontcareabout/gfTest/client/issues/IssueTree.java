package us.dontcareabout.gfTest.client.issues;

import java.util.Arrays;

import com.google.common.base.Preconditions;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.tree.Tree;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gxt.client.model.GetValueProvider;

public class IssueTree extends Tree<Issue, String> {
	private static final ValueProvider<Issue, String> VP = new GetValueProvider<Issue, String>() {
		@Override
		public String getValue(Issue object) {
			if (object instanceof Widget) {
				return object.getClass().getSimpleName().replace('_', '-');
			} else {
				return "Issue-" + object.number();
			}
		}
	};

	public IssueTree() {
		super(makeStore(), VP);
		buildIssue();
	}

	private void buildIssue() {
		addIssue(new Issue_8());
		addIssues(new Issue_11_1(), new Issue_11_2(), new Issue_11_3());
		addIssue(new Issue_15());
		addIssue(new Issue_19());
		addIssue(new Issue_21());
		addIssue(new Issue_25());
	}

	private void addIssue(Issue issue) {
		store.add(issue);
	}

	private void addIssues(Issue... issues) {
		Preconditions.checkArgument(issues.length > 0);

		IssueSet parent = new IssueSet(issues[0].number());
		store.add(parent);
		store.add(parent, Arrays.asList(issues));
	}

	private class IssueSet implements Issue {
		private int number;

		IssueSet(int number) {
			this.number = number;
		}

		@Override
		public int number() {
			return number;
		}

		@Override
		public String[] tags() { return null; }

		@Override
		public String topic() { return null; }
	}

	private static TreeStore<Issue> makeStore() {
		return new TreeStore<>(
			new ModelKeyProvider<Issue>() {

			@Override
			public String getKey(Issue item) {
				return item instanceof Widget ?
					item.getClass().getName() : String.valueOf(item.number());
			}
		});
	}
}

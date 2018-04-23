package us.dontcareabout.gfTest.client.ui;

import java.util.Arrays;

import com.google.common.base.Preconditions;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.tree.Tree;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gfTest.client.issues.Issue_11_1;
import us.dontcareabout.gfTest.client.issues.Issue_11_2;
import us.dontcareabout.gfTest.client.issues.Issue_11_3;
import us.dontcareabout.gfTest.client.issues.Issue_15;
import us.dontcareabout.gfTest.client.issues.Issue_19;
import us.dontcareabout.gfTest.client.issues.Issue_8;
import us.dontcareabout.gxt.client.model.GetValueProvider;

public class MainView extends BorderLayoutContainer {
	private TreeStore<Issue> store;
	private Tree<Issue, String> tree;

	public MainView() {
		buildTree();
		buildIssue();
		this.setWestWidget(tree, new BorderLayoutData(200));
	}

	private void buildIssue() {
		addIssue(new Issue_8());
		addIssues(new Issue_11_1(), new Issue_11_2(), new Issue_11_3());
		addIssue(new Issue_15());
		addIssue(new Issue_19());
	}

	private void buildTree() {
		store = new TreeStore<>(
			new ModelKeyProvider<Issue>() {

			@Override
			public String getKey(Issue item) {
				return item instanceof Widget ?
					item.getClass().getName() : String.valueOf(item.number());
			}
		});
		tree = new Tree<>(
			store,
			new GetValueProvider<Issue, String>() {
				@Override
				public String getValue(Issue object) {
					if (object instanceof Widget) {
						return object.getClass().getSimpleName().replace('_', '-');
					} else {
						return "Issue-" + object.number();
					}
				}
			}
		);
		tree.getSelectionModel().addSelectionHandler(new SelectionHandler<Issue>() {
			@Override
			public void onSelection(SelectionEvent<Issue> event) {
				Issue issue = event.getSelectedItem();

				if (issue instanceof IsWidget) {
					setCenterWidget(((IsWidget) issue).asWidget());
					MainView.this.forceLayout();
				}
			}
		});
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
}

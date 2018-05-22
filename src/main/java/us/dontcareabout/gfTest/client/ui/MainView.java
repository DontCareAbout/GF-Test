package us.dontcareabout.gfTest.client.ui;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;

import us.dontcareabout.gfTest.client.Issue;
import us.dontcareabout.gfTest.client.issues.IssueTree;

public class MainView extends BorderLayoutContainer {
	private IssueTree tree = new IssueTree();

	public MainView() {
		buildTree();
		this.setWestWidget(tree, new BorderLayoutData(200));
	}

	private void buildTree() {
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


}

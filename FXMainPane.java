import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
public class FXMainPane extends VBox {

	//Task #2:

	private Button helloButton, howdyButton, chineseButton, clearButton, exitButton;
	private Label feedbackLabel;
	private TextField feedbackField;
	private HBox buttonBox, feedbackBox;
	
	//Task #4:

	private DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//Task #2:
		task2();
		
		//Task #4:
		task4();
		
		//Task #3:
		task3();
		
	}

	private void task2() {
		helloButton = new Button("Hello");
		howdyButton = new Button("Howdy");
		chineseButton = new Button("Chinese");
		clearButton = new Button("Clear");
		exitButton = new Button("Exit");
		feedbackLabel = new Label("Feedback:");
		feedbackField = new TextField();
		buttonBox = new HBox();
		feedbackBox = new HBox();
	}

	private void task3() {
		feedbackBox.getChildren().addAll(feedbackLabel, feedbackField);
		buttonBox.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);
		this.getChildren().addAll(buttonBox, feedbackBox);
	}

	private void task4() {
		dataManager = new DataManager();

		ButtonHandler handler = new ButtonHandler();
		helloButton.setOnAction(handler);
		howdyButton.setOnAction(handler);
		chineseButton.setOnAction(handler);
		clearButton.setOnAction(handler);
		exitButton.setOnAction(handler);

		Insets inset = new Insets(10);
		HBox.setMargin(helloButton, inset);
		HBox.setMargin(howdyButton, inset);
		HBox.setMargin(chineseButton, inset);
		HBox.setMargin(clearButton, inset);
		HBox.setMargin(exitButton, inset);
		HBox.setMargin(feedbackLabel, inset);
		HBox.setMargin(feedbackField, inset);
		buttonBox.setAlignment(Pos.CENTER);
		feedbackBox.setAlignment(Pos.CENTER);
	}
	
	//Task #4:
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			Object target = event.getTarget();

			if (target == helloButton) {
				feedbackField.setText(dataManager.getHello());
			} else if (target == howdyButton) {
				feedbackField.setText(dataManager.getHowdy());
			} else if (target == chineseButton) {
				feedbackField.setText(dataManager.getChinese());
			} else if (target == clearButton) {
				feedbackField.setText("");
			} else if (target == exitButton) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
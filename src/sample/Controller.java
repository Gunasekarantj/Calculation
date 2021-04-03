package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author 10670754
 */
public class Controller extends Application {

    @Override
    public void start(Stage s) throws NoSuchAlgorithmException {
        final Random rand = SecureRandom.getInstanceStrong();
        s.setTitle("Mind calculation trainer by gunasekaran");

        GridPane root = new GridPane();
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            root.addColumn(0, new Label(i + 1 + ")First Number :  "));
            int firstNumber = rand.nextInt(100000);
            TextField tf1 = new TextField(String.valueOf(firstNumber));
            tf1.setEditable(false);
            root.addColumn(1, tf1);
            root.addColumn(2, new Label(" Second Number :  "));
            int secondNumber = rand.nextInt(100000);
            TextField tf2 = new TextField(String.valueOf(secondNumber));
            tf2.setEditable(false);
            root.addColumn(3, tf2);
            root.addColumn(4, new Label("  Result :  "));
            TextField resultTf = new TextField();
            root.addColumn(5, resultTf);
            resultMap.put(i, firstNumber + secondNumber);
            Label label = new Label();
            Button button = new Button(" Calculate");
            String correct = "  WRONG";
            if (resultTf.getText().equals(String.valueOf(firstNumber + secondNumber))) {
                correct = " CORRECT";
            }
            String finalCorrect = correct;
            button.setOnAction(e ->
                    label.setText(" The answer is" + finalCorrect)
            );
            root.addColumn(6, button);
            root.addColumn(7, label);
        }

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(root);

        Scene scene = new Scene(borderPane, 5000, 500);
        s.setTitle("Mind Addition Game by gunasekaran");
        s.setScene(scene);
        s.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
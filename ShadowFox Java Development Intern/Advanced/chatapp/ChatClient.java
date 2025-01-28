package chatapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import java.net.*;

public class ChatClient extends Application {
    private String username;
    private PrintWriter out;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chat Application");

        VBox root = new VBox(10);
        root.setPrefSize(400, 400);

        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);

        TextField inputField = new TextField();
        Button sendButton = new Button("Send");

        HBox inputBox = new HBox(5, inputField, sendButton);
        inputBox.setHgrow(inputField, Priority.ALWAYS);

        root.getChildren().addAll(chatArea, inputBox);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Connect to the server
        try {
            Socket socket = new Socket("localhost", 12345);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Username input
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Username");
            dialog.setHeaderText("Enter your username:");
            username = dialog.showAndWait().orElse("User");
            out.println(username);

            // Thread to listen for messages
            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        chatArea.appendText(message + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Send button action
            sendButton.setOnAction(e -> sendMessage(inputField));

            // Enter key to send message
            inputField.setOnAction(e -> sendMessage(inputField));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(TextField inputField) {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            out.println(message);
            inputField.clear();
        }
    }
}
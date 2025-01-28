package inventorySystem;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventoryGUI extends Application {
    private InventoryManager inventoryManager = new InventoryManager();
    private ObservableList<InventoryItem> inventoryObservableList = FXCollections.observableArrayList();
    private TableView<InventoryItem> tableView = new TableView<>();

    @Override
    public void start(Stage primaryStage) {
        TableColumn<InventoryItem, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getId()));

        TableColumn<InventoryItem, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));

        TableColumn<InventoryItem, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getQuantity()));

        TableColumn<InventoryItem, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getPrice()));

        tableView.getColumns().addAll(idColumn, nameColumn, quantityColumn, priceColumn);
        tableView.setItems(inventoryObservableList);
        
        TextField idField = new TextField();
        idField.setPromptText("Item ID");
        TextField nameField = new TextField();
        nameField.setPromptText("Item Name");
        TextField quantityField = new TextField();
        quantityField.setPromptText("Quantity");
        TextField priceField = new TextField();
        priceField.setPromptText("Price");


        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");

        addButton.setOnAction(e -> {
            try {
                if (idField.getText().isEmpty() || nameField.getText().isEmpty()
                        || quantityField.getText().isEmpty() || priceField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Error", "Please fill in all fields.");
                    return;
                }

                String id = idField.getText();
                String name = nameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());

                InventoryItem item = new InventoryItem(id, name, quantity, price);
                inventoryManager.addItem(item);
                inventoryObservableList.add(item);

                clearFields(idField, nameField, quantityField, priceField);
                tableView.getSelectionModel().clearSelection();
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Quantity and Price must be numeric.");
            }
        });

        updateButton.setOnAction(e -> {
            try {
                if (idField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Error", "Item ID is required for updating.");
                    return;
                }

                String id = idField.getText();
                String name = nameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());

                inventoryManager.updateItem(id, name, quantity, price);
                refreshTable();
                clearFields(idField, nameField, quantityField, priceField);
                tableView.getSelectionModel().clearSelection();
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Quantity and Price must be numeric.");
            }
        });

        deleteButton.setOnAction(e -> {
            String id = idField.getText();
            if (id.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Item ID is required for deletion.");
                return;
            }

            inventoryManager.deleteItem(id);
            refreshTable();
            clearFields(idField, nameField, quantityField, priceField);
            tableView.getSelectionModel().clearSelection();
        });


        HBox inputFields = new HBox(10, idField, nameField, quantityField, priceField);
        HBox buttons = new HBox(10, addButton, updateButton, deleteButton);
        VBox layout = new VBox(10, tableView, inputFields, buttons);

     
        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void refreshTable() {
        inventoryObservableList.setAll(inventoryManager.getItems());
    }

    private void clearFields(TextField idField, TextField nameField, TextField quantityField, TextField priceField) {
        idField.clear();
        nameField.clear();
        quantityField.clear();
        priceField.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

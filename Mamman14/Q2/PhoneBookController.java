/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 19/1/2023
 *  Class Name: PhoneBookController
 */
package com.example.mamman14q2;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.Map;

public class PhoneBookController {

    @FXML
    private TableView<Map.Entry<String,String>> table;
    @FXML
    private TableColumn<Map.Entry<String,String>,String> nameColumn;
    @FXML
    private TableColumn<Map.Entry<String,String>,String> phoneColumn;

    @FXML
    private Button searchButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button addButton;

    @FXML
    private TextField numberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField searchNameField;
    @FXML
    private Label errorLabel;

    private PhoneBook phoneBook; //phone book instance

    public void initialize()
    {
        phoneBook = new PhoneBook(); //initialize phonebook instance

        //stop columns from being order-able with mouse
        nameColumn.reorderableProperty().set(false);
        phoneColumn.reorderableProperty().set(false);
        table.setFocusTraversable(false);
        table.setPlaceholder(new Label("No entries found")); //set default message

        //tie column to table key and value
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKey()));
        phoneColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getValue()));
    }

    /**
     * upon add button click, if nameField and numberField both arent empty, attempt to add strings to table
     * @param event add button clicked
     */
    @FXML
    void addButtonPressed(ActionEvent event) {
        if(nameField.getText().isEmpty() || numberField.getText().isEmpty())
        {}
        else {
            try {
                phoneBook.add(nameField.getText(), numberField.getText());
                //reset text fields and update UI with new table entry
                nameField.setText("");
                numberField.setText("");
                updateBook();
            }catch(IllegalArgumentException e) {
                errorLabel.setText(e.getMessage()); //display error msg
            }
        }
    }

    /**
     * upon search button click, check searchNameField is not empty and look for name in table and update UI accordingly
     * @param event search button clicked
     */
    @FXML
    void searchButtonPressed(ActionEvent event) {
        if(!searchNameField.getText().isEmpty())
        {
            table.getItems().setAll(phoneBook.search(searchNameField.getText()).entrySet()); //sets UI to result of search
            searchNameField.setText(""); //reset name field
        }
        else {
            updateBook(); //if searchNameField is empty display book
        }
    }

    /**
     * upon update button click check if name and number boxes are not empty and in the case they are not attempt to
     * update the name's phone number value
     * @param event update button clicked
     */
    @FXML
    void updateButtonPressed(ActionEvent event) {
        if(nameField.getText().isEmpty() || numberField.getText().isEmpty())
        {}
        else {
            try
            {
                phoneBook.update(nameField.getText(),numberField.getText());
                //reset and update ui
                numberField.setText("");
                nameField.setText("");
                updateBook();
            }catch (IllegalArgumentException e)
            {
                errorLabel.setText(e.getMessage()); // display error
            }
        }
    }

    /**
     * Updates UI and resets error label
     */
    private void updateBook()
    {
        table.getItems().clear(); //empty list
        table.getItems().setAll(phoneBook.getTable().entrySet()); //fill table with phoneBook's entries
        errorLabel.setText(""); //reset error label
    }
}

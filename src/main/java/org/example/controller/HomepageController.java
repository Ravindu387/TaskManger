package org.example.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.example.db.DBConnection;
import org.example.model.Task;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class HomepageController{

    public DatePicker dateComplete;
    public TableColumn colDescription;
    public TableView tblTask;
    public TableColumn colDate;
    public ListView listView;
    public ListView listViewCompleted;
    public ListView listViewDate;
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;

    @FXML
    private Pane pane5;

    @FXML
    private Pane pane6;


    public JFXCheckBox txtCheakBox;
    @FXML
    private JFXCheckBox txtCheakBox1;

    @FXML
    private JFXCheckBox txtCheakBox2;

    @FXML
    private JFXCheckBox txtCheakBox3;

    @FXML
    private JFXCheckBox txtCheakBox4;

    @FXML
    private JFXCheckBox txtCheakBox5;

    @FXML
    private JFXCheckBox txtCheakBox6;

    @FXML
    private JFXTextField txtAddTask;

    @FXML
    private AnchorPane txtArea;

    public int i=0;

    @FXML
    void btnOnActionAdd(ActionEvent event) {
       listView.getItems().add(txtAddTask.getText());
       listViewDate.getItems().add(Date.valueOf(dateComplete.getValue()));
        LocalDate date=dateComplete.getValue();


        i += 1;
//        String taskTitle = txtAddTask.getText();
//        String taskDescription = txtAddTask.getText();
//        Date completionDate = Date.valueOf(dateComplete.getValue());
//
//        String SQL = "INSERT INTO tasks (task_title, task_description, completion_date) VALUES (?, ?, ?)";
//
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskManger", "root", "1234");
//             PreparedStatement psTm = connection.prepareStatement(SQL)) {
//
//            psTm.setString(1, taskTitle);
//            psTm.setString(2, taskDescription);
//            psTm.setDate(3, completionDate);
//
//            int rowsAffected = psTm.executeUpdate();
//            if (rowsAffected > 0) {
//                System.out.println("Task added successfully.");
//                // Optionally, clear input fields or reload the table view here
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }

    public void chkOnActionAdd(ActionEvent actionEvent) {
        if (txtCheakBox.isSelected()) {
            txtCheakBox.setDisable(true);
            txtCheakBox.setVisible(false);

            String taskTitle = txtAddTask.getText();
            String taskDescription = txtAddTask.getText();
            Date completionDate = Date.valueOf(dateComplete.getValue());

            String SQL = "INSERT INTO tasks (task_title, task_description, completion_date) VALUES (?, ?, ?)";

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskManger", "root", "1234");
                 PreparedStatement psTm = connection.prepareStatement(SQL)) {

                psTm.setString(1, taskTitle);
                psTm.setString(2, taskDescription);
                psTm.setDate(3, completionDate);

                int rowsAffected = psTm.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Task added successfully.");
                    // Optionally, clear input fields or reload the table view here
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    public void chkOnActionAdd1(ActionEvent actionEvent) {
        if (txtCheakBox1.isSelected()==true){
            txtCheakBox1.setDisable(true);
        }
    }

    public void chkOnActionAdd2(ActionEvent actionEvent) {
        if (txtCheakBox2.isSelected()==true){
            txtCheakBox2.setDisable(true);
        }
    }

    public void chkOnActionAdd3(ActionEvent actionEvent) {
        if (txtCheakBox3.isSelected()==true){
            txtCheakBox3.setDisable(true);
        }
    }

    public void chkOnActionAdd4(ActionEvent actionEvent) {
        if (txtCheakBox4.isSelected()==true){
            txtCheakBox4.setDisable(true);
        }
    }

    public void chkOnActionAdd5(ActionEvent actionEvent) {
        if (txtCheakBox5.isSelected()==true){
            txtCheakBox5.setDisable(true);
        }
    }

    public void chkOnActionAdd6(ActionEvent actionEvent) {
        if (txtCheakBox6.isSelected()==true){
            txtCheakBox6.setDisable(true);
        }
    }

    @FXML
    public void btnOnactionReload(ActionEvent actionEvent) {
    }


    public void btnOnActionComplete(ActionEvent actionEvent) {
        int selected=listView.getSelectionModel().getSelectedIndex();
        listViewCompleted.getItems().add(listView.getSelectionModel().getSelectedItem());
        listView.getItems().remove(selected);
        listViewDate.getItems().remove(selected);


        String taskTitle = listView.getSelectionModel().getSelectedItem().toString();
        String taskDescription = txtAddTask.getText();
        Date completionDate = Date.valueOf(dateComplete.getValue());

        String SQL = "INSERT INTO tasks (task_title, task_description, completion_date) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskManger", "root", "1234");
             PreparedStatement psTm = connection.prepareStatement(SQL)) {

            psTm.setString(1, taskTitle);
            psTm.setString(2, taskDescription);
            psTm.setDate(3, completionDate);

            int rowsAffected = psTm.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Task added successfully.");
                // Optionally, clear input fields or reload the table view here
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}





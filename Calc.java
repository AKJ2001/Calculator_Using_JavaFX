// package src.javafx;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;

class InvalidException extends Exception{
    public InvalidException(String msg){
        super(msg);
    }
}

public class Calculator extends Application{
    public static String check(double a, double b) throws InvalidException{
        if(b==0){
            throw new InvalidException("Invalid division by zero");
        }else {
            return "Valid";
        }
    }
    
    public static void main(String[] args){
        Application.launch(Calculator.class,args);
        // launch();
    }
    
    @Override
    public void start(Stage primary) throws Exception{
        // Creating a Gridpane
        GridPane gridPane = new GridPane();
        
        // Setting properties of gridpane
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(20);
        gridPane.setHgap(15);
        
        // Creating labels, buttons and textfield
        Button divButton = new Button("/");
        Button mulButton = new Button("*");
        Button addButton = new Button("+");
        Button subButton = new Button("-");
        Button clrButton = new Button("Clear");
        
        Label msgLabel = new Label("?");
        Label op1Label = new Label("Enter operand 1");
        Label op2Label = new Label("Enter operand 2");
        
        TextField op1 = new TextField();
        TextField op2 = new TextField();
        
        // setting the styles of controls
        msgLabel.setStyle("-fx-background-color: black; -fx-text-fill: #ffffff; ");
        
        op1.setStyle("-fx-background-color: burlywood; -fx-text-fill: #ffffff");
        op2.setStyle("-fx-background-color: burlywood; -fx-text-fill: #ffffff");
        
        divButton.setStyle("-fx-background-color: red; -fx-text-fill: #ffffff");
        mulButton.setStyle("-fx-background-color: maroon; -fx-text-fill: white");
        addButton.setStyle("-fx-background-color: purple; -fx-text-fill: #ffffff");
        subButton.setStyle("-fx-background-color: teal; -fx-text-fill: #ffffff");
        clrButton.setStyle("-fx-background-color: cyan; -fx-text-fill: #000000");
        
        // Setting alignment 
        msgLabel.setAlignment(Pos.CENTER);
        op1Label.setAlignment(Pos.CENTER); 
        op2Label.setAlignment(Pos.CENTER);
        
        // Setting size of controls
        op1Label.setMaxSize(200, 200);
        op2Label.setMaxSize(200, 200);
        msgLabel.setMaxSize(400, 200);
        divButton.setMaxSize(200, 200);
        mulButton.setMaxSize(200, 200);
        addButton.setMaxSize(200, 200);
        subButton.setMaxSize(200, 200);
        clrButton.setMaxSize(400, 200);
        
        // Action of buttons
        divButton.setOnAction((event) -> {	 	  	 		      	    	      	 	    	       	 	
            try{
                double x= Double.parseDouble(op1.getText());
                double y= Double.parseDouble(op2.getText());
                try{
                    double z= (double)x/y;
                    String err = check(x,y);
                    msgLabel.setText("Output is " + z);
                }catch(InvalidException e){
                    Alert alert = new Alert(AlertType.INFORMATION, "Invalid division by zero");
                    alert.showAndWait();
                }
            }catch(NumberFormatException e){
                Alert alert = new Alert(AlertType.INFORMATION, "Enter a valid number");
                alert.showAndWait();
            } 
        });
        
        mulButton.setOnAction((event) -> {
            try{
                double x= Double.parseDouble(op1.getText());
                double y= Double.parseDouble(op2.getText());
                double z= (double)x*y;
                msgLabel.setText("Output is " + z);
            }catch(NumberFormatException e){
                Alert alert = new Alert(AlertType.INFORMATION, "Enter a valid number");
                alert.showAndWait();
            }
        });
        
        addButton.setOnAction((event) -> {
            try{
                double x= Double.parseDouble(op1.getText());
                double y= Double.parseDouble(op2.getText());
                double z= (double)x+y;
                msgLabel.setText("Output is " + z);
            }catch(NumberFormatException e){	 	  	 		      	    	      	 	    	       	 	
                Alert alert = new Alert(AlertType.INFORMATION, "Enter a valid number");
                alert.showAndWait();
            }
        });
        
        subButton.setOnAction((event) -> {
            try{
                double x= Double.parseDouble(op1.getText());
                double y= Double.parseDouble(op2.getText());
                double z= (double)x-y;
                msgLabel.setText("Output is " + z);
            }catch(NumberFormatException e){
                Alert alert = new Alert(AlertType.INFORMATION, "Enter a valid number");
                alert.showAndWait();
            }
        });
        
        clrButton.setOnAction((event) -> {
            op1.setText("");
            op2.setText("");
            msgLabel.setText("");
        });
        
        // Adding all the buttons on pane
        gridPane.add(divButton, 0, 0);
        gridPane.add(mulButton, 1, 0);
        gridPane.add(addButton, 0, 1);
        gridPane.add(subButton, 1, 1);
        gridPane.add(op1Label, 0, 2);
        gridPane.add(op2Label, 1, 2);
        gridPane.add(op1, 0, 3);
        gridPane.add(op2, 1, 3);
        gridPane.add(msgLabel, 0, 4, 2, 1);
        gridPane.add(clrButton, 0, 5, 2, 1);
        
        // Creating the scene and running the stage
        Scene scene = new Scene(gridPane, 400, 400);
        primary.setTitle("CalculatorFX 1.0");
        primary.setScene(scene);
        primary.show();
    }	 	  	 		      	    	      	 	    	       	 	
}

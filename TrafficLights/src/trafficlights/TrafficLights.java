/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficLights;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/**
 *
 * @author Symons
 */
public class TrafficLights extends Application implements Runnable{
    
    static Rectangle lightsHolder;
    static Circle redLight, yellowLight, greenLight;
    
    @Override
    public void start(Stage primaryStage){
        
        lightsHolder = new Rectangle(5, 5, 200, 400);
        lightsHolder.setArcWidth(10.0);
        lightsHolder.setArcHeight(10.0);
        lightsHolder.setFill(Color.GREY);
        
        redLight = new Circle(105, 70,50);
        redLight.setFill(Color.GREY);
        redLight.setStroke(Color.AZURE);
        
        yellowLight = new Circle(105, 190,50);
        yellowLight.setFill(Color.GREY);
        yellowLight.setStroke(Color.AZURE);
        
        greenLight = new Circle(105, 310,50);
        greenLight.setFill(Color.GREY);
        greenLight.setStroke(Color.AZURE);
        
        Group root = new Group(lightsHolder, redLight, yellowLight, greenLight);
        
        Scene scene = new Scene(root, 210, 410);
        primaryStage.setTitle("Traffic Lights");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        TrafficLights trafficLight = new TrafficLights();
        Thread myThread = new Thread(trafficLight);
        myThread.start();
    }
    
    @Override
    public void run(){
        while (true){
            operateLights(); 
        }
    }
    
    void operateLights(){
       // System.out.println("Starting the lights");
            
            try{
                greenLight.setFill(Color.GRAY);
                redLight.setFill(Color.RED);
                Thread.sleep(1000);
                
                redLight.setFill(Color.GRAY);
                yellowLight.setFill(Color.YELLOW);
                Thread.sleep(1000);
                
                yellowLight.setFill(Color.GRAY);
                greenLight.setFill(Color.GREEN);
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                
            }
    }
    
    public static void main(String args[]){
        launch(args);
    }
}

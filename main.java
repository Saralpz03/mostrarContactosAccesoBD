/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscadorcontactos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



/**
 *
 * @author Alexara
 */
public class main extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
        @Override
        public void start(Stage stage) throws Exception {
        HBox h=new HBox(10);
        TextField buscar=new TextField();
        Button bt=new Button("Mostrar");       
        Label lb=new Label();
        
        ArrayList<Contacto> lista_contactos=AccesoBD.leerContactos();
        
        bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                String imprimir="";
                
                for(Contacto x : lista_contactos){
                    imprimir+=x.toString();
                }
                lb.setText(imprimir);                       
            }   
        });
        
        Scene escena=new Scene(h,300,300);
        h.getChildren().addAll(buscar,bt,lb);
        stage.setScene(escena);
        stage.show();
    }

    
}

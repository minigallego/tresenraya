package com.example.tresenraya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HelloController {
    public GridPane grid;
    public Button nuevapartida;
    public Label lab;

    public ImageView[][] array=new ImageView[3][3];
    public int[][] array2=new int[3][3];
    public Integer contador=0;
    public void initialize(){
        lab.setText("");
        contador=0;
        grid.setDisable(false);
        grid.getChildren().clear();
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                array2[i][j]=0;
            }
        }
        for (int i = 0; i < 9; i++) {
            grid.add(createImage(),i%3, i/3);
        }
        nuevapartida.setDisable(true);
    }
    private ImageView createImage() {
        Image image = new Image(getClass().getResourceAsStream("/imagenes/blanco.jpg"));
        ImageView img = new ImageView(image);
        img.setFitHeight(159);
        img.setFitWidth(119);
        img.setOnMouseClicked(this::click);
        return img;
    }

    public void click(MouseEvent mouseEvent) {
        ImageView imagen = (ImageView) mouseEvent.getSource();
        Image img=imagen.getImage();
        Integer colIndex = grid.getColumnIndex(imagen);
        Integer rowIndex=grid.getRowIndex(imagen);
        imagen.setImage(createImage2());
        if(contador%2==0){
            array2[rowIndex][colIndex]= 1;
        }else {
            array2[rowIndex][colIndex]= 2;
        }
        imagen.setDisable(true);
        contador++;
        if (array2[0][0]==array2[0][1] && array2[0][0]==array2[0][2] && array2[0][0]!=0){
            if (array2[0][0]==1){
                lab.setText("ENHROABUENA Mr Círculo");
            }else if(array2[0][0]==2){
                lab.setText("ENHROABUENA Mr X");
            }
        }else if (array2[1][0]==array2[1][1] && array2[1][0]==array2[1][2] && array2[1][0]!=0){
            if (array2[1][0]==1){
                lab.setText("ENHROABUENA Mr Círculo");
            }else if(array2[1][0]==2){
                lab.setText("ENHROABUENA Mr X");
            }
        }else if (array2[2][0]==array2[2][1] && array2[2][0]==array2[2][2] && array2[2][0]!=0){
            if (array2[2][0]==1){
                lab.setText("ENHROABUENA Mr Círculo");
            }else if(array2[2][0]==2){
                lab.setText("ENHROABUENA Mr X");
            }
        }else if (array2[0][0]==array2[1][0] && array2[0][0]==array2[2][0] && array2[0][0]!=0){
            if (array2[0][0]==1){
                lab.setText("ENHROABUENA Mr Círculo");
            }else if(array2[0][0]==2){
                lab.setText("ENHROABUENA Mr X");
            }
        }else if (array2[0][1]==array2[1][1] && array2[0][1]==array2[2][1] && array2[0][1]!=0){
            if (array2[0][1]==1){
                lab.setText("ENHROABUENA Mr Círculo");
            }else if(array2[0][1]==2){
                lab.setText("ENHROABUENA Mr X");
            }
        }else if (array2[0][2]==array2[1][2] && array2[0][2]==array2[2][2] && array2[0][2]!=0){
            if (array2[0][2]==1){
                lab.setText("ENHROABUENA Mr Círculo");
            }else if(array2[0][2]==2){
                lab.setText("ENHROABUENA Mr X");
            }
        }else if (array2[0][0]==array2[1][1] && array2[0][0]==array2[2][2]&& array2[0][0]!=0){
            if (array2[0][0]==1){
                lab.setText("ENHROABUENA Mr Círculo");
            }else if(array2[0][0]==2){
                lab.setText("ENHROABUENA Mr X");
            }
        }else if (array2[2][0]==array2[1][1] && array2[2][0]==array2[0][2] && array2[2][0]!=0){
            if (array2[1][1]==1){
                lab.setText("ENHROABUENA Mr Círculo");
            }else if(array2[1][1]==2){
                lab.setText("ENHROABUENA Mr X");
            }
        }
        if (!lab.getText().equals("")){
            nuevapartida.setDisable(false);
            grid.setDisable(true);
        }
        if(contador==9){
            nuevapartida.setDisable(false);
            grid.setDisable(true);
        }
    }
    private Image createImage2(){
        Image image;
        if(contador%2==0){
            image=new Image(getClass().getResourceAsStream("/imagenes/circle.jpg"));
        }else {
            image=new Image(getClass().getResourceAsStream("/imagenes/x.jpg"));
        }
        return image;
    }

    public void onueva(ActionEvent actionEvent) {
        initialize();
    }
}
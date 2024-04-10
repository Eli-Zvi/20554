package com.example.mamman11question2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class DrawShapesController {

    @FXML
    private Canvas canvas;

    @FXML
    public void drawShapesClick(ActionEvent event)
    {
        draw();
    }

    /**
     * draws shapes(rect/oval/line) by picking a random shape out of the 3 and picks a random color for the shape picked
     */

    public void draw()
    {
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        Random rand = new Random();
        int shapePick;


        for(int i = 0; i < 10; i++)
        {
            graphics.setFill(new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat(),1)); /* set a random color */

            shapePick = rand.nextInt(3); /* pick a random shape */

            switch (shapePick) /* draw the shape picked */
            {
                case 0:
                    graphics.fillRect(rand.nextInt((int)canvas.getWidth()),rand.nextInt((int)canvas.getHeight()),rand.nextInt((int)(canvas.getWidth()/4)),rand.nextInt((int)(canvas.getHeight()/4)));
                break;

                case 1:
                    graphics.fillOval(rand.nextInt((int)canvas.getWidth()),rand.nextInt((int)canvas.getHeight()),rand.nextInt((int)(canvas.getWidth()/4)),rand.nextInt((int)(canvas.getHeight()/4)));
                    break;

                case 2:
                    graphics.setStroke(new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat(),1));
                    graphics.strokeLine(rand.nextInt((int)canvas.getWidth()),rand.nextInt((int)canvas.getHeight()),rand.nextInt((int)(canvas.getWidth()/4)),rand.nextInt((int)(canvas.getHeight()/4)));
                    break;
            }
        }
    }
}
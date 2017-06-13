package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import logiс.Logic;

public class Main extends Application {

    private static Rectangle[][] masRectangle =  new Rectangle[800][800];
    static Group root = new Group();

    @Override
    public void start(Stage primaryStage) throws Exception{


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Logic.countingLife();
            }
        };

        timer.handle(1000);
        timer.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Logic.countingLife();
                }
            }
        }).start();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600, Color.BLACK));
        primaryStage.show();

    }
    public static void newRectangl(int x, int y){
        Rectangle rectangle = new Rectangle(x,y,1,1);
        root.getChildren().add(rectangle);
        masRectangle[x][y] = rectangle;
    }

    public static void rectanglColor(int x, int y, Color color){
        if(masRectangle[x][y] != null) {
            masRectangle[x][y].setFill(color);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

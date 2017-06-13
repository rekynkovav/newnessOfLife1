package logiс;


import javafx.scene.paint.Color;
import sample.Main;

import java.util.Random;

public class Logic {

    private static byte[][] masField = new byte[800][800];

    static {
        int tmp = 800 * 800 / 100 * 70;
        Random random = new Random();
        for (int i = 0; i < tmp; i++) {
            masField[random.nextInt(800)][random.nextInt(800)] = 1;
        }
    }
    public static void countingLife() {

        int checkNeighbors = 0;
        for (int x = 0; x < masField.length ; x++) {
            for (int y = 0; y < masField.length ; y++) {

                checkNeighbors = checkNeighbors(x,y);

                if(masField[x][y] == 0 && checkNeighbors == 3){
                    masField[x][y] = 1;
                    Main.newRectangl(x,y);
                    Main.rectanglColor(x,y, Color.GREEN);
                }

                if(masField[x][y] == 1 && checkNeighbors <= 2 || checkNeighbors > 3){
                    masField[x][y] = 0;

                    Main.rectanglColor(x,y,Color.BLACK);
                }
            }
        }
    }

    private static int checkNeighbors(int x, int y) {

        int amountOfLife = 0;

        if (x == 0 && y == 0) { // проверяем верхний левый угол
            if (masField[x + 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y + 1] == 1) {
                amountOfLife++;
            }
            if(masField[799][799] == 1){
                amountOfLife++;
            }
            if(masField[0][799] == 1){
                amountOfLife++;
            }
            if(masField[1][799] == 1){
                amountOfLife++;
            }
            if(masField[799][0] == 1){
                amountOfLife++;
            }
            if(masField[799][1] == 1){
                amountOfLife++;
            }
        }

        if (x == masField.length && y == 0) {// проверяем верхний правый угол
            if (masField[x - 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y + 1] == 1) {
                amountOfLife++;
            }
            if(masField[0][1] == 1){
                amountOfLife++;
            }
            if(masField[0][0] == 1){
                amountOfLife++;
            }
            if(masField[0][799] == 1){
                amountOfLife++;
            }
            if(masField[799][799] == 1){
                amountOfLife++;
            }
            if(masField[798][799] == 1){
                amountOfLife++;
            }

        }

        if (x == 0 && y == masField.length) { // проверяем нижний левый угол
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y] == 1) {
                amountOfLife++;
            }
            if(masField[0][2] == 1){
                amountOfLife++;
            }
            if(masField[0][0] == 1){
                amountOfLife++;
            }
            if(masField[799][0] == 1){
                amountOfLife++;
            }
            if(masField[799][799] == 1){
                amountOfLife++;
            }
            if(masField[799][798] == 1){
                amountOfLife++;
            }
        }

        if (x == masField.length && y == masField.length) { // проверяем правый нижний угол
            if (masField[x - 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
            if(masField[0][798] == 1){
                amountOfLife++;
            }
            if(masField[0][799] == 1){
                amountOfLife++;
            }
            if(masField[0][0] == 1){
                amountOfLife++;
            }
            if(masField[799][0] == 1){
                amountOfLife++;
            }
            if(masField[798][0] == 1){
                amountOfLife++;
            }
        }

        if (x == 0 & y > 0 && y < masField.length-1) { // проверяем у левой стенки
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y + 1] == 1) {
                amountOfLife++;
            }
            if(masField[799][y] == 1){
                amountOfLife++;
            }
            if(masField[799][y + 1] == 1){
                amountOfLife++;
            }
            if(masField[799][y - 1] == 1){
                amountOfLife++;
            }
        }

        if (x == masField.length && y > 0 & y < masField.length) { // проверяем у правой стенки
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y + 1] == 1) {
                amountOfLife++;
            }
            if(masField[0][y] == 1){
                amountOfLife++;
            }
            if(masField[0][y-1] == 1){
                amountOfLife++;
            }
            if(masField[0][y+1] == 1){
                amountOfLife++;
            }
        }

        if (y == 0 && x > 0 && x < masField.length-1) { // проверяем у верхней стенки
            if (masField[x + 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y + 1] == 1) {
                amountOfLife++;
            }
            if(masField[x+1][799] == 1){
                amountOfLife++;
            }
            if(masField[x][799] == 1){
                amountOfLife++;
            }
            if(masField[x-1][799] == 1){
                amountOfLife++;
            }
        }

        if (y == masField.length && x > 0 & x < masField.length) { // проверяем у нижней стенки
            if (masField[x - 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y - 1] == 1) {
                amountOfLife++;
            }
            if(masField[x][0] == 1){
                amountOfLife++;
            }
            if(masField[x+1][0] == 1){
                amountOfLife++;
            }
            if(masField[x-1][0] == 1){
                amountOfLife++;
            }
        }
        // проверка в поле где 8 клеток
        if(x > 0 && y > 0 && y < masField.length-1 && x < masField.length-1) {
            if (masField[x - 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y - 1] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y] == 1) {
                amountOfLife++;
            }
            if (masField[x + 1][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y + 1] == 1) {
                amountOfLife++;
            }
            if (masField[x - 1][y] == 1) {
                amountOfLife++;
            }
        }
        return amountOfLife;
    }
}

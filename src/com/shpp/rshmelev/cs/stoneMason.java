package com.shpp.rshmelev.cs;

import com.shpp.karel.KarelTheRobot;

public class stoneMason extends KarelTheRobot {


    public void run() throws Exception {
        turnLeft();
        while (rightIsClear()) {
            reachTheWallAndPutOneBeeper();
            moveToTheNextColumn();
        }
        if(frontIsClear()){
            reachTheWallAndPutOneBeeper();
        }


    }
    /*Передумава: Попереду робота стіна
     * Результат Робот повертає на 180 градусів, рухається поки не не має стіни. Потів повертає ліворуч,
     * рухається на одну клітинку вперед якщо це можливо и знову повертає ліворуч */
    private void moveToTheNextColumn() throws Exception {
        turnAround();
        while (frontIsClear()){
            move();
        }
        if(leftIsClear()){
            turnLeft();
            move();
            turnLeft();
        }
    }
    /*Передумава: Попереду не має стіни
     * Результат   покласти біпер якщо його не має та зробити крок.
     Якщо стіна є перевірити покласти біпер якщо його немає */

    private void reachTheWallAndPutOneBeeper() throws Exception {
        while(frontIsClear()){
            if(noBeepersPresent()){
                putBeeper();
            }
            move();
        }
        if(noBeepersPresent()){
            putBeeper();
        }
    }

    /*Передумава: немає
     * Результат Робот повертає на 180 градусів */
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
    /*Передумава: немає
     * Результат Робот повертає праворуч від себе */
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
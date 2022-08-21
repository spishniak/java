package com.shpp.rshmelev.cs;

import com.shpp.karel.KarelTheRobot;

public class chessBoardExmple2 extends KarelTheRobot {

    /* це коментар :) */
    public void run() throws Exception {
        putBeeper();

            while (leftIsClear()) {
                firstLineOdd();
                goToTheSecondLine();
                secondLineEven();
                goToTheSecondLine();
                if (leftIsBlocked()) {
                    break;
                }
                if (rightIsBlocked()) {
                    break;
                }
            }


    }
/* передумова: якщо проворуч не має стіни
* результат : повернути праворуч, зробити один крок, повернути праворуч */
    private void goToTheSecondLine() throws Exception {
        if(rightIsClear()){
            turnRight();
            move();
            turnRight();
        }
    }

    private void secondLineEven() throws Exception {
        pickBeeper();
        while (frontIsClear()){
            move();
            if(frontIsClear()){
                move();
                pickBeeper();
            }
        }
        returnToTheBeginningOfTheLine();
    }
    /* Передумова: попереду немає стіни , на кожній клітинці є бипер
* Результат:  Збираємо через один бипер поки не буде стіни і повертаємось на початок рядка*/

    private void firstLineOdd() throws Exception {
        while(frontIsClear()){
            move();
            pickBeeper();
            if(frontIsClear()){
                move();
            }

        }
        returnToTheBeginningOfTheLine();
    }

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
    /*Передумава: якщо попереду Є стіна
     * Результат Робот повертає на 180 градусів та рухається вперед поки не буде стіни*/
    private void returnToTheBeginningOfTheLine() throws Exception {
        turnAround();
        while(frontIsClear()){
            move();
        }

    }
}
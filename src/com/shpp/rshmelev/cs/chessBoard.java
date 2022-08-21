package com.shpp.rshmelev.cs;

import com.shpp.karel.KarelTheRobot;

public class chessBoard extends KarelTheRobot {

    /* це коментар :) */
    public void run() throws Exception {
        firstStep();
        secondStep();


    }

    private void secondStep() throws Exception {
        while (leftIsClear()) {
            firstLineOdd();
            goToTheSecondLine();
            secondLineEven();
            goToTheSecondLine();

        }
        if(beepersPresent()){
            firstLineOdd();
        }else{
            turnRight();
            turnRight();
        }

    }
    /* передумова: якщо проворуч не має стіни
* результат : повернути праворуч, зробити один крок, повернути праворуч */
    private void goToTheSecondLine() throws Exception {
        if(rightIsClear()){
            turnRight();
            move();
            turnRight();
        }else {
            turnRight();
            turnRight();
        }


    }

    private void secondLineEven() throws Exception {
        pickBeeper();
        while (frontIsClear()){
            move();
            if(frontIsClear()){
                move();
                if(beepersPresent()){
                    pickBeeper();
                }

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

    /*==============================
* =============================
* =============================
* ============================
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
* */
    private void firstStep() throws Exception {
        while (leftIsClear()) {
            reachTheWallAndPutBeeper();
            returnToTheBeginningOfTheLine();
            moveToTheExtColumnTurnRight();
        }
        reachTheWallAndPutBeeper();
        returnToStartingPosition();
    }

    private void pickUpBeeperThroughOneEvenLine() throws Exception {
    pickBeeper();
    while(frontIsClear()){
        move();
        if(frontIsClear()){
            move();
            pickBeeper();
        }
    }
    returnToTheBeginningOfTheLine();

    }

    /* передумова: Попереду стіна, Робот знаходить на непарному рядку
* результат: прехід з непарного рядка на парний */
    private void transitionToAnEvenLine() throws Exception {
        if(rightIsClear()){
            turnRight();
            move();
            turnRight();
        }
        returnToTheBeginningOfTheLine();
    }

    private void pickUpBeeperThroughOneOddLine() throws Exception {
        while(frontIsClear()){
            move();
            pickBeeper();
            if(frontIsClear()){
                move();
            }else {
                break;
            }

        }
        returnToTheBeginningOfTheLine();
    }
    /*Передумава: на усіх клітинках стоять Біпери
     * Результат Робот повертає у вихідне положення*/
    private void returnToStartingPosition() throws Exception {
        turnAround();
        while(frontIsClear()){
            move();
        }
        turnLeft();
        while (frontIsClear()){
            move();
        }
        turnLeft();
    }
    /*Передумава: якщо попереду не має стіни
     * Результат Робот повертає на 180 градусів та рухається вперед поки не буде стіни*/
    private void returnToTheBeginningOfTheLine() throws Exception {
        turnAround();
        while(frontIsClear()){
            move();
        }

    }
    /*Передумjва: якщо праворуч не має стіни
     * Результат Робот повертає праворуч від себе, робить крок, ще раз правору.
     * Переходить на інший рядок*/
    private void moveToTheExtColumnTurnRight() throws Exception {
        if(rightIsClear()){
            turnRight();
            move();
            turnRight();
        }
    }


    /*Передумава: немає попереду перешкод
     * Результат покласти біпер і зробити крок якщо немає попереду перешкод */
    private void reachTheWallAndPutBeeper() throws Exception {
        while(frontIsClear()){
            putBeeper();
            move();
        }
        putBeeper();
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
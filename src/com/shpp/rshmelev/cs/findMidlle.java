package com.shpp.rshmelev.cs;

import com.shpp.karel.KarelTheRobot;

public class findMidlle extends KarelTheRobot {


    public void run() throws Exception {
        putBeeperThroughStep();
        turnAround();
        collectBeepers();
        turnAround();
        moveForward();
        distributeBeepers();
        putBeeper();
        turnAround();
        deletedBeeper();
}

    private void deletedBeeper() throws Exception {
        moveForward();
        turnAround();
        while (noBeepersPresent()){
            move();

        }
        while (frontIsClear()){
            move();
            pickBeeper();
        }
    }

    private void distributeBeepers() throws Exception {
        while (beepersPresent()){
            turnAround();
            pickBeeper();
            move();
            while(beepersPresent()){
                move();
            }
            putBeeper();
            turnAround();
            moveForward();
        }
    }

    private void collectBeepers() throws Exception {
        while (frontIsClear()){
            move();
            if(beepersPresent()){
                pickBeeper();
                turnAround();
                moveForward();
                putBeeper();
                turnAround();
            }
        }
    }

    private void moveForward() throws Exception {
        while(frontIsClear()){
            move();
        }
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /* Puts one beeper every two steps until it find the wall*/
    private void putBeeperThroughStep() throws Exception {
    while (frontIsClear()){
        move();
        putBeeper();
        if(frontIsClear()){
            move();
        }
    }
    }


}
package com.shpp.rshmelev.cs;

import com.shpp.karel.KarelTheRobot;

public class robot extends KarelTheRobot {

    /* це коментар :) */
    public void run() throws Exception {
        move();
        while(beepersPresent()) {
            checkBeeperAndMoveOneStep();
            checkWolAndTurnLeft();
            checkBeeperAndMoveOneStep();
            checkWolAndTurnRight();
        }

    }

    private void checkWolAndTurnRight() throws Exception {
        if(frontIsBlocked()){
            turnLeft();
            turnLeft();
            turnLeft();
            pickBeeper();
            if(frontIsBlocked()){
                return;
            }
            move();
            turnLeft();
            turnLeft();
            turnLeft();
        }
    }

    private void checkWolAndTurnLeft() throws Exception {
        if(frontIsBlocked()){
            turnLeft();
            pickBeeper();
            move();
            turnLeft();
        }
    }


    private void checkBeeperAndMoveOneStep() throws Exception {
        while(frontIsClear()){
            pickBeeper();
            move();

        }
    }
};
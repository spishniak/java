package com.shpp.rshmelev.cs;

import com.shpp.karel.KarelTheRobot;

public class MyKarel extends KarelTheRobot {

    /* це коментар :) */
    public void run() throws Exception {
        dublicateBeeprs();
        

    }

    private void dublicateBeeprs() throws Exception {
        while(beepersPresent()){
            dublicateBeepr();
            returnBackOrigin();
            restoreOriginalBeepers();
        }
    }

    private void restoreOriginalBeepers() throws Exception {
        move();
        move();
        while (beepersPresent()){
            moveBeeperFromAuxPileToOrigin();
            returnBackToAuxPile();
        }
    }

    private void returnBackToAuxPile() throws Exception {
        turnAround();
        move();
        move();
    }

    private void moveBeeperFromAuxPileToOrigin() throws Exception {
        pickBeeper();
        turnAround();
        move();
        move();
        putBeeper();
    }

    private void returnBackOrigin() throws Exception {
        turnAround();
        move();
        move();
        turnAround();
    }

    private void dublicateBeepr() throws Exception {
        pickBeeper();
        move();
        putBeeper();


    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    private void moveBeepers() throws Exception {
        while(noBeepersPresent()){
            move();
        }
    }

    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    private void moveUntilWall() throws Exception {
        while(frontIsClear()){
            move();
        }
    }
    private void moveToNextRoud() throws Exception {
        turnLeft();
        move();
        turnRight();
    }
    private void jumpOverTheHurdle() throws Exception {
        turnLeft();
        while(rightIsBlocked()){
            move();
        }
        turnRight();
        move();
        move();
        turnRight();
        moveUntilWall();
        turnLeft();
    }
}

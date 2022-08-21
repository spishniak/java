package com.shpp.rshmelev.cs;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {


    public void run() throws Exception {
        leaveAndEnterTheApartment();
        openTheDoorToPickUpTheNewspaper();
        leaveAndEnterTheApartment();


    }
    /*Передумава: немає
     * Результат Робот повертає на 180 градусів */
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
    /*Передумава: немає попереду стіни
     * Результат Робот забирає газету та повертається в будинок */
    private void openTheDoorToPickUpTheNewspaper() throws Exception {
        turnLeft();
        move();
        move();
        pickBeeper();
        turnAround();

    }
    /*Передумава: немає перешкод попереду
     * Результат Робот  йде до перешкоди,  повертає праворуч та робить ще один крок*/
    private void leaveAndEnterTheApartment() throws Exception {
        while(frontIsClear()){
            move();
        }
        turnRight();
        move();
    }

    /*Передумава: немає
     * Результат Робот повертає праворуч від себе */
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
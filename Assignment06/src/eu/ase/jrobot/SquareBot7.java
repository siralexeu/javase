package eu.ase.jrobot;

import robocode.Robot;

public class SquareBot7 extends Robot {
    public void run() {
        int count = 0;
        while (true) {
            count++;
            moveInSquare(150);
        }
    }

    public void moveInSquare(int lengthOfSide) {
        for (int i = 0; i < 4; i++) {
            ahead(lengthOfSide);
            turnRight(90);
        }
    }
}
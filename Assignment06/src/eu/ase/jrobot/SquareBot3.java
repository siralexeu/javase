package eu.ase.jrobot;

import robocode.Robot;

public class SquareBot3 extends Robot {
    public void run() {
        for (int j = 0; j < 4; j++) {
            ahead(150);
            turnRight(90);
        }
    }
}
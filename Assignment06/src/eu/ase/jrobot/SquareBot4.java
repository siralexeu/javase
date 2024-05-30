package eu.ase.jrobot;

import robocode.Robot;

public class SquareBot4 extends Robot {
    public void run() {
        while (true) {
            for (int j = 0; j < 4; j++) {
                ahead(150);
                turnRight(90);
            }
        }
    }
}
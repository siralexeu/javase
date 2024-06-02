package eu.ase.jrobot;

import robocode.Robot;

public class SquareBot6 extends Robot {
    public void run() {
        int count = 0;
        while (true) {
            count++;
            if (count % 2 == 0) {
                for (int j = 0; j < 4; j++) {
                    ahead(150);
                    turnRight(90);
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    ahead(150);
                    turnLeft(90);
                }
            }
        }
    }
}
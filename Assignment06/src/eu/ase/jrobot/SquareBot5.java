package eu.ase.jrobot;

import robocode.Robot;

public class SquareBot5 extends Robot {
    public void run() {
        int count = 0;
        while (true) {
            count++;
            System.out.println("Completed Squares: " + count);
            for (int j = 0; j < 4; j++) {
                ahead(150);
                turnRight(90);
            }
        }
    }
}


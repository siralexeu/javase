package eu.ase.jrobot;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class SquareBot8 extends Robot {
    private boolean aggressive = true;
    private boolean scanForRobots = true;

    public void run() {
        while (true) {
            moveInSquare(150);
            if (scanForRobots) {
                turnRadarRight(360);
            }
        }
    }

    public void moveInSquare(int lengthOfSide) {
        for (int i = 0; i < 4; i++) {
            ahead(lengthOfSide);
            turnRight(90);
            if (aggressive) {
                fire(1);
            }
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        if (aggressive) {
            fire(1);
        }
    }
}
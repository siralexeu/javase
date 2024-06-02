package eu.ase.jrobot;

import robocode.Robot;
import robocode.ScannedRobotEvent;


public class SquareBot1 extends Robot {
    public void run() {
        for (int i = 0; i < 4; i++) {
            ahead(150);
            turnRight(90);  
        }
    }
}
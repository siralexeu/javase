package eu.ase.jrobot;

import robocode.Robot;

public class SquareBot2 extends Robot {
    public void run() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                ahead(150); 
                turnRight(90); 
            }
        }
    }
}
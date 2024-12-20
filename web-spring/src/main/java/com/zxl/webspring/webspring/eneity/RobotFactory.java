package com.zxl.webspring.webspring.eneity;

public class RobotFactory {

    public static Robot StaticcreateRobot() {
        return new Robot();
    }

    public Robot NoStaticcreateRobot() {
        return new Robot();
    }
}

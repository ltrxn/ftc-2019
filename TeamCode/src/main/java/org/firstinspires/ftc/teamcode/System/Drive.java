package org.firstinspires.ftc.teamcode.System;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Drive {

    //Motors with encoders
    public DcMotor leftFront, rightFront;

    //Sleep time interval (milliseconds) for the position update thread
    private int sleepTime;

    //Position variables used for storage and calculation
    double rightEncoderWheelPosition = 0, leftEncoderWheelPosition = 0, changeInRobotOrientation = 0;
    private double robotOrientationRadians = 0;
    private double previousRightEncoderWheelPosition = 0, previousLeftEncoderWheelPosition = 0;

    //counts per inch
    double COUNTS_PER_INCH;

    public Drive (Hardware hw, double COUNTS_PER_INCH, int threadSleepDelay) {
        leftFront = hw.leftFront;
        rightFront = hw.rightFront;

        sleepTime = threadSleepDelay;

        this.COUNTS_PER_INCH = COUNTS_PER_INCH;
    }
}

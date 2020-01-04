package org.firstinspires.ftc.teamcode.System;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Drive {

    //Motors with encoders
    public DcMotor leftFront, rightFront, leftBack, rightBack;

    //Other hardware members
    public BNO055IMU imu;

    //hardware
    Hardware robot;

    //Sleep time interval (milliseconds) for the position update thread
    private int sleepTime;

    //counts per inch
    double COUNTS_PER_INCH;

    public Drive (Hardware hw, double COUNTS_PER_INCH) {
        robot = hw;

        leftFront = hw.leftFront;
        rightFront = hw.rightFront;
        leftBack = hw.leftBack;
        rightBack = hw.rightBack;

        this.imu = imu;

        this.COUNTS_PER_INCH = COUNTS_PER_INCH;
    }

    public void driveStraightDistance(double distanceInInches, double masterPower) throws InterruptedException {
        int targetTick = (int)(distanceInInches * COUNTS_PER_INCH);

        int totalTicks = 0;

        //start weaker wheel with less power
        double slavePower = masterPower-.1;

        int error = 0;
        int kp = 5;

        robot.resetEncoders();
        wait(100);

        while(totalTicks<targetTick) {
            robot.setMotorPower(masterPower, slavePower, masterPower, slavePower);
            error = leftFront.getCurrentPosition() - rightFront.getCurrentPosition();

            slavePower += error/kp;

            robot.resetEncoders();
            wait(100);

            totalTicks+=leftFront.getCurrentPosition();
        }
        robot.setMotorPower(0,0,0,0);
    }

    public void turn(int degrees) {

    }


}

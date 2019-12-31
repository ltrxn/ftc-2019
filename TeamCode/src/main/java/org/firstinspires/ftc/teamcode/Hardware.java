package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Hardware {

    /*  Public Members  */
    public DcMotor leftFront    = null;
    public DcMotor leftBack     = null;
    public DcMotor rightFront   = null;
    public DcMotor rightBack    = null;

    public Servo claw           = null;

    public BNO055IMU imu = null;



    /*  Private Members */
    HardwareMap map           = null;
    Telemetry tele            = null;
    private ElapsedTime period  = new ElapsedTime();


    /**
     * Constructor
     */
    public Hardware(){
    }

    /**
     * Initialize standard hardware interfaces
     * @param hm - Hardware map
     */
    public void init (HardwareMap hm, Telemetry t) {
        //assign hardware map
        map = hm;
        tele = t;

        //define and initialize motors
        leftFront = map.get(DcMotor.class, "leftFront");
        rightFront = map.get(DcMotor.class, "rightFront");
        leftBack = map.get(DcMotor.class, "leftBack");
        rightBack = map.get(DcMotor.class, "rightBack");

        //define and initialize servos
        claw = map.get(Servo.class, "grabber");

        //initialize IMU
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled = true;
        parameters.useExternalCrystal = true;
        parameters.mode = BNO055IMU.SensorMode.IMU;
        parameters.loggingTag = "IMU";
        imu = map.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        //reverse left side
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);

    }

    /**
     * Set the motor mode for all motors
     * @param runMode - run mode to change to.
     */
    public void setMotorMode(DcMotor.RunMode runMode) {
        leftFront.setMode(runMode);
        leftBack.setMode(runMode);
        rightFront.setMode(runMode);
        rightBack.setMode(runMode);
    }
}

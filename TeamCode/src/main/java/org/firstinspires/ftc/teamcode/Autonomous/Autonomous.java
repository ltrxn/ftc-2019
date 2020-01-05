package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.System.Drive;
import org.firstinspires.ftc.teamcode.System.Hardware;


public class Autonomous extends LinearOpMode {

    Hardware robot = new Hardware();
    Drive drive = new Drive(robot, 100);

    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.addData("Initialization", "In Progress");

        telemetry.setMsTransmissionInterval(100);
        telemetry.update();

        robot.init(hardwareMap, telemetry);

        telemetry.addData("Initialization", "Ready");
        telemetry.update();

        waitForStart();


    }
}

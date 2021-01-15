package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="teleop")

public class BasicOpMode_Iterative extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    hardware robot = new hardware();

    @Override
    public void init() {
        
        robot.init(hardwareMap);
    }

   
    @Override
    public void init_loop() {
    }


    @Override
    public void start() {
        runtime.reset();
    }


    @Override
    public void loop() {
      drive();
        shoot();
    intake();
    flick();
    push();
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

    public void shoot(){

        telemetry.addData("speed", robot.shooter.getVelocity());
        if(gamepad2.left_bumper)
        robot.shooter.setVelocity(1650);
        if (!gamepad2.left_bumper)
            robot.shooter.setVelocity(0);
        }

    public void drive(){
        double r = Math.hypot(gamepad1.left_stick_x, -gamepad1.left_stick_y);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = gamepad1.right_stick_x / 2;
        final double v1 = r * Math.cos(robotAngle) - rightX;//bl
        final double v3 = r * Math.sin(robotAngle) - rightX;//fl
        final double v2 = r * Math.sin(robotAngle) + rightX;//br
        final double v4 = r * Math.cos(robotAngle) + rightX;//fr

        robot.bl.setPower(v1);
        robot.fl.setPower(v3);
        robot.br.setPower(v2);
        robot.fr.setPower(v4);
    }
    public void intake(){
        if (gamepad2.right_bumper)
        robot.intake.setPower(1);
        if (!gamepad2.right_bumper)
            robot.intake.setPower(0);
    }
    public void flick(){
        if (gamepad2.x)
            robot.flicker.setPosition(0);
        if (!gamepad2.x)
            robot.flicker.setPosition(.5);
    }
    public void push(){
        if (gamepad1.right_bumper)
            robot.pusher.setPosition(1);
        if (!gamepad1.right_bumper)
            robot.pusher.setPosition(.5);
    }
}

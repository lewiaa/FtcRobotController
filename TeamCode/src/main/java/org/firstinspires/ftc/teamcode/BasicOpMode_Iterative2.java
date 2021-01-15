package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="test")

public class BasicOpMode_Iterative2 extends OpMode
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

    
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

    public void shoot(){

        telemetry.addData("speed", robot.shooter.getVelocity());
        if(gamepad2.y)
            robot.shooter.setVelocity(28*5000);
        if (!gamepad2.y)
            robot.shooter.setVelocity(0);
        }

    public void drive(){

        robot.bl.setPower(boolToInt(gamepad1.a));
        robot.fl.setPower(boolToInt(gamepad1.b));
        robot.br.setPower(boolToInt(gamepad1.y));
        robot.fr.setPower(boolToInt(gamepad1.x));
    }
    public void intake(){
        if (gamepad2.a)
        robot.intake.setPower(1);
        if (!gamepad2.a)
            robot.intake.setPower(0);
    }

    public double boolToInt(boolean in){
       double out = 0;
        if (in){
            out = 1;
        }
        if (!in){
            out = 0;
        }
    return out;
    }

}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Joystick Motor Control", group="Tutorial")
public class JoystickMotorControl extends OpMode {

    private DcMotor motor;

    @Override
    public void init() {
        motor = hardwareMap.get(DcMotor.class, "intakeMotor");
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {
        double power = -gamepad1.left_stick_y;
        power = Math.max(-1.0, Math.min(1.0, power));

        motor.setPower(power);

        telemetry.addData("Joystick", power);
        telemetry.update();
    }
}

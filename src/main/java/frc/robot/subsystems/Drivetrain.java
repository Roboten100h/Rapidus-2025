// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private Talon backLeftMotor;
  private Talon backRightMotor;
  private Talon frontLeftMotor;
  private Talon frontRightMotor;

  public Drivetrain() {
    backLeftMotor = new Talon(Constants.PWMChannels.backLeftMotor);
    backRightMotor = new Talon(Constants.PWMChannels.backRightMotor);
    frontLeftMotor = new Talon(Constants.PWMChannels.frontLeftMotor);
    frontRightMotor = new Talon(Constants.PWMChannels.frontRightMotor);

    backLeftMotor.setInverted(false);
    backRightMotor.setInverted(true);
    frontLeftMotor.setInverted(false);
    frontRightMotor.setInverted(true);
  }

  public void driveTank(double leftSpeed, double rightSpeed) {
    backLeftMotor.set(leftSpeed);
    backRightMotor.set(rightSpeed);
    frontLeftMotor.set(leftSpeed);
    frontRightMotor.set(rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

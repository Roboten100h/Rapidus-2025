// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private Talon backLeftMotor = new Talon(0);
  private Talon backRightMotor = new Talon(1);
  private Talon frontLeftMotor = new Talon(2);
  private Talon frontRightMotor = new Talon(3);

  public Drivetrain() {
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

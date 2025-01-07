// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pince extends SubsystemBase {
  /** Creates a new Pince. */
  private Servo servo1;
  private boolean isServo1Open = false;

  public Pince() {
    servo1 = new Servo(Constants.PWMChannels.servo1);
  }


  public void toggleServo() {
    if (isServo1Open) {
      servo1.setAngle(30);
      isServo1Open = false;
    } else {
      servo1.setAngle(30);
      isServo1Open = true;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

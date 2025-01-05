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
  private Servo servo2;
  private boolean isServo1Open = false;
  private boolean isServo2Open = false;

  public Pince() {
    servo1 = new Servo(Constants.PWMChannels.servo1);
    servo2 = new Servo(Constants.PWMChannels.servo2);
  }


  public void toggleServo(int servo) {
    if (servo == 1) {
      if (isServo1Open) {
        servo1.setAngle(15);
        isServo1Open = false;
      } else {
        servo1.setAngle(150);
        isServo1Open = true;
      }
    } else if (servo == 2) {
      if (isServo2Open) {
        servo2.setAngle(0);
        isServo2Open = false;
      } else {
        servo2.setAngle(180);
        isServo2Open = true;
      }
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

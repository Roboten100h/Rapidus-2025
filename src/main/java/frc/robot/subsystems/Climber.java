// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  private DoubleSolenoid solenoid;
  public Climber() {
    solenoid = new DoubleSolenoid( Constants.CanIDs.PCM,PneumaticsModuleType.CTREPCM, Constants.PCMPorts.solenoid1, Constants.PCMPorts.solenoid2);
  }
  public void setSolenoid(DoubleSolenoid.Value value) {
    solenoid.set(value);
  }
  public DoubleSolenoid.Value getSolenoid() {
    return solenoid.get();
  }

  public void toggleSolenoid() {
    if (solenoid.get() == DoubleSolenoid.Value.kForward) {
      solenoid.set(DoubleSolenoid.Value.kReverse);
    } else {
      solenoid.set(DoubleSolenoid.Value.kForward);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

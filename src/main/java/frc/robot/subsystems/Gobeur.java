// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Gobeur extends SubsystemBase {
  /** Creates a new Gobeur. */
  private SparkMax moteurAngle;
  private SparkMax moteurRouleau;
  private DigitalInput limitSwitch;
  private RelativeEncoder relativeEncoder;

  public Gobeur() {
    moteurAngle = new SparkMax(Constants.CanIDs.moteurAngle, MotorType.kBrushless);
    moteurRouleau = new SparkMax(Constants.CanIDs.moteurRouleau, MotorType.kBrushed);

    limitSwitch = new DigitalInput(Constants.DigitalIOs.limitSwitchGobeur);

    relativeEncoder = moteurAngle.getEncoder();
  }

  public void setRouleauVitesse(double vitesse) {
    moteurRouleau.set(vitesse);
  }

  public void setAngleVitesse(double vitesse) {
    if (getLimitSwitch()) {
      vitesse = Math.max(vitesse, 0);
    }
    moteurAngle.set(vitesse);
  }

  public boolean getLimitSwitch() {
    return limitSwitch.get();
  }

  public double getAnglePosition() {
    return relativeEncoder.getPosition();
  }

  public void resetAnglePosition() {
    relativeEncoder.setPosition(0);
  }

  @Override
  public void periodic() {
    if (getLimitSwitch()) {
      resetAnglePosition();
    }
    SmartDashboard.putNumber("Angle Position", getAnglePosition());
    SmartDashboard.putBoolean("Switch Gobeur", getLimitSwitch());
    // This method will be called once per scheduler run
  }
}

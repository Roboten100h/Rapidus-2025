// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Echelle extends SubsystemBase {
  /** Creates a new Echelle. */
  private SparkMax moteurEchelle;
  private DigitalInput limitSwitch;
  private RelativeEncoder relativeEncoder;
  private int stage;

  public Echelle() {
    moteurEchelle = new SparkMax(Constants.CanIDs.elevatorMotor, MotorType.kBrushless);

    SparkMaxConfig sparkBaseConfig = new SparkMaxConfig();
    sparkBaseConfig.idleMode(IdleMode.kBrake);
    sparkBaseConfig.inverted(false);
    sparkBaseConfig.closedLoopRampRate(0.5);
    sparkBaseConfig.openLoopRampRate(0.5);

    moteurEchelle.configure(sparkBaseConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

    limitSwitch = new DigitalInput(Constants.DigitalIOs.limitSwitchEchelle);

    relativeEncoder = moteurEchelle.getEncoder();

  }

  public void setEchelle(double vitesse) {
    if (getLimitSwitch()) {
      vitesse = Math.max(vitesse, 0);
    }
    moteurEchelle.set(vitesse);
  }

  public int wantedStage() {
    return stage;
  }

  public void setStage(int stage) {
    this.stage = stage;
  }

  public boolean getLimitSwitch() {
    return !limitSwitch.get();
  }

  public double getEchellePosition() {
    return relativeEncoder.getPosition();
  }

  public void resetEchellePosition() {
    relativeEncoder.setPosition(0);
  }

  @Override
  public void periodic() {
    if (getLimitSwitch()) {
      resetEchellePosition();
    }
    SmartDashboard.putNumber("Echelle Position", getEchellePosition());
    SmartDashboard.putBoolean("Limit Switch", getLimitSwitch());
    SmartDashboard.putNumber("Wanted Stage", wantedStage());
    // This method will be called once per scheduler run
  }
}

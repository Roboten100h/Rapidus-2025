// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Entonnoir extends SubsystemBase {
  /** Creates a new Entonnoir. */
  private VictorSPX moteurSortie;
  private TalonSRX moteurEntree;
  private DigitalInput procSensor;
  private boolean sortieState = false;

  public Entonnoir() {
    moteurSortie = new VictorSPX(Constants.CanIDs.outakeMotor);
    moteurEntree = new TalonSRX(Constants.CanIDs.intakeMotor);

    moteurSortie.setInverted(false);
    moteurEntree.setInverted(false);

    moteurSortie.setNeutralMode(NeutralMode.Brake);
    moteurEntree.setNeutralMode(NeutralMode.Brake);

    procSensor = new DigitalInput(Constants.DigitalIOs.procSensor);
  }

  public void setSortie(double vitesse) {
    moteurSortie.set(ControlMode.PercentOutput, vitesse);
  }

  public double getSortie() {
    return moteurSortie.getMotorOutputPercent();
  }

  public void setEntree(double vitesse) {
    moteurEntree.set(ControlMode.PercentOutput, vitesse);
  }

  public double getEntree() {
    return moteurEntree.getMotorOutputPercent();
  }

  public boolean getProcSensor() {
    return !procSensor.get();
  }

  public void setSortieState(boolean state) {
    sortieState = state;
  }

  public boolean getSortieState() {
    return sortieState;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Intake?", sortieState);
  }
}

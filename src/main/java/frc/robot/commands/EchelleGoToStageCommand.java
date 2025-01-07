// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Echelle;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class EchelleGoToStageCommand extends Command {
  /** Creates a new EchelleGoToStageCommand. */
  private PIDController pidController;
  private Echelle echelle;
  private double output;
  public EchelleGoToStageCommand(Echelle echelle) {
    this.echelle = echelle;
    addRequirements(echelle);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pidController = new PIDController(0.1, 0.1, 0.1);
    pidController.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    output = pidController.calculate(echelle.getEchellePosition(), Constants.EncoderConstants.echelleStage[echelle.wantedStage()]);
    echelle.setEchelle(output);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    echelle.setEchelle(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

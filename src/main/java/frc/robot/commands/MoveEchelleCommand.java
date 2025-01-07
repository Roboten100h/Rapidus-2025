// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Echelle;
import frc.util.Range;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class MoveEchelleCommand extends Command {
  /** Creates a new MoveEchelleCommand. */
  private Echelle echelle;
  private CommandXboxController operatorController;
  public MoveEchelleCommand(Echelle echelle, CommandXboxController operatorController) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.echelle = echelle;
    this.operatorController = operatorController;
    addRequirements(echelle);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double stickY = operatorController.getRightY();
    stickY = Range.threshold(0.05, stickY);
    stickY = Math.pow(stickY, 5);
    echelle.setEchelle(0.8*stickY);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

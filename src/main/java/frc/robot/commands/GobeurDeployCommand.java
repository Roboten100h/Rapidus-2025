// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Gobeur;
import frc.util.Range;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class GobeurDeployCommand extends Command {
  /** Creates a new GobeurDeployCommand. */
  private Gobeur gobeur;
  private CommandXboxController operatorController;
  public GobeurDeployCommand(Gobeur gobeur, CommandXboxController operatorController) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.gobeur = gobeur;
    this.operatorController = operatorController;
    addRequirements(gobeur);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStickY = operatorController.getLeftY();
    leftStickY = Range.threshold(0.1, leftStickY);
    leftStickY = Math.pow(leftStickY, 3);
    gobeur.setAngleVitesse(leftStickY);
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
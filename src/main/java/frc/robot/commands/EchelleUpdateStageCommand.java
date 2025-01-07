// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Echelle;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class EchelleUpdateStageCommand extends InstantCommand {
  private Echelle echelle;
  public boolean up;
  public EchelleUpdateStageCommand(Echelle echelle, boolean up) {
    this.echelle = echelle;
    this.up = up;
    addRequirements(echelle);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(up && echelle.wantedStage() < 3){
      echelle.setStage(echelle.wantedStage() + 1);
    } else if(!up && echelle.wantedStage() > 0){
      echelle.setStage(echelle.wantedStage() - 1);
    }
  }
}

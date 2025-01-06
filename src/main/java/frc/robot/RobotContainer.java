// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DrivetrainDriveCommand;
import frc.robot.commands.MoveEchelleCommand;
import frc.robot.commands.OutakeCommand;
import frc.robot.commands.ToggleEntonnoirCommand;
import frc.robot.commands.ToggleServo1Command;
import frc.robot.commands.ToggleServo2Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Echelle;
import frc.robot.subsystems.Entonnoir;
import frc.robot.subsystems.Pince;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain drivetrain = new Drivetrain();

  private final Pince pince = new Pince();

  private final Echelle echelle = new Echelle();

  private final Entonnoir entonnoir = new Entonnoir();

  private SendableChooser<Command> autoChooser = new SendableChooser<>();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController driverController =
      new CommandXboxController(OperatorConstants.driverControllerPort);
  
  private final CommandXboxController operatorController =
      new CommandXboxController(OperatorConstants.operatorControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    drivetrain.setDefaultCommand(new DrivetrainDriveCommand(drivetrain, driverController));
    echelle.setDefaultCommand(new MoveEchelleCommand(echelle, operatorController));

    autoChooser.addOption("Do nothing", null);

    SmartDashboard.putData("Auto Chooser", autoChooser);
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    operatorController.b().onTrue(new ToggleServo1Command(pince));
    operatorController.x().onTrue(new ToggleServo2Command(pince));
    operatorController.y().whileTrue(new OutakeCommand(entonnoir));
    operatorController.a().onTrue(new ToggleEntonnoirCommand(entonnoir));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return autoChooser.getSelected();
  }
}

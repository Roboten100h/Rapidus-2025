// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int driverControllerPort = 0;
    public static final int operatorControllerPort = 1;
  }

  public static class CanIDs {
    public static final int backLeftMotor = 8;
    public static final int backRightMotor = 6;
    public static final int frontLeftMotor = 5;
    public static final int frontRightMotor = 7;

    public static final int intakeMotor = 9;
    public static final int outakeMotor = 10;

    public static final int elevatorMotor = 11;

    public static final int moteurRouleau = 4;
    public static final int moteurAngle = 3;

    public static final int PCM = 21;
  }

  public static class PWMChannels {
    public static final int servo1 = 1;
  }

  public static class DigitalIOs {
    public static final int limitSwitchEchelle = 1;
    public static final int procSensor = 0;
    public static final int limitSwitchGobeur = 2;
  }

  public static class PCMPorts {
    public static final int solenoid1 = 0;
    public static final int solenoid2 = 1;
  }

  public static class EncoderConstants {
    public static int echelleStage[] = {-10, 50, 115, 215};
    

    public static int gobeurStage[] = {0, 1, 2, 3};

  }
}

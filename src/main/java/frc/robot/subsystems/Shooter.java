// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.CAN;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private final CANSparkMax shooterR = new CANSparkMax(CAN.shooterR, MotorType.kBrushless);
  private final CANSparkMax shooterL = new CANSparkMax(CAN.shooterL, MotorType.kBrushless);

  /** Creates a new Shooter. */
  public Shooter() {
    shooterL.restoreFactoryDefaults();
    shooterR.restoreFactoryDefaults();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

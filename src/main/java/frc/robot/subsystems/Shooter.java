// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.CommandXboxController;
import frc.robot.Constants.CAN;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private final CANSparkMax shooterF = new CANSparkMax(CAN.shooterF, MotorType.kBrushless);
  private final CANSparkMax shooterB = new CANSparkMax(CAN.shooterB, MotorType.kBrushless);
  private final CommandXboxController controller = new CommandXboxController(0);
  private final CANSparkMax booperMotor = new CANSparkMax(CAN.booper, MotorType.kBrushless);
  private final RelativeEncoder booperEncoder = booperMotor.getEncoder();
  private boolean booping = false;
  private double TargetBoopPosition = 0;

  /** Creates a new Shooter. */
  public Shooter() {
    shooterF.restoreFactoryDefaults();
    shooterB.restoreFactoryDefaults();
    shooterB.follow(shooterF);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setShooterVoltage(controller.getLeftTriggerAxis() * 0.7);
    if (controller.leftBumper().get()){
      booping = true;
      TargetBoopPosition++;
    }
    
    if (booping && booperEncoder.getPosition() < TargetBoopPosition){
      booperMotor.set(0.1);
    }
    else{
      booping = false;
      booperMotor.set(0);
    }
    // SmartDashboard.putData(booperEncoder.getPosition());
  }

//   public void boop(){
// //     booperEncoder.setPosition(1);
// //     // booping = true;
// //     booperMotor.set(0.2);
// //     while (booperEncoder.getVelocity() > 0){
// // ;
// //     }
//       booperMotor.set(0.1);
//   }

//   public void noBoop(){
//     booperMotor.set(0);
//   }

  public void setShooterVoltage(double percent){
    shooterF.set(percent);
  }
  
}

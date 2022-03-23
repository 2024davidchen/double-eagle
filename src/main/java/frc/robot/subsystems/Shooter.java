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
  

    // if (controller.leftBumper().get()){
    //   TargetBoopPosition++;
    // }
    
    // if (booperEncoder.getPosition() < TargetBoopPosition){
    //   booperMotor.set(0.7);
    // }
    // else{
    //   booperMotor.set(0);
    // }
    SmartDashboard.putNumber("booperPos", booperEncoder.getPosition());
  }
  public void boop(){
    booperMotor.set(-0.1);
  }

  public void shoot(){
    booperMotor.set(-0.1);
    setShooter(0.5);
  }
  public void noShoot(){
    booperMotor.set(0);
    setShooter(0);
  }
  
  
public void aBoop(){
  booperEncoder.setPosition(booperEncoder.getPosition()+1);
}

  public void noBoop(){
    booperMotor.set(0);
  }

  public void setShooter(double percent){
    shooterF.set(percent);
  }
  
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.BooleanSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.CommandXboxController;
import frc.robot.Constants.CAN;
import io.github.oblarg.oblog.annotations.Config;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private final CANSparkMax shooterF = new CANSparkMax(CAN.shooterF, MotorType.kBrushless);
  private final CANSparkMax shooterB = new CANSparkMax(CAN.shooterB, MotorType.kBrushless);
  private final RelativeEncoder sfEnc =  shooterF.getEncoder();
  private final CommandXboxController controller = new CommandXboxController(0);
  private final CANSparkMax booperMotor = new CANSparkMax(CAN.booper, MotorType.kBrushless);
  private final RelativeEncoder booperEncoder = booperMotor.getEncoder();
  private boolean booping = false;
  private double TargetBoopPosition = 0;
  private double targetRPM = 0;

  PIDController shooterPID = new PIDController(0, 0, 0);
  SimpleMotorFeedforward shooterFF = new SimpleMotorFeedforward(0, 0.1);

  /** Creates a new Shooter. */
  public Shooter() {
    shooterF.restoreFactoryDefaults();
    shooterB.restoreFactoryDefaults();
    booperMotor.restoreFactoryDefaults();
    booperEncoder.setPosition(0);
    shooterB.follow(shooterF);
    
  }

  @Config
  public void setShooterPID(double P, double I, double D){
    shooterPID.setPID(P, I, D);
  }

  public void shoot(){
    double ffEffort = (shooterFF.calculate(getShooterRPM(), targetRPM))* .95;
    double pidEffort = shooterPID.calculate(getShooterRPM(), targetRPM);

    double totalEffort = ffEffort + pidEffort;

    shooterF.setVoltage(totalEffort);
  }

  public double getShooterRPM(){
    return sfEnc.getVelocity();
  }

  public void setShooter(double percent){
    shooterF.set(percent);
  }

  public void boop(){
    booperMotor.set(-0.1);
  }

  public void noShoot(){
    booperMotor.set(0);
    setShooter(0);
  }

  public void noBoop(){
    booperMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  

    // if (controller.leftBumper().get()){
    //   TargetBoopPosition -= 15;
    // }
    
    if (booperEncoder.getPosition() > TargetBoopPosition){
      booperMotor.set(-0.1);
    }
    else{
      booperMotor.set(0);
    }
    SmartDashboard.putNumber("booperPos", booperEncoder.getPosition());
    SmartDashboard.putNumber("TargetBooperPos", TargetBoopPosition);
  }

  public void boop(){
    // booperMotor.set(-0.1);
    TargetBoopPosition -= 10.5;
  }

  public void shoot(){
    booperMotor.set(-0.1);
    setShooter(0.9);
  }
  public void noShoot(){
    booperMotor.set(0);
    setShooter(0);
  }

}

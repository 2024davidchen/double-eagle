// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants.CAN;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  private final CANSparkMax intakeMotor = new CANSparkMax(CAN.intake, MotorType.kBrushless);
  private final Talon booperMotor = new Talon(25);

  private final DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, CAN.solenoidF, CAN.solenoidR);

  /** Creates a new Intake. */
  public Intake() {
    solenoid.set(Value.kReverse);
    intakeMotor.restoreFactoryDefaults();
    booperMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void setIntakeVoltage(double voltage){
    intakeMotor.set(voltage);
  }

  public void setBooperVoltage(double voltage){
    booperMotor.set(voltage);
  }
  
  public void toggleSolenoid(){
    solenoid.toggle();
  }

  public void extend(){
    solenoid.set(Value.kForward);
  }
  public void retract(){
    solenoid.set(Value.kReverse);
  }
}

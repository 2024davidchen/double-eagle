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
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.CommandXboxController;

public class Intake extends SubsystemBase {

  private final CANSparkMax intakeMotor = new CANSparkMax(CAN.intake, MotorType.kBrushless);
  private final CommandXboxController controller = new CommandXboxController(0);

  private final DoubleSolenoid solenoid = new DoubleSolenoid(CAN.pneumaticmod, PneumaticsModuleType.REVPH, CAN.solenoidF, CAN.solenoidR);
  private boolean extended = false;

  /** Creates a new Intake. */
  public Intake() {
    solenoid.set(Value.kReverse);
    intakeMotor.restoreFactoryDefaults();
    intakeMotor.setInverted(true);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // setIntakeVoltage(controller.getRightTriggerAxis());
    while (extended){
      setIntakeVoltage(0.2);
    }
    if (!extended){
      setIntakeVoltage(0);
    }
  }
  
  public void setIntakeVoltage(double voltage){
    intakeMotor.set(voltage);
  }

  
  public void toggleSolenoid(){
    solenoid.toggle();
  }

  public void extend(){
    solenoid.set(Value.kForward);
    extended = true;
  }
  public void retract(){
    solenoid.set(Value.kReverse);
    extended = false;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.hal.SimDouble;
import edu.wpi.first.hal.simulation.SimDeviceDataJNI;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.CAN;
// import frc.robot.Constants.Drive;
// import frc.robot.RelativeEncoderSim;
import frc.robot.Robot;
// import io.github.oblarg.oblog.Loggable;
// import io.github.oblarg.oblog.annotations.Config;
// import io.github.oblarg.oblog.annotations.Log;
import java.util.List;
import java.util.function.DoubleSupplier;


public class Drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */
  private final CANSparkMax FL = new CANSparkMax(CAN.driveFL, MotorType.kBrushless);
  private final CANSparkMax FR = new CANSparkMax(CAN.driveFR, MotorType.kBrushless);
  private final CANSparkMax BL = new CANSparkMax(CAN.driveBL, MotorType.kBrushless);
  private final CANSparkMax BR = new CANSparkMax(CAN.driveBR, MotorType.kBrushless);
  public Drivetrain() {
    
    FL.restoreFactoryDefaults();
    FR.restoreFactoryDefaults();
    BL.restoreFactoryDefaults();
    BR.restoreFactoryDefaults();

    BL.follow(FL);
    BR.follow(FR);

    FL.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

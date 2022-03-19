// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;




/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  private final Climber climber = new Climber();
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Shooter shooter = new Shooter();

  private final CommandXboxController controller = new CommandXboxController(0);

  private final Command driveCommand =
      new RunCommand(
          () -> drivetrain.arcadeDrive(controller.getLeftY(), -controller.getRightX()),
          drivetrain);

  // private final InstantCommand eat = new InstantCommand(() -> intake.extend());

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    drivetrain.setDefaultCommand(driveCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // controller.leftBumper().whileHeld(() -> intake.setBooperVoltage(0.5)).whenReleased(() -> intake.setBooperVoltage(0));
    // controller.a().whileHeld(() -> intake.setIntakeVoltage(0.5)).whenReleased(() -> intake.setIntakeVoltage(0));
    // if (controller.getRawButtonPressed(Constants.XBOX.BUMPER_LEFT)){
    //   intake.setBooperVoltage(0.5);
    // }
    // else{
    //   intake.setBooperVoltage(0);
    // }

    controller.rightBumper().whenPressed(() -> intake.extend()).whenReleased(() -> intake.retract());
    controller.leftBumper().whenPressed(() -> shooter.boop()).whenReleased(() -> shooter.noBoop());
    controller.x().whenPressed(() -> climber.pullUp(0.1));

    // controller.a().whenPressed(() -> intake.setIntakeVoltage());
    // controller.b().whenPressed(() -> shooter.setShooterVoltage(0.8)).whenReleased(() -> shooter.setShooterVoltage(0));
    // intake.setIntakeVoltage(controller.getRightTriggerAxis());
    // shooter.setShooterVoltage(controller.getLeftTriggerAxis());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}

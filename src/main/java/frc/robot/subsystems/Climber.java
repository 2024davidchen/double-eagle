package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.CAN;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.CommandXboxController;

public class Climber extends SubsystemBase {
  private final CANSparkMax climber = new CANSparkMax(CAN.climberID, MotorType.kBrushless);
  private final CommandXboxController controller = new CommandXboxController(0);

  /** Creates a new Climber. */
  public Climber() {
    
    climber.restoreFactoryDefaults();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    climber.set(controller.getRightTriggerAxis() * 0.2);
    
  }

  public void pullUp(double speed){
    climber.set(-1 * speed);
  }
}


package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private XboxController m_leftStick;
  private XboxController m_rightStick;
  private static final int leftDeviceID = 3; 
  private static final int rightDeviceID = 5;
  private CANSparkMax m_leftMotor;
  private CANSparkMax m_rightMotor;
  private RelativeEncoder m_leftEncoder;
  private RelativeEncoder m_rightEncoder;
  private double leftpre;
  private double rightpre;

  @Override
  public void robotInit() {
 
    m_leftMotor = new CANSparkMax(leftDeviceID, MotorType.kBrushless);
    m_rightMotor = new CANSparkMax(rightDeviceID, MotorType.kBrushless);

    m_leftMotor.restoreFactoryDefaults();
    m_rightMotor.restoreFactoryDefaults();

    m_myRobot = new DifferentialDrive(m_leftMotor, m_rightMotor);

    m_leftStick = new XboxController(0);
    m_rightStick = new XboxController(0);

    m_leftEncoder = m_leftMotor.getEncoder();
    m_rightEncoder = m_rightMotor.getEncoder();

  
  }

  @Override
  public void teleopPeriodic() {
    leftpre = m_leftStick.getRawAxis(1) * 0.5;
    rightpre = m_rightStick.getRawAxis(5) * -0.5;
    
    m_myRobot.tankDrive(leftpre,rightpre);

  }
}

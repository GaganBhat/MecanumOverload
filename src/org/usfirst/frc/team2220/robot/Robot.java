package org.usfirst.frc.team2220.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;


/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're
 * inexperienced, don't. Unless you know what you are doing, complex code will
 * be much more difficult under this system. Use IterativeRobot or Command-Based
 * instead if you're new.
 */

public class Robot extends SampleRobot {
	//Motor Variables
	CANTalon leftMotor = new CANTalon(1);
	CANTalon leftMotor1 = new CANTalon(2);
	CANTalon rightMotor = new CANTalon(3);
	CANTalon rightMotor1 = new CANTalon(4);
	
	/*Solenoid Variables
	public Solenoid rightSol1 = new Solenoid(6);
	public Solenoid rightSol2 = new Solenoid(7);
	public Solenoid leftSol1 = new Solenoid(4);
	public Solenoid leftSol2 = new Solenoid(5); */
	
	//Buttons
	
	
	// operations
	Joystick leftStick = new Joystick(0); // set to ID 1 in DriverStation
	//Button leftBumper = new JoystickButton(leftStick, 5);
	//Button rightBumper = new JoystickButton(leftStick, 6);
	
	//MecanumDrive
	//RobotDrive mecanumDrive = new RobotDrive(leftMotor, leftMotor1, rightMotor, rightMotor1);
	
	public boolean tankDriveEnabled; //Tank Drive Enabled? 
	
	public Robot() {
		//myRobot.setExpiration(0.1);
		Compressor aCompressor = new Compressor();
		aCompressor.start();
		
	}

	private double deadzone(double output, double threshold) {
		if (output <= threshold && output >= - threshold) {
			return 0.;
			
		}
		return output;
	}
	/**
	 * Runs the motors with tank steering.
	 */
	@Override
	public void operatorControl() {
		//myRobot.setSafetyEnabled(true);
		//leftMotor1.changeControlMode(CANTalon.TalonControlMode.Follower);
		//rightMotor1.changeControlMode(CANTalon.TalonControlMode.Follower);
		//leftMotor1.set(leftMotor.getDeviceID());
		//rightMotor1.set(rightMotor.getDeviceID());
		
		//Undo commentation if call not working
		/*rightSol1.set(true); // True means Tank Drive
		rightSol2.set(false); // Opposite of rightSol1
		
		leftSol1.set(true); //True means Tank Drive
		leftSol2.set(false); //Opposite of new leftSol1*/
		
	//	leftBumper.toggleWhenPressed(DriveTrainSolenoids.tankDrive()); //Enables Tank Drive solenoid
		
		//rightBumper.toggleWhenPressed(DriveTrainSolenoids.mecanumDrive()); //Enables Mecanum Drive solenoid
		
		while (isOperatorControl() && isEnabled()) {
			double leftOutput = leftStick.getRawAxis(1);
			double rightOutput = leftStick.getRawAxis(5);
			
			leftOutput = deadzone(leftOutput, 0.2);
			rightOutput = deadzone(rightOutput, 0.2);
			
			leftMotor.set(leftOutput);
			rightMotor.set(-rightOutput);
			leftMotor1.set(leftOutput);
			rightMotor1.set(-rightOutput);
			
			/*if (DriveTrainSolenoids.tankDriveEnabled == true) {
			
			//myRobot.tankDrive(leftStick, rightStick);
			leftMotor.set(leftOutput);
			rightMotor.set(-rightOutput);
			leftMotor1.set(leftOutput);
			rightMotor1.set(-rightOutput);
			Timer.delay(0.005); // wait for a motor update time
			
			} else {
				
			mecanumDrive.mecanumDrive_Polar(rightOutput, rightOutput, 0);
			//mecanumDrive.mecanumDrive_Cartesian(leftOutput, rightOutput, 0, 0);
				
			}*/
		}
	}
}

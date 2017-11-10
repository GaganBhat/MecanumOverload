package org.usfirst.frc.team2220.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTrainSolenoids extends Command{
	public static Solenoid leftSol1 = new Solenoid(4);
	public static Solenoid leftSol2 = new Solenoid(5);
	public static Solenoid rightSol1 = new Solenoid(6);
	public static Solenoid rightSol2 = new Solenoid(7);
	
	static boolean tankDriveEnabled; 
	
	public static Command tankDrive() {
		
		tankDriveEnabled = true;
		
		rightSol1.set(true); // True means Tank Drive
		rightSol2.set(false); // Opposite of rightSol1
		
		leftSol1.set(true); //True means Tank Drive
		leftSol2.set(false); //Opposite of new leftSol1
		return null;
		
	}
	
	public static Command mecanumDrive() {
		
		tankDriveEnabled = false;
		
		rightSol1.set(false); // False means Mecanum Drive
		rightSol2.set(true); // Opposite of rightSol1
		
		leftSol1.set(false); //False means Tank Drive
		leftSol2.set(true); //Opposite of new leftSol1
		return null;
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}

package org.usfirst.frc.team6171.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Teleop {
	private DriveTrain drivetrain;
	private OI oi;
	private boolean bIsPressed, reverse;
	public double sensitivity;
	private boolean turning = false;
	private Lights lites;
	public Teleop(DriveTrain dt, OI O) {
		drivetrain = dt;
		oi = O;
		lites =new Lights(oi);
	}
	
	
	
	public void init() 
	{
				            
	}
public void drive() {
		
		turning = Math.abs(oi.getDriveRightX()) >0.1;
		if(oi.getDriveLeftTrigger()>0.5 && oi.getDriveRightTrigger()>0.5)
			sensitivity = 0.4;
		else if(turning)
			 sensitivity = 0.6;
		else 
			 sensitivity = .8;
		 
			
		//A button pressed --> reverse direction
		if(oi.getB()) {
			bIsPressed = true;
			lites.confetti();
		}
		if(bIsPressed && !oi.getB()) {
			bIsPressed = false;
			reverse = !reverse;
			lites.sinelon();
			
		}
		if(reverse) {
			System.out.println("reversed");
		}
		else
		{
			System.out.println("not reversed");
		}
		
			if(reverse) {
			//reverses by multiplying by -1 and reversing left/right output
				drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY() + oi.getDriveRightX())*-1 *sensitivity);
				drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY() - oi.getDriveRightX()) *-1 *sensitivity);	
			}
			else {
				//forward Percent Output drive
				drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY() - oi.getDriveRightX()) *sensitivity);
				drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY() + oi.getDriveRightX()) *sensitivity);	
			}
}
public void driveSaitek() {
	System.out.println(oi.getSaitekZ());
	sensitivity = Math.abs(oi.getSaitekZ());
	//turning = Math.abs(oi.getDriveRightX()) >0.1;
	//if(oi.getDriveLeftTrigger()>0.5 && oi.getDriveRightTrigger()>0.5)
	//	sensitivity = 0.4;
	//else if(turning)
	//	 sensitivity = 0.6;
	//else 
	//	 sensitivity = .8;
	 
		
	//A button pressed --> reverse direction
	if(oi.saitek.getRawButton(1)) {
		bIsPressed = true;
		lites.confetti();
	}
	if(bIsPressed && !oi.saitek.getRawButton(1)) {
		bIsPressed = false;
		reverse = !reverse;
		lites.sinelon();
		
	}
	if(reverse) {
		System.out.println("reversed");
		
	}
	else
	{
		System.out.println("not reversed");
		
	}
	
		if(reverse) {
		//reverses by multiplying by -1 and reversing left/right output
			drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getSaitekY() + oi.getSaitekX())*-1 *sensitivity);
			drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getSaitekY() - oi.getSaitekX()) *-1 *sensitivity);	
		}
		else {
			//forward Percent Output drive
			drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getSaitekY() - oi.getSaitekX()) *sensitivity);
			drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getSaitekY() + oi.getSaitekX()) *sensitivity);	
		}
}
public void driveSaitekZRotate() {
	System.out.println(oi.getSaitekZ());
	sensitivity = Math.abs(oi.getSaitekZ());
	//turning = Math.abs(oi.getDriveRightX()) >0.1;
	//if(oi.getDriveLeftTrigger()>0.5 && oi.getDriveRightTrigger()>0.5)
	//	sensitivity = 0.4;
	//else if(turning)
	//	 sensitivity = 0.6;
	//else 
	//	 sensitivity = .8;
	 
		
	//A button pressed --> reverse direction
	if(oi.saitek.getRawButton(1)) {
		bIsPressed = true;
		lites.confetti();
	}
	if(bIsPressed && !oi.saitek.getRawButton(1)) {
		bIsPressed = false;
		reverse = !reverse;
		lites.sinelon();
		
	}
	if(reverse) {
		System.out.println("reversed");
		
	}
	else
	{
		System.out.println("not reversed");
		
	}
	
		if(reverse) {
		//reverses by multiplying by -1 and reversing left/right output
			drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getSaitekY() + oi.getSaitekZRotate())*-1 *sensitivity);
			drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getSaitekY() - oi.getSaitekZRotate()) *-1 *sensitivity);	
		}
		else {
			//forward Percent Output drive
			drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getSaitekY() - oi.getSaitekZRotate()) *sensitivity);
			drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getSaitekY() + oi.getSaitekZRotate()) *sensitivity);	
		}
}
}

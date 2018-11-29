package org.usfirst.frc.team6171.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;  
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lights 
{
	
	private Spark spark; 
	private OI oi;
	private boolean confetti, sinelon;
	
	
	public Lights(OI o)
	{
		oi = o;
		spark = new Spark(0);
		spark.set(0);
		confetti = false;
		sinelon = false;
		
	}
	public void init()
	{
		confetti = oi.drive.getRawButton(OI.A_NUM);
		sinelon = oi.drive.getRawButton(OI.Y_NUM);
		if(confetti)confetti();
		if(sinelon)sinelon();
	}
		
	
	
	
	public void confetti()
	{
		spark.set(-.63);
	}
	public void sinelon()
	{
		spark.set(-0.41);
	}


	
}


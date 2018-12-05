package org.usfirst.frc.team6171.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDTest {

	private double p,i,d;
	private TalonSRX motor;
	private OI oi;
	private SmartDashboard smd;
	private LiveWindow lw;
	
	public PIDTest(OI o)
	{
		motor = new TalonSRX(0);
		oi = o;
		p = 0;
		i = 0;
		d = 0;
		//motor.config_kF(0, f, 0);
		motor.config_kP(0, p, 0);
		motor.config_kI(0, i, 0);
		motor.config_kD(0, d, 0);
		
		SmartDashboard.putNumber("PID error", motor.getClosedLoopError(0));
	}
	
	public void pidtester()
	{
		motor.set(ControlMode.PercentOutput, 0);
		if(oi.getA())
		{
			motor.set(ControlMode.Disabled,0);
		}
		SmartDashboard.updateValues();
	}
}

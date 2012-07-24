package com.example.scontroll;

import android.app.Application;

public class test1 extends Application{
	
	private int velocityAngle = -130;
	private int batteryAngle = -120;
	private int fuelAngle = 120;
	private int coolantAngle = -145;

	public int getVelocityAngle() {
		return velocityAngle;
	}

	public void setVelocityAngle(int velocityAngle) {
		this.velocityAngle = velocityAngle;
	}
	
	public int getbatteryAngle() {
		return batteryAngle;
	}

	public void setbatteryAngle(int batteryAngle) {
		this.batteryAngle = batteryAngle;
	}
	
	public int getfuelAngle() {
		return fuelAngle;
	}

	public void setfuelAngle(int fuelAngle) {
		this.fuelAngle = fuelAngle;
	}
	
	public int getcoolantAngle() {
		return coolantAngle;
	}

	public void setcoolantAngle(int coolantAngle) {
		this.coolantAngle = coolantAngle;
	}

}

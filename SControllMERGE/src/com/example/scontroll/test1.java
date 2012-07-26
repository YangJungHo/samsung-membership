package com.example.scontroll;

import android.app.Application;

public class test1 extends Application{
	
	private int velocityAngle = -130;
	private int batteryAngle = -120;
	private int fuelAngle = 120;
	private int coolantAngle = -145;
	private int velocityX = 0;
	//private int velocityY = 0;
	private int batteryX = -397;
	private int batteryY = -442;
	private int fuelX = 0;
	private int fuelY = 0;
	private int rpmX = 410;
	private int rpmY = -450;
	

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
	
	public int getVelocityX() {
		return velocityX;
	}
	
	public void setVelocityX(int velocityX){
		this.velocityX = velocityX;
	}
	
	public int getBatteryX() {
		return batteryX;
	}
	
	public void setBatteryX(int batteryX){
		this.batteryX = batteryX;
	}
	
	public int getBatteryY() {
		return batteryY;
	}
	
	public void setBatteryY(int batteryY){
		this.batteryY = batteryY;
	}
	public int getFuelX() {
		return fuelX;
	}
	
	public void setFuelX(int fuelX){
		this.fuelX = fuelX;
	}
	
	public int getFuelY() {
		return fuelY;
	}
	
	public void setfuelY(int fuelY){
		this.fuelY = fuelY;
	}
	public int getRpmX() {
		return rpmX;
	}
	
	public void setRpmX(int rpmX){
		this.rpmX = rpmX;
	}
	
	public int getRpmY() {
		return rpmY;
	}
	
	public void setRpmY(int rpmY){
		this.rpmY = rpmY;
	}
	


}

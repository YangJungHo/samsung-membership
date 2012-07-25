package com.example.scontroll;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.SeekBar;



public class MainActivity extends Activity {
	
	
	SeekBar testbar1,testbar2,testbar3,testbar4;
	

	
	private test1 mTest;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);   // 프로그램의 타이틀 없애기
		setContentView(R.layout.activity_main);
		
		SMyView vw = new SMyView(this);
		fuel fuelGauge = new fuel(this);
		Battery batteryGauge = new Battery(this);
		coolant coolantGauge = new coolant(this);    
		rpm rpmGauge = new rpm(this);
		addContentView(vw, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT) );  
		addContentView(batteryGauge, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT) );  
		addContentView(fuelGauge, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT) );  
		addContentView(coolantGauge, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT) );  
		addContentView(rpmGauge, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT) );  
        
		mTest = (test1)this.getApplicationContext();
		
		testbar1 = (SeekBar)findViewById(R.id.seekBar1);
		testbar2 = (SeekBar)findViewById(R.id.SeekBar2);
		testbar3 = (SeekBar)findViewById(R.id.SeekBar3);
		testbar4 = (SeekBar)findViewById(R.id.SeekBar4);
        testbar1.setOnSeekBarChangeListener(
        		new SeekBar.OnSeekBarChangeListener() {
			
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				//velocityAngle = ((progress*3)-130);
				mTest.setVelocityAngle((progress*3)-130);
				
				if(mTest.getVelocityAngle() >=131){
					mTest.setVelocityAngle(130);
				}
				
			}
		});
        testbar2.setOnSeekBarChangeListener(
        		new SeekBar.OnSeekBarChangeListener() {
			
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				mTest.setbatteryAngle((progress)-120);
				if(mTest.getbatteryAngle() >= -30){
					mTest.setbatteryAngle(-30);
				}
				
			}
		});
        testbar3.setOnSeekBarChangeListener(
        		new SeekBar.OnSeekBarChangeListener() {
			
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				mTest.setfuelAngle((-progress)+120);
				if(mTest.getfuelAngle() <=25){
					mTest.setfuelAngle(25);
				}
				
			}
		});
        testbar4.setOnSeekBarChangeListener(
        		new SeekBar.OnSeekBarChangeListener() {
			
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				mTest.setcoolantAngle((-progress)-145);
				if(mTest.getcoolantAngle() <=-215){
					mTest.setcoolantAngle(-125);
				}
				
			}
		});
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

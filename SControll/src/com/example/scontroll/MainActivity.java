package com.example.scontroll;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.SeekBar;



public class MainActivity extends Activity {
	
	
	SeekBar testbar1,testbar2,testbar3,testbar4;
	int velocityAngle = -130;
	int batteryAngle = -120;
	int fuelAngle = 120;
	int coolantAngle = -145;
		
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);   // 프로그램의 타이틀 없애기
		setContentView(R.layout.activity_main);
		
		MyView vw = new MyView(this);
		fuel fuelGauge = new fuel(this);
		Battery batteryGauge = new Battery(this);
		coolant coolantGauge = new coolant(this);    
		addContentView(vw, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT) );  
		addContentView(batteryGauge, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT) );  
		addContentView(fuelGauge, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT) );  
		addContentView(coolantGauge, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT) );  
        
        
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
				velocityAngle = ((progress*3)-130);
				if(velocityAngle >=131){
					velocityAngle =130;
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
				batteryAngle = ((progress)-120);
				if(batteryAngle >=-30){
					batteryAngle =-30;
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
				fuelAngle = ((-progress)+120);
				if(fuelAngle <=25){
					fuelAngle =25;
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
				coolantAngle = ((-progress)-145);
				if(coolantAngle <=-215){
					coolantAngle =-215;
				}
				
			}
		});
    }
    
    protected class MyView extends View {
    	
    	int count = 0;

		public MyView(Context context) {
             super(context);
             
             timer.sendEmptyMessageDelayed(0, 10);
        }
    
        public void onDraw(Canvas canvas) {

             int CenterX = getWidth() / 2;	// X오리진
             int CenterY = (getHeight() / 2) - 100;	//	Y오리진
             int NeedleWidth  = 0;                 
             int NeedleHeight = 0;
             int GaugeWidth  = 0;
             int GaugeHeight = 0;

             Paint paint = new Paint();
             paint.setColor(Color.RED);	// 회전축(원) 표시색 RED                 
             paint.setStyle(Paint.Style.STROKE);	// 회전축(원) 외곽선만 그린다.
             
             Bitmap Needle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
             Bitmap backGround  = BitmapFactory.decodeResource(getResources(), R.drawable.background2);
             Bitmap NeedleResize = Bitmap.createScaledBitmap(Needle, 40, 140, true);
             Bitmap GaugeResize  = Bitmap.createScaledBitmap(backGround, 370, 370, true);
             
             NeedleWidth  = NeedleResize.getWidth() / 2;	// 회전축 계산
             NeedleHeight = NeedleResize.getHeight();
             GaugeWidth  = GaugeResize.getWidth() / 2;
             GaugeHeight = GaugeResize.getHeight() / 2;
             
             canvas.drawBitmap(GaugeResize, CenterX - GaugeWidth, CenterY - GaugeHeight, null); //	속도게이지 배치 
             canvas.drawCircle(CenterX, CenterY, 120, paint);	// 회전축을 빨간 원으로 표시
             canvas.rotate(velocityAngle, CenterX, CenterY);	// Canvas를 중심점을 회전축으로 angle각도만큼  회전 
             canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY -(NeedleHeight+50), null);	// 중심점에 이미지 끝이 오도록 출력
             

             

      } // onDraw
        
        
        Handler timer = new Handler() {               // 타이머로 사용할 Handler
            public void handleMessage(Message msg) {
                     invalidate();                                       // onDraw() 다시 실행
                     timer.sendEmptyMessageDelayed(0, 10);      // 10/1000초마다 실행
            }
        }; // Handler
     } // class */
    
    protected class Battery extends View{
    	
    	public Battery(Context context) {
            super(context);
       }    	
    	public void onDraw(Canvas canvas){
    		
    		int CenterX = (getWidth() / 2)-397;
            int CenterY = (getWidth() / 2)-442;
            int NeedleWidth  = 0;
            int NeedleHeight = 0;
            
            Paint paint = new Paint();
            paint.setColor(Color.RED);	// 회전축(원) 표시색 RED                 
            paint.setStyle(Paint.Style.STROKE);	// 회전축(원) 외곽선만 그린다.
            
            Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
            Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25, true);
            
            NeedleWidth  = NeedleResize.getWidth() / 2;
            NeedleHeight = NeedleResize.getHeight() /2;
            
            canvas.drawCircle(CenterX, CenterY, 44, paint);	// 회전축을 빨간 원으로 표시
            canvas.rotate(batteryAngle, CenterX, CenterY);	// Canvas를 중심점을 회전축으로 angle각도만큼  회전 
            canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	속도게이지 배치
    	}
    	
    }// class
    
    protected class fuel extends View{
    	
    	public fuel(Context context) {
            super(context);
       }    	
    	public void onDraw(Canvas canvas){
    		
    		int CenterX = (getWidth() / 2)-397;
            int CenterY = (getWidth() / 2)-442;
            int NeedleWidth  = 0;
            int NeedleHeight = 0;
            
            Paint paint = new Paint();
            paint.setColor(Color.RED);	// 회전축(원) 표시색 RED                 
            paint.setStyle(Paint.Style.STROKE);	// 회전축(원) 외곽선만 그린다.
            
            Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
            Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25, true);
            
            NeedleWidth  = NeedleResize.getWidth() / 2;
            NeedleHeight = NeedleResize.getHeight() /2;
            
            canvas.drawCircle(CenterX, CenterY, 44, paint);	// 회전축을 빨간 원으로 표시
            canvas.rotate(fuelAngle, CenterX, CenterY);	// Canvas를 중심점을 회전축으로 angle각도만큼  회전 
            canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	속도게이지 배치
    	}
    	
    }// class
    
    protected class coolant extends View{
    	
    	public coolant(Context context) {
            super(context);
       }    	
    	public void onDraw(Canvas canvas){
    		
    		int CenterX = (getWidth() / 2)-397;
            int CenterY = (getWidth() / 2)-442;
            int NeedleWidth  = 0;
            int NeedleHeight = 0;
            
            Paint paint = new Paint();
            paint.setColor(Color.RED);	// 회전축(원) 표시색 RED                 
            paint.setStyle(Paint.Style.STROKE);	// 회전축(원) 외곽선만 그린다.
            
            Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
            Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25, true);
            
            NeedleWidth  = NeedleResize.getWidth() / 2;
            NeedleHeight = NeedleResize.getHeight() /2;
            
            canvas.drawCircle(CenterX, CenterY, 44, paint);	// 회전축을 빨간 원으로 표시
            canvas.rotate(coolantAngle, CenterX, CenterY);	// Canvas를 중심점을 회전축으로 angle각도만큼  회전 
            canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	속도게이지 배치
    	}
    	
    }// class



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

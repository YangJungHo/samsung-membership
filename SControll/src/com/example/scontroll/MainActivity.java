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
        //requestWindowFeature(Window.FEATURE_NO_TITLE);   // ���α׷��� Ÿ��Ʋ ���ֱ�
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

             int CenterX = getWidth() / 2;	// X������
             int CenterY = (getHeight() / 2) - 100;	//	Y������
             int NeedleWidth  = 0;                 
             int NeedleHeight = 0;
             int GaugeWidth  = 0;
             int GaugeHeight = 0;

             Paint paint = new Paint();
             paint.setColor(Color.RED);	// ȸ����(��) ǥ�û� RED                 
             paint.setStyle(Paint.Style.STROKE);	// ȸ����(��) �ܰ����� �׸���.
             
             Bitmap Needle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
             Bitmap backGround  = BitmapFactory.decodeResource(getResources(), R.drawable.background2);
             Bitmap NeedleResize = Bitmap.createScaledBitmap(Needle, 40, 140, true);
             Bitmap GaugeResize  = Bitmap.createScaledBitmap(backGround, 370, 370, true);
             
             NeedleWidth  = NeedleResize.getWidth() / 2;	// ȸ���� ���
             NeedleHeight = NeedleResize.getHeight();
             GaugeWidth  = GaugeResize.getWidth() / 2;
             GaugeHeight = GaugeResize.getHeight() / 2;
             
             canvas.drawBitmap(GaugeResize, CenterX - GaugeWidth, CenterY - GaugeHeight, null); //	�ӵ������� ��ġ 
             canvas.drawCircle(CenterX, CenterY, 120, paint);	// ȸ������ ���� ������ ǥ��
             canvas.rotate(velocityAngle, CenterX, CenterY);	// Canvas�� �߽����� ȸ�������� angle������ŭ  ȸ�� 
             canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY -(NeedleHeight+50), null);	// �߽����� �̹��� ���� ������ ���
             

             

      } // onDraw
        
        
        Handler timer = new Handler() {               // Ÿ�̸ӷ� ����� Handler
            public void handleMessage(Message msg) {
                     invalidate();                                       // onDraw() �ٽ� ����
                     timer.sendEmptyMessageDelayed(0, 10);      // 10/1000�ʸ��� ����
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
            paint.setColor(Color.RED);	// ȸ����(��) ǥ�û� RED                 
            paint.setStyle(Paint.Style.STROKE);	// ȸ����(��) �ܰ����� �׸���.
            
            Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
            Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25, true);
            
            NeedleWidth  = NeedleResize.getWidth() / 2;
            NeedleHeight = NeedleResize.getHeight() /2;
            
            canvas.drawCircle(CenterX, CenterY, 44, paint);	// ȸ������ ���� ������ ǥ��
            canvas.rotate(batteryAngle, CenterX, CenterY);	// Canvas�� �߽����� ȸ�������� angle������ŭ  ȸ�� 
            canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	�ӵ������� ��ġ
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
            paint.setColor(Color.RED);	// ȸ����(��) ǥ�û� RED                 
            paint.setStyle(Paint.Style.STROKE);	// ȸ����(��) �ܰ����� �׸���.
            
            Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
            Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25, true);
            
            NeedleWidth  = NeedleResize.getWidth() / 2;
            NeedleHeight = NeedleResize.getHeight() /2;
            
            canvas.drawCircle(CenterX, CenterY, 44, paint);	// ȸ������ ���� ������ ǥ��
            canvas.rotate(fuelAngle, CenterX, CenterY);	// Canvas�� �߽����� ȸ�������� angle������ŭ  ȸ�� 
            canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	�ӵ������� ��ġ
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
            paint.setColor(Color.RED);	// ȸ����(��) ǥ�û� RED                 
            paint.setStyle(Paint.Style.STROKE);	// ȸ����(��) �ܰ����� �׸���.
            
            Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
            Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25, true);
            
            NeedleWidth  = NeedleResize.getWidth() / 2;
            NeedleHeight = NeedleResize.getHeight() /2;
            
            canvas.drawCircle(CenterX, CenterY, 44, paint);	// ȸ������ ���� ������ ǥ��
            canvas.rotate(coolantAngle, CenterX, CenterY);	// Canvas�� �߽����� ȸ�������� angle������ŭ  ȸ�� 
            canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	�ӵ������� ��ġ
    	}
    	
    }// class



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

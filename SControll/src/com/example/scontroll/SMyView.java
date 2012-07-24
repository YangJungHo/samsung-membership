package com.example.scontroll;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class SMyView extends View{
	int count = 0;
	private test1 mTest;
	
	public SMyView(Context context) {
         super(context);
         mTest = (test1)context.getApplicationContext();
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
		 canvas.rotate(mTest.getVelocityAngle(), CenterX, CenterY);	// Canvas를 중심점을 회전축으로 angle각도만큼  회전 
         canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY -(NeedleHeight+50), null);	// 중심점에 이미지 끝이 오도록 출력
         

  } // onDraw
    
    
    Handler timer = new Handler() {               // 타이머로 사용할 Handler
        public void handleMessage(Message msg) {
                 invalidate();                                       // onDraw() 다시 실행
                 timer.sendEmptyMessageDelayed(0, 10);      // 10/1000초마다 실행
        }
    }; // Handler

}

class Battery extends View{
	private test1 mTest;

	public Battery(Context context) {
		super(context);
		mTest = (test1)context.getApplicationContext();
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
		canvas.rotate(mTest.getbatteryAngle(), CenterX, CenterY);	// Canvas를 중심점을 회전축으로 angle각도만큼  회전 
		canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	속도게이지 배치
		}

}

class fuel extends View{
	private test1 mTest;
	
	public fuel(Context context) {
        super(context);
        mTest = (test1)context.getApplicationContext();
        
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
        canvas.rotate(mTest.getfuelAngle(), CenterX, CenterY);	// Canvas를 중심점을 회전축으로 angle각도만큼  회전 
        canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	속도게이지 배치
	}
	
}// class

class coolant extends View{
	private test1 mTest;
	
	public coolant(Context context) {
        super(context);
        mTest = (test1)context.getApplicationContext();
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
        canvas.rotate(mTest.getcoolantAngle(), CenterX, CenterY);	// Canvas를 중심점을 회전축으로 angle각도만큼  회전 
        canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	속도게이지 배치
	}
	
}// class


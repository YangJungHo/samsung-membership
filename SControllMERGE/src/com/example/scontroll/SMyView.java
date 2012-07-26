package com.example.scontroll;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.*;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class SMyView extends View {
	int count = 0;
	private test1 mTest;

	public SMyView(Context context) {
		super(context);
		mTest = (test1) context.getApplicationContext();
		timer.sendEmptyMessageDelayed(0, 10);
	}

	public void onDraw(Canvas canvas) {

		int CenterX = (getWidth() / 2)+ mTest.getVelocityX(); // X占쏙옙占쏙옙占쏙옙
		int CenterY = (getHeight() / 2) - 100; // Y占쏙옙占쏙옙占쏙옙
		int NeedleWidth = 0;
		int NeedleHeight = 0;
		int GaugeWidth = 0;
		int GaugeHeight = 0;

		Paint paint = new Paint();
		paint.setColor(Color.RED); // 회占쏙옙占쏙옙(占쏙옙) 표占시삼옙 RED
		paint.setStyle(Paint.Style.STROKE); // 회占쏙옙占쏙옙(占쏙옙) 占쌤곤옙 占쌓몌옙占쏙옙.

		Bitmap Needle = BitmapFactory.decodeResource(getResources(),
				R.drawable.needle);
		Bitmap backGround = BitmapFactory.decodeResource(getResources(),
				R.drawable.background2);
		Bitmap NeedleResize = Bitmap.createScaledBitmap(Needle, 40, 140, true);
		Bitmap GaugeResize = Bitmap.createScaledBitmap(backGround, 370, 370,
				true);

		NeedleWidth = NeedleResize.getWidth() / 2; // 회占쏙옙占쏙옙 占쏙옙占�
		NeedleHeight = NeedleResize.getHeight();
		GaugeWidth = GaugeResize.getWidth() / 2;
		GaugeHeight = GaugeResize.getHeight() / 2;

		canvas.drawBitmap(GaugeResize, CenterX - GaugeWidth, CenterY
				- GaugeHeight, null); // 占쌈듸옙占쏙옙占쏙옙占쏙옙 占쏙옙치
		canvas.drawCircle(CenterX, CenterY, 120, paint); // 회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
															// 표占쏙옙
		canvas.rotate(mTest.getVelocityAngle(), CenterX, CenterY); // Canvas占쏙옙
																	// 占쌩쏙옙占쏙옙占쏙옙
																	// 회占쏙옙占쏙옙占쏙옙占쏙옙
																	// angle占쏙옙占쏙옙占쏙옙큼
																	// 회占쏙옙
		canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY
				- (NeedleHeight + 50), null); // 占쌩쏙옙占쏙옙占쏙옙 占싱뱄옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占�

	} // onDraw

	Handler timer = new Handler() { // 타占싱머뤄옙 占쏙옙占쏙옙占�Handler
		public void handleMessage(Message msg) {
			invalidate(); // onDraw() 占쌕쏙옙 占쏙옙占쏙옙
			timer.sendEmptyMessageDelayed(0, 10); // 10/1000占십몌옙占쏙옙 占쏙옙占쏙옙
		}
	}; // Handler

}

@SuppressLint("DrawAllocation")
class Battery extends View {
	private test1 mTest;

	public Battery(Context context) {
		super(context);
		mTest = (test1) context.getApplicationContext();
	}

	public void onDraw(Canvas canvas) {

		int CenterX = (getWidth() / 2) + mTest.getBatteryX();
		int CenterY = (getWidth() / 2) + mTest.getBatteryY();
		int NeedleWidth = 0;
		int NeedleHeight = 0;
		int subGaugeWidth = 0;
		int subGaugeHeight = 0;

		Paint paint = new Paint();
		paint.setColor(Color.RED); // 회占쏙옙占쏙옙(占쏙옙) 표占시삼옙 RED
		paint.setStyle(Paint.Style.STROKE); // 회占쏙옙占쏙옙(占쏙옙) 占쌤곤옙 占쌓몌옙占쏙옙.

		Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(),R.drawable.needle);
		Bitmap subGauge = BitmapFactory.decodeResource(getResources(),R.drawable.subgauge);
		Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25,true);
		Bitmap subGaugeResize = Bitmap.createScaledBitmap(subGauge, 315, 310,true);
		
		NeedleWidth = NeedleResize.getWidth() / 2;
		NeedleHeight = NeedleResize.getHeight() / 2;
		subGaugeWidth = subGaugeResize.getWidth() / 2 -4 ;
		subGaugeHeight = subGaugeResize.getHeight() / 2 - 7;

		canvas.drawBitmap(subGaugeResize,CenterX-subGaugeWidth, CenterY-subGaugeHeight, null);
		canvas.drawCircle(CenterX, CenterY, 44, paint); // 회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
														// 표占쏙옙
		canvas.rotate(mTest.getbatteryAngle(), CenterX, CenterY); // Canvas占쏙옙
		canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight + 130), null); // 占쌈듸옙占쏙옙占쏙옙占쏙옙 占쏙옙치
	}

}

class fuel extends View {
	private test1 mTest;

	public fuel(Context context) {
		super(context);
		mTest = (test1) context.getApplicationContext();

	}

	public void onDraw(Canvas canvas) {

		int CenterX = (getWidth() / 2) + mTest.getBatteryX();
		int CenterY = (getWidth() / 2) + mTest.getBatteryY();
		int NeedleWidth = 0;
		int NeedleHeight = 0;

		Paint paint = new Paint();
		paint.setColor(Color.RED); // 회占쏙옙占쏙옙(占쏙옙) 표占시삼옙 RED
		paint.setStyle(Paint.Style.STROKE); // 회占쏙옙占쏙옙(占쏙옙) 占쌤곤옙 占쌓몌옙占쏙옙.

		Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(),
				R.drawable.needle);
		Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25,
				true);

		NeedleWidth = NeedleResize.getWidth() / 2;
		NeedleHeight = NeedleResize.getHeight() / 2;

		canvas.drawCircle(CenterX, CenterY, 44, paint); // 회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
														// 표占쏙옙
		canvas.rotate(mTest.getfuelAngle(), CenterX, CenterY); // Canvas占쏙옙
																// 占쌩쏙옙占쏙옙占쏙옙
																// 회占쏙옙占쏙옙占쏙옙占쏙옙
																// angle占쏙옙占쏙옙占쏙옙큼
																// 회占쏙옙
		canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY
				- (NeedleHeight + 130), null); // 占쌈듸옙占쏙옙占쏙옙占쏙옙 占쏙옙치
	}

}// class

class coolant extends View {
	private test1 mTest;

	public coolant(Context context) {
		super(context);
		mTest = (test1) context.getApplicationContext();
	}

	public void onDraw(Canvas canvas) {

		int CenterX = (getWidth() / 2) + mTest.getBatteryX();
		int CenterY = (getWidth() / 2) + mTest.getBatteryY();
		int NeedleWidth = 0;
		int NeedleHeight = 0;

		Paint paint = new Paint();
		paint.setColor(Color.RED); // 회占쏙옙占쏙옙(占쏙옙) 표占시삼옙 RED
		paint.setStyle(Paint.Style.STROKE); // 회占쏙옙占쏙옙(占쏙옙) 占쌤곤옙 占쌓몌옙占쏙옙.

		Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(),
				R.drawable.needle);
		Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25,
				true);

		NeedleWidth = NeedleResize.getWidth() / 2;
		NeedleHeight = NeedleResize.getHeight() / 2;

		canvas.drawCircle(CenterX, CenterY, 44, paint); // 회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
														// 표占쏙옙
		canvas.rotate(mTest.getcoolantAngle(), CenterX, CenterY); // Canvas占쏙옙
																	// 占쌩쏙옙占쏙옙占쏙옙
																	// 회占쏙옙占쏙옙占쏙옙占쏙옙
																	// angle占쏙옙占쏙옙占쏙옙큼
																	// 회占쏙옙
		canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY
				- (NeedleHeight + 130), null); // 占쌈듸옙占쏙옙占쏙옙占쏙옙 占쏙옙치
	}

}// class

class rpm extends View {
	private test1 mTest;

	public rpm(Context context){
		super(context);
		mTest = (test1)context.getApplicationContext();

		
	}
	public void onDraw(Canvas canvas){ 
		int CenterX = (getWidth() / 2) + mTest.getRpmX();
        int CenterY = (getWidth() / 2) + mTest.getRpmY();
        int RpmWidth = 0;
        int RpmHeight = 0;
        int texstInterval = 35;
        
        

        Bitmap rpm = BitmapFactory.decodeResource(getResources(), R.drawable.wheel);
        Bitmap rpmResize = Bitmap.createScaledBitmap(rpm, 410, 330, true);
        
        RpmWidth = rpmResize.getWidth() / 2;
        RpmHeight = rpmResize.getHeight() / 2;
        
        
        canvas.drawBitmap(rpmResize, CenterX - RpmWidth, CenterY - RpmHeight, null);
        Paint Pnt = new Paint();
        Pnt.setColor(Color.LTGRAY);	// 회占쏙옙占쏙옙(占쏙옙) 표占시삼옙 RED
        Pnt.setTypeface(Typeface.create(Typeface.SERIF,Typeface.NORMAL));
        Pnt.setTextSize(19);
        Pnt.setTextAlign(Paint.Align.CENTER);
        	
        Pnt.setPathEffect(new CornerPathEffect(10));
        Pnt.setColor(Color.LTGRAY);	// 회占쏙옙占쏙옙(占쏙옙) 표占시삼옙 RED
        //String line1 = "占쏙옙占쏙옙占쏙옙占쏙옙占�;
        //String line2 = "占쏙옙占쏙옙占쏙옙占쏙옙";
        //String line3 = "占쌕쇽옙占쏙옙占쏙옙占쏙옙占�;
        //String line4 = "占쏙옙占쏙옙占쏙옙占쏙옙占�;
        //String line5 = "占쏙옙占쌌냉곤옙占쏙옙占쏙옙占�;

        //canvas.drawText(line1, CenterX, CenterY-texstInterval, Pnt);
        //canvas.drawText(line2, CenterX, CenterY+texstInterval*0, Pnt);
        //canvas.drawText(line3, CenterX, CenterY+texstInterval*1, Pnt);
        //canvas.drawText(line4, CenterX, CenterY+texstInterval*2, Pnt);
        //canvas.drawText(line5, CenterX, CenterY+texstInterval*3, Pnt);
        
        Pnt.setColor(-16728321);	// 회占쏙옙占쏙옙(占쏙옙) 표占시삼옙 RED
        Pnt.setTextSize(22);
        Pnt.setTextAlign(Paint.Align.CENTER);
        
        String leftTop = ""+mTest.getVelocityAngle();
        String leftMid = ""+mTest.getVelocityAngle();
        String leftBot = ""+mTest.getVelocityAngle();
        String rightTop = ""+mTest.getVelocityAngle();
        String rightMid = ""+mTest.getVelocityAngle();
        String rightBot = ""+mTest.getVelocityAngle();
        Pnt.setTextSize(17);
        
        canvas.drawText(leftTop, CenterX-150, CenterY-texstInterval, Pnt);
        canvas.drawText(leftMid, CenterX-150, CenterY+texstInterval*1, Pnt);
        canvas.drawText(leftBot, CenterX-150, CenterY+texstInterval*3, Pnt);
        canvas.drawText(rightTop, CenterX+150, CenterY-texstInterval, Pnt);
        canvas.drawText(rightMid, CenterX+150, CenterY+texstInterval*1, Pnt);
        canvas.drawText(rightBot, CenterX+150, CenterY+texstInterval*3, Pnt);
        
        

	}
}// class
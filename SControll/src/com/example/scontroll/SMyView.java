package com.example.scontroll;

import android.R.color;
import android.R.string;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class SMyView extends View{
	int count = 0;
	private test1 mTest;
	
	public SMyView(Context context) {
         super(context);
         mTest = (test1)context.getApplicationContext();
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
		 canvas.rotate(mTest.getVelocityAngle(), CenterX, CenterY);	// Canvas�� �߽����� ȸ�������� angle������ŭ  ȸ�� 
         canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY -(NeedleHeight+50), null);	// �߽����� �̹��� ���� ������ ���
         

  } // onDraw
    
    
    Handler timer = new Handler() {               // Ÿ�̸ӷ� ����� Handler
        public void handleMessage(Message msg) {
                 invalidate();                                       // onDraw() �ٽ� ����
                 timer.sendEmptyMessageDelayed(0, 10);      // 10/1000�ʸ��� ����
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
		paint.setColor(Color.RED);	// ȸ����(��) ǥ�û� RED                 
		paint.setStyle(Paint.Style.STROKE);	// ȸ����(��) �ܰ����� �׸���.
    
		Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
		Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25, true);
    
		NeedleWidth  = NeedleResize.getWidth() / 2;
		NeedleHeight = NeedleResize.getHeight() /2;
    
		canvas.drawCircle(CenterX, CenterY, 44, paint);	// ȸ������ ���� ������ ǥ��
		canvas.rotate(mTest.getbatteryAngle(), CenterX, CenterY);	// Canvas�� �߽����� ȸ�������� angle������ŭ  ȸ�� 
		canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	�ӵ������� ��ġ
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
        paint.setColor(Color.RED);	// ȸ����(��) ǥ�û� RED                 
        paint.setStyle(Paint.Style.STROKE);	// ȸ����(��) �ܰ����� �׸���.
        
        Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
        Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25, true);
        
        NeedleWidth  = NeedleResize.getWidth() / 2;
        NeedleHeight = NeedleResize.getHeight() /2;
        
        canvas.drawCircle(CenterX, CenterY, 44, paint);	// ȸ������ ���� ������ ǥ��
        canvas.rotate(mTest.getfuelAngle(), CenterX, CenterY);	// Canvas�� �߽����� ȸ�������� angle������ŭ  ȸ�� 
        canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	�ӵ������� ��ġ
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
        paint.setColor(Color.RED);	// ȸ����(��) ǥ�û� RED                 
        paint.setStyle(Paint.Style.STROKE);	// ȸ����(��) �ܰ����� �׸���.
        
        Bitmap velocityNeedle = BitmapFactory.decodeResource(getResources(), R.drawable.needle);
        Bitmap NeedleResize = Bitmap.createScaledBitmap(velocityNeedle, 20, 25, true);
        
        NeedleWidth  = NeedleResize.getWidth() / 2;
        NeedleHeight = NeedleResize.getHeight() /2;
        
        canvas.drawCircle(CenterX, CenterY, 44, paint);	// ȸ������ ���� ������ ǥ��
        canvas.rotate(mTest.getcoolantAngle(), CenterX, CenterY);	// Canvas�� �߽����� ȸ�������� angle������ŭ  ȸ�� 
        canvas.drawBitmap(NeedleResize, CenterX - NeedleWidth, CenterY - (NeedleHeight+130), null); //	�ӵ������� ��ġ
	}
	
}// class

class rpm extends View {
	private test1 mTest;

	public rpm(Context context){
		super(context);
		mTest = (test1)context.getApplicationContext();

		
	}
	public void onDraw(Canvas canvas){
		int CenterX = (getWidth() / 2)+410;
        int CenterY = (getWidth() / 2)-450;
        int RpmWidth = 0;
        int RpmHeight = 0;
        int texstInterval = 35;
        
        

        Bitmap rpm = BitmapFactory.decodeResource(getResources(), R.drawable.wheel);
        Bitmap rpmResize = Bitmap.createScaledBitmap(rpm, 410, 330, true);
        
        RpmWidth = rpmResize.getWidth() / 2;
        RpmHeight = rpmResize.getHeight() / 2;
        
        
        canvas.drawBitmap(rpmResize, CenterX - RpmWidth, CenterY - RpmHeight, null);
        Paint Pnt = new Paint();
        Pnt.setColor(Color.LTGRAY);	// ȸ����(��) ǥ�û� RED
        Pnt.setTypeface(Typeface.create(Typeface.SERIF,Typeface.NORMAL));
        Pnt.setTextSize(19);
        Pnt.setTextAlign(Paint.Align.CENTER);
        	
        Pnt.setPathEffect(new CornerPathEffect(10));
        Pnt.setColor(Color.LTGRAY);	// ȸ����(��) ǥ�û� RED
        //String line1 = "���������";
        //String line2 = "���������";
        //String line3 = "�ټ��������";
        //String line4 = "���������";
        //String line5 = "���ճð������";

        //canvas.drawText(line1, CenterX, CenterY-texstInterval, Pnt);
        //canvas.drawText(line2, CenterX, CenterY+texstInterval*0, Pnt);
        //canvas.drawText(line3, CenterX, CenterY+texstInterval*1, Pnt);
        //canvas.drawText(line4, CenterX, CenterY+texstInterval*2, Pnt);
        //canvas.drawText(line5, CenterX, CenterY+texstInterval*3, Pnt);
        
        Pnt.setColor(-16728321);	// ȸ����(��) ǥ�û� RED
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

